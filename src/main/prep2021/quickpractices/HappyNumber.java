package main.prep2021.quickpractices;
import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        int current = n;
        Set<Integer> encountered = new HashSet<>();
        encountered.add(current);

        while (true) {
            char[] digits = Integer.toString(current).toCharArray();
            current = 0;
            for (char character : digits) {
                int charNumeric = Character.getNumericValue(character);
                current += charNumeric * charNumeric;
            }
            if (current == 1) {
                break;
            }
            if (!encountered.add(current)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new HappyNumber();
        System.out.println(solution.isHappy(2));
    }
}
