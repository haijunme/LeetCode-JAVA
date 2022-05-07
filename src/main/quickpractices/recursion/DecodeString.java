package main.quickpractices.recursion;

public class DecodeString {
    private int N;
    private String encoded;

    private String recur(int start, int end) {
        StringBuilder builder = new StringBuilder();
        StringBuilder repeatsBuilder = new StringBuilder();
        int openingCount = 0;
        int closingCount = 0;
        int firstOpeningIndex = -1;

        for (int i = start; i <= end; i++) {
            char current = encoded.charAt(i);
            if (Character.isDigit(current) && openingCount == 0) {
                // independent digits for each recursion level, eg. "1", "2" or "3" in "12[a4[b]]3[c]"
                repeatsBuilder.append(current);
            } else if (current == '['){
                openingCount ++;
                if (firstOpeningIndex == -1) {
                    firstOpeningIndex = i;
                }
            } else if (current == ']'){
                closingCount++;
                if (closingCount == openingCount) {
                    String intermediate = recur(firstOpeningIndex + 1, i - 1);
                    int repeats = Integer.parseInt(repeatsBuilder.toString());
                    for (int j = 1; j <= repeats; j++) {
                        builder.append(intermediate);
                    }
                    // reset the trackers
                    openingCount = 0;
                    closingCount = 0;
                    firstOpeningIndex = -1;
                    repeatsBuilder = new StringBuilder();
                }
            } else if (openingCount == 0) {
                // independent characters for each recursion level, eg. "a" in "3a[b2[cd]]"
                builder.append(current);
            }
        }
        return builder.toString();
    }

    public String decodeString(String s) {
        N = s.length();
        encoded = s;
        return recur(0, N-1);
    }

    public static void main(String[] args) {
        var solution = new DecodeString();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}
