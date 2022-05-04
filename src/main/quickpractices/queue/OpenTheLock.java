package main.quickpractices.queue;

import java.util.*;

public class OpenTheLock {
    private static final String SUCCESS = "0000";

    private char getChangedChar(char original, int step) {
        int value = Character.getNumericValue(original) + step;
        if (value > 9) {
            value = 0;
        } else if (value < 0) {
            value = 9;
        }
        return Character.forDigit(value, 10);
    }

    private List<String> getIntermediates(String base) {
        List<String> result = new ArrayList<>();
        char[] temporary = base.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = base.charAt(i);
            temporary[i] = getChangedChar(original, 1);
            result.add(String.valueOf(temporary));

            temporary[i] = getChangedChar(original, -1);
            result.add(String.valueOf(temporary));

            temporary[i] = original;
        }
        return result;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains(SUCCESS)) {
            return -1;
        }
        if (SUCCESS.equals(target)) {
            return 0;
        }
        Set<String> seen = new HashSet<>();
        seen.add(target);
        Queue<String> intermediateSteps = new LinkedList<>();
        intermediateSteps.add(target);

        int turns = 0;
        while(!intermediateSteps.isEmpty()) {
            int stepCount = intermediateSteps.size();
            turns++;
            for (int i = 0; i < stepCount; i ++) {
                String current = intermediateSteps.remove();
                for (String potentialAnswer : getIntermediates(current)) {
                    if (SUCCESS.equals(potentialAnswer)) {
                        return turns;
                    }
                    if (deadendSet.contains(potentialAnswer)) {
                        continue;
                    }
                    if (seen.contains(potentialAnswer)) {
                        continue;
                    }
                    seen.add(potentialAnswer);
                    intermediateSteps.add(potentialAnswer);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var solution = new OpenTheLock();
        System.out.println(solution.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}
