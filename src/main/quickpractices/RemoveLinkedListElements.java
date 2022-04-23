package main.quickpractices;

import main.shared.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(-1, head);

        ListNode prev = sentinel;
        ListNode current = sentinel.next;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7, null);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);


        var solution = new RemoveLinkedListElements();
        System.out.println(solution.removeElements(node1, 7));
        System.out.println(1);
    }

}
