package main.prep2021.quickpractices.array.stringcharacters;

public class MultiplyStrings {

    private int getProduct(String num, char character, int base) {
        int result = 0;
        int localBase = 1;
        int multiplier = Character.getNumericValue(character);
        for (int i = num.length() - 1; i >= 0; i--) {
            result += Character.getNumericValue(num.charAt(i)) * multiplier * localBase;
            localBase *= 10;
        }
        return result * base;
    }

    public String multiply(String num1, String num2) {
        String longer;
        String shorter;
        if (num1.length() >= num2.length()) {
            longer = num1;
            shorter = num2;
        } else {
            longer = num2;
            shorter = num1;
        }
        int answer = 0;
        int base = 1;
        for (int i = shorter.length() - 1; i >= 0; i--) {
            answer += getProduct(longer, shorter.charAt(i), base);
            base *= 10;
        }
        return Integer.toString(answer);
    }

    public static void main(String[] args) {
        var solution = new MultiplyStrings();
        System.out.println(solution.multiply("2", "3"));
    }
}
