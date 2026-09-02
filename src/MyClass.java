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
}