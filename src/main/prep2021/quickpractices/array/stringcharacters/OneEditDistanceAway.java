package main.prep2021.quickpractices.array.stringcharacters;

public class OneEditDistanceAway {

    // focus on the main point of the question!
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) >= 2) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }
        if (s.length() > t.length()) {
            return s.substring(i+1).equals(t.substring(j));
        } else if (s.length() < t.length()) {
            return s.substring(i).equals(t.substring(j+1));
        } else {
            return s.substring(i+1).equals(t.substring(j+1));
        }
    }

    public static void main(String[] args) {
        var solution = new OneEditDistanceAway();
        System.out.println(solution.isOneEditDistance("ab", "ba"));
    }
}
