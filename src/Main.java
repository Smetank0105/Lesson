void main() {
    //1
    Path path = Paths.get("notes.txt");
    try {
        Files.write(path, "1. Матрица\n2. Интерстеллар\n3. Пятый элемент".getBytes(), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    String content = null;
    try {
        content = new String(Files.readAllBytes(path));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println(content);
    try {
        Files.write(path, "\n4. Довод".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    try {
        content = new String(Files.readAllBytes(path));
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println(content);

    //2
    byte[] byteArray = {1,2,3,4,5,6,7,8,9,10};

    try (FileOutputStream fos = new FileOutputStream("data.bin")) {
        fos.write(byteArray);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    try (FileInputStream fis = new FileInputStream("data.bin")) {
        byte[] readBuffer = new byte[10];
        int bytesRead = fis.read(readBuffer);
        System.out.println("Размер файла: " + bytesRead + " байтов");

        for (int i = 0; i < bytesRead; i++) {
            System.out.println("Байт " + i + ": " + (int) readBuffer[i] + " ");
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
