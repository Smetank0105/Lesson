private static final int FILE_COUNT = 6;
private static final int WORDS_PER_FILE = 50_000;
private static final int WORDS_PER_LINE = 10;
private static final int DICTIONARY_SIZE = 40;

void main() throws InterruptedException, IOException {
    generateBooks();

    long singleStart = System.currentTimeMillis();
    ProcessingResult singleResult = processBooks(false);
    long singleTime = System.currentTimeMillis() - singleStart;

    long multiStart = System.currentTimeMillis();
    ProcessingResult multiResult = processBooks(true);
    long multiTime = System.currentTimeMillis() - multiStart;

    checkCorrectness(singleResult.counts, "однопоточный режим");
    checkCorrectness(multiResult.counts, "многопоточный режим");

    if (!singleResult.counts.equals(multiResult.counts)) {
        throw new IllegalStateException(
                "Результаты однопоточного и многопоточного режимов отличаются"
        );
    }

    System.out.println();
    System.out.println("Самое длинное слово:");
    System.out.println("  однопоточный режим:  " + singleResult.longestWord);
    System.out.println("  многопоточный режим: " + multiResult.longestWord);

    if (!singleResult.longestWord.equals(multiResult.longestWord)) {
        throw new IllegalStateException(
                "Самые длинные слова в режимах отличаются"
        );
    }

    System.out.println();
    System.out.println("Время выполнения:");
    System.out.println("  один поток:  " + singleTime + " мс");
    System.out.println("  шесть потоков: " + multiTime + " мс");

    writeTop10(multiResult.counts);

    System.out.println();
    System.out.println("Топ-10 записан в top.txt");
}
private static void generateBooks() throws IOException {
    String[] dictionary = {
            "a", "sun", "tree", "book", "java",
            "thread", "file", "reader", "writer", "map",
            "array", "class", "method", "object", "string",
            "computer", "program", "algorithm", "random", "counter",
            "synchronization", "concurrency", "performance", "monitor",
            "application", "development", "implementation", "processing",
            "information", "configuration", "communication", "calculation",
            "architecture", "parallelism", "multithreading", "optimization",
            "internationalization", "responsibility", "characterization",
            "extraordinary"
    };

    if (dictionary.length != DICTIONARY_SIZE) {
        throw new IllegalStateException("Неверный размер словаря");
    }

    Random random = new Random(12345L);

    for (int fileNumber = 1; fileNumber <= FILE_COUNT; fileNumber++) {
        Path path = Paths.get("book" + fileNumber + ".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(
                path,
                StandardCharsets.UTF_8
        )) {
            for (int wordNumber = 1; wordNumber <= WORDS_PER_FILE; wordNumber++) {
                String word = dictionary[random.nextInt(dictionary.length)];

                writer.write(word);

                if (wordNumber % WORDS_PER_LINE == 0) {
                    writer.newLine();
                } else {
                    writer.write(' ');
                }
            }
        }
    }

    System.out.println(
            "Созданы " + FILE_COUNT + " файлов по "
                    + WORDS_PER_FILE + " слов в каждом."
    );
}

private static ProcessingResult processBooks(boolean parallel)
        throws InterruptedException {

    GlobalStats globalStats = new GlobalStats();
    ProcessingRun processingRun = new ProcessingRun();

    Thread monitor = new Thread(() -> {
        while (!processingRun.done) {
            System.out.println(
                    "Обработано файлов: "
                            + globalStats.getProcessedFiles()
            );

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(
                "Обработано файлов: "
                        + globalStats.getProcessedFiles()
        );
    });

    monitor.setDaemon(true);
    monitor.start();

    List<Thread> workers = new ArrayList<>();

    for (int i = 1; i <= FILE_COUNT; i++) {
        Path path = Paths.get("book" + i + ".txt");

        FileWorker worker = new FileWorker(
                path,
                globalStats,
                processingRun
        );

        Thread thread = new Thread(worker, "worker-" + i);
        workers.add(thread);

        if (parallel) {
            thread.start();
        } else {
            thread.start();
            thread.join();
        }
    }

    if (parallel) {
        for (Thread worker : workers) {
            worker.join();
        }
    }

    processingRun.done = true;
    monitor.join();

    Throwable error = processingRun.error.get();
    if (error != null) {
        throw new RuntimeException("Ошибка в рабочем потоке", error);
    }

    Map<String, Integer> resultMap = globalStats.snapshot();

    String longestWord = processingRun.getLongestWord();

    return new ProcessingResult(resultMap, longestWord);
}

private static void checkCorrectness(
        Map<String, Integer> counts,
        String mode
) {
    int total = 0;

    for (int count : counts.values()) {
        total += count;
    }

    int expected = FILE_COUNT * WORDS_PER_FILE;

    if (total != expected) {
        throw new IllegalStateException(
                "Ошибка проверки для режима \"" + mode
                        + "\": найдено " + total
                        + ", ожидалось " + expected
        );
    }

    System.out.println(
            "Проверка " + mode + " пройдена: "
                    + total + " слов."
    );
}

private static void writeTop10(Map<String, Integer> counts)
        throws IOException {

    List<Map.Entry<String, Integer>> entries =
            new ArrayList<>(counts.entrySet());

    entries.sort(
            Comparator
                    .comparing(
                            Map.Entry<String, Integer>::getValue
                    )
                    .reversed()
                    .thenComparing(Map.Entry::getKey)
    );

    try (BufferedWriter writer = Files.newBufferedWriter(
            Paths.get("top.txt"),
            StandardCharsets.UTF_8
    )) {
        int limit = Math.min(10, entries.size());

        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = entries.get(i);

            writer.write(
                    (i + 1)
                            + ". "
                            + entry.getKey()
                            + " = "
                            + entry.getValue()
            );
            writer.newLine();
        }
    }

    System.out.println();
    System.out.println("Топ-10:");

    int limit = Math.min(10, entries.size());
    for (int i = 0; i < limit; i++) {
        Map.Entry<String, Integer> entry = entries.get(i);

        System.out.println(
                (i + 1)
                        + ". "
                        + entry.getKey()
                        + " = "
                        + entry.getValue()
        );
    }
}