package main.quickpractices.binarysearch;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0;
        int j = letters.length-1;
        int targetVal = (int)target;

        while (i <= j) {
            int mid = i + (j-i)/2;
            int midVal = (char)letters[mid];

            if (midVal <= targetVal) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }


        return i == letters.length ? letters[0] : letters[i];
    }

    public static void main(String[] args) {
        var solution = new FindSmallestLetterGreaterThanTarget();
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
    }
}
