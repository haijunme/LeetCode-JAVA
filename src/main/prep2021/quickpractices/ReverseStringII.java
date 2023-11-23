package main.prep2021.quickpractices;

public class ReverseStringII {
    public void reverse(char[] characters, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            char temp = characters[left];
            characters[left++] = characters[right];
            characters[right--] = temp;
        }
    }

    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] characters = s.toCharArray();
        while (end < characters.length) {
            if (characters[end] != ' ' && end != characters.length - 1) {
                end++;
            } else {
                reverse(characters, start, end == characters.length - 1 ? end : end - 1);
                end++;
                start = end;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : characters) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseStringII reverseStringII = new ReverseStringII();
        System.out.println(reverseStringII.reverseWords("abc def"));
    }

}
