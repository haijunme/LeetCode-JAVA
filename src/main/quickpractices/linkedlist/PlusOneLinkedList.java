package main.quickpractices.linkedlist;

import main.shared.ListNode;

public class PlusOneLinkedList {

    private ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverseLinkedList(head);
        ListNode current = newHead;
        ListNode last = null;
        int carryOver = 1;
        while (current != null) {
            current.val = current.val + carryOver;
            if (current.val >= 10) {
                carryOver = 1;
                current.val %= 10;
            } else {
                carryOver = 0;
            }
            last = current;
            current = current.next;
        }
        if (carryOver == 1) {
            last.next = new ListNode(1);
        }
        return reverseLinkedList(newHead);
    }

    public static void main(String[] args) {
        var solution = new PlusOneLinkedList();
        ListNode node3 = new ListNode(9);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(9, node2);
        ListNode result = solution.plusOne(node1);
        System.out.println(result);
    }
}
