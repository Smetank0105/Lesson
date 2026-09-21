void main() {
    //1
    ArrayList<String> shoppingList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите названия товаров для списка покупок. Введите 'стоп', чтобы завершить ввод:");
    while (true) {
        System.out.print("Товар: ");
        String item = scanner.nextLine().trim();
        if (item.equalsIgnoreCase("стоп")) {
            break;
        }
        if (!item.isEmpty()) {
            shoppingList.add(item);
        }
    }

    System.out.println("\nВаш текущий список покупок:");
    if (shoppingList.isEmpty()) {
        System.out.println("- Список пуст");
    } else {
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + ". " + shoppingList.get(i));
        }
    }

    if (!shoppingList.isEmpty()) {
        System.out.print("\nВведите название товара для удаления: ");
        String toRemove = scanner.nextLine().trim();
        if (shoppingList.contains(toRemove)) {
            shoppingList.remove(toRemove);
            System.out.println("Товар \"" + toRemove + "\" удалён.");
        } else {
            System.out.println("Товар не найден");
        }
    } else {
        System.out.println("Список покупок пуст. Удаление невозможно.");
    }

    System.out.println("\nИтоговый список покупок:");
    if (shoppingList.isEmpty()) {
        System.out.println("- Список пуст");
    } else {
        for (String item : shoppingList) {
            System.out.println("- " + item);
        }
    }
    System.out.println("Размер списка: " + shoppingList.size());


    //2
    System.out.print("Введите количество слов N: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        System.out.print("Введите слово #" + (i + 1) + ": ");
        String word = scanner.nextLine();
        list.add(word);
    }

    HashSet<String> uniqueWords = new HashSet<>(list);

    System.out.println("\nРазмер исходного списка слов: " + list.size());
    System.out.println("Количество уникальных слов: " + uniqueWords.size());
    System.out.println("\nУникальные слова:");
    for (String word : uniqueWords) {
        System.out.println(word);
    }


    //3
    System.out.print("Введите предложение: ");
    String str = scanner.nextLine();
    String[] words = str.trim().split(" ");

    Map<String, Integer> wordCountMap = new HashMap<>();
    for (String word : words) {
        if (wordCountMap.containsKey(word)) {
            wordCountMap.put(word, wordCountMap.get(word) + 1);
        } else {
            wordCountMap.put(word, 1);
        }
    }

    System.out.println("Таблица «слово — количество»:");
    for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
        System.out.println(entry.getKey() + " — " + entry.getValue());
    }


    scanner.close();

    //4
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        numbers.add(i);
    }

//    for (Integer number : numbers) {
//        if (number % 2 == 0) {
//            numbers.remove(number); //
//        }
//    }
//
//    System.out.println("Осталось: " + numbers);

    Iterator<Integer> it = numbers.iterator();
    while (it.hasNext()) {
        Integer number = it.next();
        if (number % 2 == 0) {
            it.remove();
        }
    }

    System.out.println("Осталось: " + numbers);
}
