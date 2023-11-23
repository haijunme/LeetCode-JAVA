package main.prep2021.quickpractices;

public class IntegerToRoman {
    public static int handleNumber(StringBuilder result, int num, int digit, String nine, String five, String one) {
        int digitValue = num / digit;
        if (digitValue == 9) {
            result.append(nine);
        } else if (digitValue == 4) {
            result.append(one).append(five);
        } else if (digitValue < 4) {
            for (int i = digitValue; i > 0; i--) {
                result.append(one);
            }
        } else {
            result.append(five);
            for (int i = digitValue - 5; i > 0; i--) {
                result.append(one);
            }
        }
        return num - digitValue * digit;
    }
    public static String intToRoman(int num) {
        int newNum = num;
        StringBuilder finalValue = new StringBuilder();
        int thousands = newNum / 1000;
        for (int i = thousands; i > 0; i--) {
            finalValue.append("M");
        }
        newNum = handleNumber(finalValue, newNum % 1000, 100, "CM", "D", "C");
        newNum = handleNumber(finalValue, newNum % 100, 10, "XC", "L", "X");
        handleNumber(finalValue, newNum % 10, 1, "IX", "V", "I");
        return finalValue.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}
