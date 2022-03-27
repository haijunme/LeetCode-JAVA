package main;

import java.util.Map;
import java.util.TreeMap;

public class MergeKSortedLists {
    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode headToReturn = null;
        ListNode currentNode = null;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            int exhaustedListCount = 0;
            for (int i = 0; i < lists.length; i++) {
                ListNode currentHead = lists[i];
                if (currentHead == null) {
                    exhaustedListCount += 1;
                } else if (currentHead.val <= minValue) {
                    minValue = currentHead.val;
                    minIndex = i;
                }
            }
            if (exhaustedListCount == lists.length) {
                break;
            }
            if (headToReturn == null) {
                headToReturn = new ListNode(minValue, null);
                currentNode = headToReturn;
            } else {
                currentNode.next = new ListNode(minValue, null);
                currentNode = currentNode.next;
            }
            if (lists[minIndex] != null) {
                lists[minIndex] = lists[minIndex].next;
            }

        }
        return headToReturn;
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (ListNode node : lists) {
            ListNode head = node;
            while (head != null) {
                if (map.containsKey(head.val)) {
                    map.put(head.val, map.get(head.val) + 1);
                } else {
                    map.put(head.val, 1);
                }
                head = head.next;
            }
        }
        ListNode headToReturn = null;
        ListNode newHead = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 1; i <= entry.getValue(); i++) {
                if (newHead == null) {
                    newHead = new ListNode(entry.getKey());
                    headToReturn = newHead;
                } else {
                    ListNode newNode = new ListNode(entry.getKey());
                    newHead.next = newNode;
                    newHead = newNode;
                }
            }
        }
        return headToReturn;
    }

    public static void main(String[] args) {
        ListNode node13 = new ListNode(4, null);
        ListNode node12 = new ListNode(3, node13);
        ListNode node11 = new ListNode(1, node12);

        ListNode node24 = new ListNode(5, null);
        ListNode node23 = new ListNode(3, node24);
        ListNode node22 = new ListNode(2, node23);
        ListNode node21 = new ListNode(1, node22);

        mergeKLists2(new ListNode[] {node21, node11});
    }
}
