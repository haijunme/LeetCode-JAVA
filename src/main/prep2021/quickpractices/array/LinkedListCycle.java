package main.prep2021.quickpractices.array;

import main.shared.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
        node4.next = node1;
        var solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(node3));
    }
}
