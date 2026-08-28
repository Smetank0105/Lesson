void main() {
    //Чётная в диапазоне
    Scanner console = new Scanner(System.in);
    System.out.print("Введите первое число: ");
    int a = console.nextInt();
    System.out.print("Введите второе число: ");
    int b = console.nextInt();
    System.out.println("Чётные в диапазоне от "+a+" до "+b+":");
    for (int i = (a<b?a:b); i <= (a>b?a:b); i++) {
        if(i%2==0){
            System.out.print(i+" ");
        }
    }

    //Числа Фибоначчи с условием
    int n;
    do{
        System.out.print("\nВведите число больше 1: ");
        n = console.nextInt();
    }while(n < 2);
    System.out.println("Последовательность Фиббоначи для числа "+n);
    System.out.println(0);
    System.out.println(1);
    a = 0;
    b = 1;
    for (int i = 2; i <= n; i++) {
        int result = a + b;
        System.out.println(result);
        a = b;
        b = result;
    }

    //Проверка на простоту с подсётом
    boolean isSimple;
    int count = 0;
    int sum =0;
    do {
        System.out.println("Введите число больше 1: ");
        n = console.nextInt();
    }while(n < 2);
    for (int i = 2; i <= n; i++) {
        isSimple = true;
        for (int j = 2; j*j <= i; j++) {
            if(i%j == 0){
                isSimple = false;
                break;
            }
            count++;
        }
        sum += (isSimple?i:0);
        System.out.println("Число "+i+(isSimple?" простое.":" составное."));
    }
    System.out.println("Всего простых чисел было "+count+", а их сумма = "+sum);
    console.close();
}
