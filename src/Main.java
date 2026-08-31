void main() {
    //Простая
    Scanner console = new Scanner(System.in);
    System.out.print("Введите N - размер массива: ");
    int size = console.nextInt();
    System.out.println("Заполните массив.");
    double[] arr = new double[size];
    for (int i = 0; i < size; i++) {
        System.out.print("arr[" + i + "]: ");
        arr[i] = console.nextDouble();
    }

    double sum = 0;
    for (double num : arr) {
        sum += num;
    }

    double avr = sum/size;

    int count=0;
    for(double num:arr){
        if(num>avr){
            count++;
        }
    }

    System.out.println("Сумма: " + sum);
    System.out.println("Среднее арифметическое: " + avr);
    System.out.println("Кол-во элементов больше среднего: " + count);

    //Средняя
    System.out.print("Введите размеры массива MxN. M: ");
    int row = console.nextInt();
    System.out.print("N: ");
    int col = console.nextInt();

    char[][] arrChar = new char[row][col];
    System.out.println("Заполните массив char[][].");
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            System.out.print("char["+i+"]["+j+"]:");
            arrChar[i][j] = console.next().charAt(0);
        }
    }
    int letter  = 0;
    int digit = 0;
    int other = 0;

    for (int i = 0; i < arrChar.length; i++) {
        for (int j = 0; j < arrChar[i].length; j++) {
            char ch = arrChar[i][j];

            if(Character.isLetter(ch)){
                letter++;
            }else if(Character.isDigit(ch)){
                digit++;
            }else{
                other++;
            }
        }
        System.out.println("Строка "+i+": "+Arrays.toString(arrChar[i])+". Букв: "+letter+", Цифр: "+digit+", Остальных символов: "+other);
    }
}
