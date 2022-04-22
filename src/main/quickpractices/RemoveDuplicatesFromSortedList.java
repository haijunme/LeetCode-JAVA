package main.quickpractices;

import main.shared.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);

        ListNode previous = sentinel;
        ListNode current = previous.next;

        while (current != null) {
            if (previous.val == current.val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return sentinel.next;
    }
}
