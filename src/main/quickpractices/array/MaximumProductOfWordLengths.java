package main.quickpractices.array;

public class MaximumProductOfWordLengths {
    public int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; ++i) {
            int bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                // add bit number bit_number in bitmask
                // 0 0 1 0
                // 0 0 0 1
                // 0 0 0 0
                // => 0 0 1 1
                bitmask = bitmask | (1 << bitNumber(ch));
            }
            masks[i] = bitmask;
        }
        int maxVal = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                // 0 0 1 1
                // 1 1 0 0
                // => 0 0 0 0
                if ((masks[i] & masks[j]) == 0)
                    maxVal = Math.max(maxVal, words[i].length() * words[j].length());

        return maxVal;
    }

    public static void main(String[] args) {
        var solution = new MaximumProductOfWordLengths();
        System.out.println(solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
