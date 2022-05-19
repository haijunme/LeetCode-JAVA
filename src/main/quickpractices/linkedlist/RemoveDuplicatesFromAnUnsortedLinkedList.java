package main.quickpractices.linkedlist;

import java.util.*;
import main.shared.ListNode;

public class RemoveDuplicatesFromAnUnsortedLinkedList {

    private static class TwoPass {
        public ListNode deleteDuplicatesUnsorted(ListNode head) {
            ListNode current = head;
            Set<Integer> seen = new HashSet<>();
            Set<Integer> duplicates = new HashSet<>();
            while (current != null) {
                if (!seen.add(current.val)) {
                    duplicates.add(current.val);
                }
                current = current.next;
            }
            ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
            current = sentinel;
            while (current.next != null) {
                if (duplicates.contains(current.next.val)) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return sentinel.next;
        }
    }
}
