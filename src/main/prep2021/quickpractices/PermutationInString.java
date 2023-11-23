package main.prep2021.quickpractices;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        int[] characters = new int[128];
        for (char character : c1) {
            characters[character]++;
        }

        char[] c2 = s2.toCharArray();

        int i = 0;
        while (i <= c2.length - s1.length()) {
            if (characters[c2[i]] > 0) {
                int[] temporary = new int[128];
                System.arraycopy(characters, 0, temporary, 0, 128);
                for (int j = i; j < i + s1.length(); j++) {
                    if (temporary[c2[j]] > 0) {
                        temporary[c2[j]]--;
                    } else {
                        i++;
                        break;
                    }
                }
                boolean result = true;
                for (int count : temporary) {
                    result = result && (count == 0);
                }
                if (result) return true;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ccc", "cbac"));
    }
}
