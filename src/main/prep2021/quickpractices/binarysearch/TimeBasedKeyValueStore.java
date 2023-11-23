package main.prep2021.quickpractices.binarysearch;

import java.util.*;

public class TimeBasedKeyValueStore {
    private static class TimeMap {
        private static class Pair {
            private int timestamp;
            private String value;
            private Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }

        private final Map<String, List<Pair>> data;

        public TimeMap() {
            this.data = new HashMap<>();
        }

        private int binarySearch(List<Pair> list, int timestamp) {
            int left = 0;
            int right = list.size();
            while (left <= right) {
                int mid = left + (right - left)/2;
                int midTimestamp = list.get(mid).timestamp;
                if (midTimestamp == timestamp) {
                    return mid;
                } else if (midTimestamp < timestamp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }

        public void set(String key, String value, int timestamp) {
            data.putIfAbsent(key, new ArrayList<>());
            data.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            List<Pair> values = data.get(key);
            if (values == null || values.isEmpty()) {
                return "";
            }
            if (values.get(0).timestamp > timestamp) {
                return "";
            }
            if (values.get(values.size()-1).timestamp <= timestamp) {
                return values.get(values.size()-1).value;
            }
            return values.get(binarySearch(values, timestamp)).value;
        }
    }

    public static void main(String[] args) {
        var solution = new TimeMap();
        solution.set("a", "bar", 1);
        solution.set("x", "b", 3);
        solution.get("b", 3);
        solution.set("foo","bar2", 4);
        solution.get("foo", 4);
        solution.get("foo", 5);

//        solution.set("a", "bar", 1);
//        solution.set("a", "bar", 1);
//        solution.set("a", "bar", 1);
        //solution.set("love", "low", 20);
        //System.out.println(solution.get("love", 20));
//        System.out.println(solution.get("love", 10));
//        System.out.println(solution.get("love", 15));
//        System.out.println(solution.get("love", 20));
//        System.out.println(solution.get("love", 25));
//        solution.get("foo", 1);         // return "bar"
//        solution.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
//        solution.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
//        solution.get("foo", 4);         // return "bar2"
//        solution.get("foo", 5);         // return "bar2"
    }
}
