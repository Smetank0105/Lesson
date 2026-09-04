void main() {
    //Простая
    Scanner console = new Scanner(System.in);
    try {
        System.out.print("Введите делимое: ");
        int dividend = console.nextInt();
        System.out.print("Введите делитель: ");
        int divisor = console.nextInt();
        int result = dividend / divisor;
        System.out.println("Результат деления: " + result);
    } catch (ArithmeticException e) {
        System.out.println("На ноль делить нельзя.");
    } finally {
        console.close();
    }

    //Средняя
    console = new Scanner(System.in);
    int number = 0;
    boolean correctInput = false;
    while (!correctInput) {
        System.out.print("Введите число: ");
        String input = console.nextLine();
        try {
            number = Integer.parseInt(input);
            correctInput = true;
        } catch (NumberFormatException e) {
            System.out.println("Введено не число.");
        }
    }
    System.out.println("Вы ввели число: " + number);
    console.close();

    //Сложная
    console = new Scanner(System.in);
    int[] arr = {10, 20, 30, 40, 50};
    try {
        System.out.print("Введите индекс массива (0-4): ");
        int index = console.nextInt();
        System.out.print("Введите делитель: ");
        int divisor = console.nextInt();
        int result = arr[index] / divisor;
        System.out.println("Результат деления: "+result);
    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Индекс вне границ массива.");
    }catch (ArithmeticException e){
        System.out.println("Делить на ноль нельзя.");
    }finally {
        System.out.println("Попытка обработки завершена.");
        console.close();
    }
}
