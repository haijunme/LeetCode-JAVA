package main.quickpractices;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String previousString = countAndSay(n - 1);
        StringBuilder answer = new StringBuilder();

        char[] characters = previousString.toCharArray();
        char lastChar = characters[0];
        int count = 1;
        for (int i = 1; i < characters.length; i++) {
            if (characters[i] != lastChar) {
                answer.append(count).append(lastChar);
                lastChar = characters[i];
                count = 1;
            } else {
                count ++;
            }
        }
        answer.append(count).append(lastChar);
        return answer.toString();
    }

    public static void main(String[] args) {
        var solution = new CountAndSay();
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
        System.out.println(solution.countAndSay(6));
        System.out.println(solution.countAndSay(7));
    }
}
