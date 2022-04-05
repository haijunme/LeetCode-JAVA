package main.quickpractices;

import main.shared.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode current = fakeHead;
        while (current != null && current.next != null) {
            ListNode newNext = current.next;
            int counter = 0;
            while (newNext.next != null && newNext.next.val == newNext.val) {
                counter++;
                newNext = newNext.next;
            }
            current.next = counter > 0 ? newNext.next : newNext;
            if (isNextElementNullOrUnique(current)) {
                current = current.next;
            }
        }
        return fakeHead.next;
    }

    private boolean isNextElementNullOrUnique(ListNode current) {
        return !(current.next != null && current.next.next != null && current.next.val == current.next.next.val);
    }

    public static void main(String[] args) {
//        ListNode node7 = new ListNode(5);
//        ListNode node6 = new ListNode(4, node7);
//        ListNode node5 = new ListNode(4, node6);
//        ListNode node4 = new ListNode(3, node5);
//        ListNode node3 = new ListNode(3, node4);
//        ListNode node2 = new ListNode(2, node3);
//        ListNode node1 = new ListNode(1, node2);
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        var solution = new RemoveDuplicatesFromSortedListII();
        ListNode head = solution.deleteDuplicates(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
