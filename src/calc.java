import java.util.Scanner;


public class calc {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        char[] temp;
        int num1 = 0, num2 = 0;

        while(true) {
            int count = 0;
            boolean roman = false;

            temp = sc.nextLine().replaceAll("\\s+","").toCharArray();
            for (char c : temp) {
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    count += 1;
                }
            }
            if (count != 1) {
                throw new Exception("Ошибка. Неверное выражение.");
            }

            if (temp[0] == 'I' || temp[0] == 'V' || temp[0] == 'X') {
                roman = true;
            }

            for (int i = 0; i < temp.length; i ++) {
                if (temp[i] == '+' || temp[i] == '-' || temp[i] == '*' || temp[i] == '/') {
                    if (roman) {
                        try {
                            switch (i) {
                                case 1 -> num1 = toArab(String.valueOf(temp[0]));
                                case 2 -> num1 = toArab(String.valueOf(temp[0]) + String.valueOf(temp[1]));
                                case 3 -> num1 = toArab(String.valueOf(temp[0]) + String.valueOf(temp[1]) + String.valueOf(temp[2]));
                                case 4 -> num1 = 8;
                                default -> {
                                    throw new Exception("Ошибка. Неверное выражение.");
                                }
                            }
                            switch (temp.length - 1 - i) {
                                case 1 -> num2 = toArab(String.valueOf(temp[temp.length-1]));
                                case 2 -> num2 = toArab(String.valueOf(temp[temp.length-2]) + String.valueOf(temp[temp.length-1]));
                                case 3 -> num2 = toArab(String.valueOf(temp[temp.length-3]) + String.valueOf(temp[temp.length-2]) + String.valueOf(temp[temp.length-1]));
                                case 4 -> num2 = 8;
                                default -> {
                                    throw new Exception("Ошибка. Неверное выражение.");
                                }
                            }
                        }
                        catch (NumberFormatException e){
                            throw new Exception("Ошибка. Складывать можно только одинаковые форматы чисел.");
                        }
                    }
                    else {
                        try {
                            switch (i) {
                                case 1 -> num1 = Integer.parseInt(String.valueOf(temp[0]));
                                case 2 -> num1 = Integer.parseInt(String.valueOf(temp[0]) + String.valueOf(temp[1]));
                                default -> {
                                    throw new Exception("Ошибка. Неверное выражение.");
                                }
                            }
                            switch (temp.length - 1 - i) {
                                case 1 -> num2 = Integer.parseInt(String.valueOf(temp[temp.length-1]));
                                case 2 -> num2 = Integer.parseInt(String.valueOf(temp[temp.length-2]) + String.valueOf(temp[temp.length-1]));
                                default -> {
                                    throw new Exception("Ошибка. Неверное выражение.");
                                }
                            }
                        }
                        catch (NumberFormatException e){
                            throw new Exception("Ошибка. Складывать можно только одинаковые форматы чисел.");
                        }
                    }

                    if (num1 > 0 && num1 < 11 && num2 > 0 && num2 < 11){
                        if (roman) {
                            System.out.println(toRoman(ops(temp[i], num1, num2)));
                        }
                        else {
                            System.out.println(ops(temp[i], num1, num2));
                        }
                    }
                    else {
                        throw new Exception("Ошибка: Числа должны быть от 1 до 10.");
                    }

                }
            }
        }
    }

    static int ops(char op, int num1, int num2) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }

    static int toArab(String num) throws Exception {
        try {
            Integer.parseInt(num);
            throw new Exception("Ошибка. Складывать можно только одинаковые форматы чисел.");
        }
        catch (Exception ignored)
        {
        }
        switch (num) {
            case "I" -> { return 1; }
            case "II" -> { return 2; }
            case "III" -> { return 3; }
            case "IV" -> { return 4; }
            case "V" -> { return 5; }
            case "VI" -> { return 6; }
            case "VII" -> { return 7; }
            case "VIII" -> { return 8; }
            case "IX" -> { return 9; }
            case "X" -> { return 10; }
            default -> {

                throw new Exception("Ошибка. Используйте римские цифры от I до X.");
            }
        }
    }

    static String toRoman(int num) throws Exception {
        switch (num) {
            case 1 -> { return "I"; }
            case 2 -> { return "II"; }
            case 3 -> { return "III"; }
            case 4 -> { return "IV"; }
            case 5 -> { return "V"; }
            case 6 -> { return "VI"; }
            case 7 -> { return "VII"; }
            case 8 -> { return "VIII"; }
            case 9 -> { return "IX"; }
            case 10 -> { return "X"; }
            case 11 -> { return "XI"; }
            case 12 -> { return "XII"; }
            case 13 -> { return "XIII"; }
            case 14 -> { return "XIV"; }
            case 15 -> { return "XV"; }
            case 16 -> { return "XVI"; }
            case 17 -> { return "XVII"; }
            case 18 -> { return "XVIII"; }
            case 19 -> { return "XIX"; }
            case 20 -> { return "XX"; }
            case 21 -> { return "XXI"; }
            case 24 -> { return "XXIV"; }
            case 25 -> { return "XXV"; }
            case 27 -> { return "XXVII"; }
            case 30 -> { return "XXX"; }
            case 35 -> { return "XXXV"; }
            case 36 -> { return "XXXVI"; }
            case 40 -> { return "XL"; }
            case 41 -> { return "XLI"; }
            case 42 -> { return "XLII"; }
            case 45 -> { return "XLV"; }
            case 48 -> { return "XLVIII"; }
            case 49 -> { return "XLIX"; }
            case 50 -> { return "L"; }
            case 54 -> { return "LIV"; }
            case 56 -> { return "LVI"; }
            case 60 -> { return "LX"; }
            case 63 -> { return "LXIII"; }
            case 64 -> { return "LXIV"; }
            case 70 -> { return "LXX"; }
            case 72 -> { return "LXXII"; }
            case 80 -> { return "LXXX"; }
            case 81 -> { return "LXXXI"; }
            case 90 -> { return "XC"; }
            case 100 -> { return "C"; }
            default -> {
                throw new Exception("Ошибка. Результат работы с римскими числами может быть только больше 0.");
            }
        }
    }
}