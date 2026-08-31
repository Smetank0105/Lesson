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

    //Сложная
    System.out.print("Введите размеры массива MxN. M: ");
    int M = console.nextInt();
    System.out.print("N: ");
    int N = console.nextInt();

    double[][] array = new double[M][N];
    System.out.println("Заполните массив double[][].");
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            System.out.print("double["+i+"]["+j+"]:");
            array[i][j] = console.nextDouble();
        }
    }
    for (int i = 0; i < array.length; i++) {
        double max = array[i][0];
        int j = 1;
        for (; j < array[i].length; j++) {
            if(array[i][j] > max){
                max = array[i][j];
            }
        }
        System.out.println("Для строки "+i+" максимальное значение равно "+max+" с индексом ["+i+"]["+(j-1)+"].");
    }
    boolean isSym = true;
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < i; j++) {
            if(Math.abs(array[i][j]-array[j][i]) > 0.00001){
                isSym = false;
                break;
            }
        }
        if(!isSym){
            break;
        }
    }
    if(isSym){
        System.out.println("Матрица симметрична.");
    }else{
        System.out.println("Матрица не симметрична.");
    }
}
