package main.prep2021.quickpractices;

import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] array = new char[]{'a', 'b', 'e', 'c', 'd'};
        reverseString.reverseString(array);
        System.out.println(Arrays.toString(array));
    }
}
