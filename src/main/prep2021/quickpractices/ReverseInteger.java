package main.prep2021.quickpractices;

public class ReverseInteger {
    public int reverse(int x) {
        char[] characters = String.valueOf(x).toCharArray();
        StringBuilder answerBuilder = new StringBuilder();
        int end = 0;
        if (characters[0] == '-') {
            answerBuilder.append('-');
            end = 1;
        }
        for (int i = characters.length - 1; i >= end; i --) {
            answerBuilder.append(characters[i]);
        }
        try {
            return Integer.parseInt(answerBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(120));
    }
}
