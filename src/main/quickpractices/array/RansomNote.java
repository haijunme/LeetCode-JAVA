package main.quickpractices.array;

public class RansomNote {
    private static final int BASE_ASCII = 'a';

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] occurrences = new int[26];
        for (char character : magazine.toCharArray()) {
            occurrences[character - BASE_ASCII] ++;
        }
        for (char character : ransomNote.toCharArray()) {
            occurrences[character - BASE_ASCII] --;
            if (occurrences[character - BASE_ASCII] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new RansomNote();
        System.out.println(solution.canConstruct("a", "ab"));
    }
}
