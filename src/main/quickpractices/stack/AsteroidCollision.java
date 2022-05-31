package main.quickpractices.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> afterCollision = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (afterCollision.isEmpty() || asteroid > 0) {
                afterCollision.addLast(asteroid);
                continue;
            }
            if (asteroid < 0) {
                if (afterCollision.peekLast() < 0) {
                    afterCollision.addLast(asteroid);
                    continue;
                }
                int collisionResult = asteroid;
                while (collisionResult < 0 && afterCollision.size() > 0 && afterCollision.peekLast() > 0) {
                    if (afterCollision.peekLast() < Math.abs(collisionResult)) {
                        afterCollision.removeLast();
                    } else if (afterCollision.peekLast() == Math.abs(collisionResult)) {
                        afterCollision.removeLast();
                        collisionResult = 0;
                    } else {
                        collisionResult = afterCollision.peekLast();
                    }
                }
                if (collisionResult < 0) afterCollision.addLast(collisionResult);
            }
        }
        int[] result = new int[afterCollision.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = afterCollision.removeFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new AsteroidCollision();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{8, -8})));
    }
}
