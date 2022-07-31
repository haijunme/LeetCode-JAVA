package main.quickpractices.sorting;

import java.util.*;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Map<String, Integer> stringIndexMap = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            String current = logs[i];
            if (Character.isDigit(current.charAt(current.length() - 1))) {
                stringIndexMap.put(current, i);
            }
        }
        Arrays.sort(logs, (a, b) -> {
            char aLast = a.charAt(a.length() - 1);
            char bLast = b.charAt(b.length() - 1);
            if (Character.isDigit(aLast) && Character.isDigit(bLast)) {
                return stringIndexMap.get(a) - stringIndexMap.get(b);
            } else if (Character.isLetter(aLast) && Character.isLetter(bLast)) {
                int aDivide = a.indexOf(" ");
                int bDivide = b.indexOf(" ");
                int compareResult = a.substring(aDivide + 1).compareTo(b.substring(bDivide + 1));
                if (compareResult == 0)
                    return a.substring(0, aDivide).compareTo(b.substring(0, bDivide));
                else
                    return compareResult;
            } else {
                return Character.isDigit(aLast) ? 1 : -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        var solution = new ReorderDataInLogFiles();
        System.out.println(Arrays.toString(solution.reorderLogFiles(
                new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        // "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        System.out.println(Arrays.toString(solution.reorderLogFiles(
                new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
    }
}
