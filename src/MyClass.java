import java.util.Scanner;

public class MyClass {
    static boolean isAdult(int age){
        return age>18;
    }

    static boolean isSimple(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int checkVowels(String str){
        if (str == null) {
            return 0;
        }
        int count = 0;
        String vowels = "aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    private static int checkStr(String str){
        String digits = str.replaceAll("\\D+", "");
        if(digits.isEmpty()){
            return 0;
        }
        int number = Integer.parseInt(digits);
        if(number >= 2 && number <= 5){
            return number;
        }
        return 0;
    }

    static double getAvr(){
        int digits = 0;
        int count = 0;
        Scanner console = new Scanner(System.in);
        String str = "";
        while(!str.equals("stop")){
            System.out.print("Введите оценку от 2 до 5 (Для выхода из цикла введите stop): ");
            str = console.nextLine();
            int number = checkStr(str);
            if(number >= 2 && number <= 5){
                digits += number;
                count++;
            }
        }
        double result = 0.0;
        if(count > 0){
            result = (double)digits/count;
        }
        return result;
    }
}