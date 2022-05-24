package main.quickpractices.array.stringcharacters;

public class AddBinary {
    private static class BitByBitAddition {
        private int getValue(String s, int i) {
            return (s.length() - 1 - i >= 0) ? Character.getNumericValue(s.charAt(s.length() - 1 - i)) : 0;
        }

        public String addBinary(String a, String b) {
            StringBuilder answerBuilder = new StringBuilder();
            int carryOver = 0;
            for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
                int first = getValue(a, i);
                int second = getValue(b, i);
                int sum = first + second + carryOver;
                carryOver = sum / 2;
                sum = sum % 2;
                answerBuilder.append(Character.forDigit(sum, 10));
            }
            if (carryOver != 0) answerBuilder.append('1');
            return answerBuilder.reverse().toString();
        }
    }
}
