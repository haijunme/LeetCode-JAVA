package main.quickpractices;

public class StringToIntegerWrong {

    private boolean isIntegerMaxOrMin(int number) {
        return number == Integer.MIN_VALUE || number == Integer.MAX_VALUE;
    }

    public int myAtoi(String s) {
        char[] sChars = s.toCharArray();

        int firstValid = 0;
        if (sChars[firstValid] == ' ') {
            for (int i = 1; i < s.length(); i++) {
                if (sChars[i] != ' ' && sChars[i - 1] == ' ') {
                    firstValid = i;
                    break;
                }
            }
        }

        int sign = 1;
        int answer = 0;
        int base = 1;
        for (int i = sChars.length - 1; i >= firstValid; i--) {
            char current = sChars[i];
            if (current == '+') {
                sign = 1;
                answer = isIntegerMaxOrMin(answer) ? Integer.MAX_VALUE : Math.abs(answer);
            } else if (current == '-') {
                sign = -1;
                answer = isIntegerMaxOrMin(answer)? Integer.MIN_VALUE : -1 * Math.abs(answer);
            } else if (!isIntegerMaxOrMin(answer) && Character.isDigit(current)) {
                int newAnswer = answer + sign * base * Character.getNumericValue(current);
                base *= 10;
                if (answer < 0 && newAnswer > answer) {
                    answer = Integer.MIN_VALUE;
                    continue;
                }
                if (answer > 0 && newAnswer < answer) {
                    answer = Integer.MAX_VALUE;
                    continue;
                }
                answer = newAnswer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new StringToIntegerWrong();
        System.out.println(solution.myAtoi("words and 987"));
    }
}
