package main.quickpractices;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> transformed = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            transformed.add(new ArrayList<>());
        }
        final int subpartSize = 2 * numRows - 2;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i ++) {
            char currentChar = sChars[i];
            int index = i % subpartSize;
            if (index <= numRows - 1) {
                transformed.get(index).add(currentChar);
            } else {
                transformed.get(subpartSize - index).add(currentChar);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (List<Character> chars : transformed) {
            for (Character character : chars) {
                answer.append(character);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        var solution = new ZigzagConversion();
        System.out.println(solution.convert( "PAYPALISHIRING", 4));
    }

}
