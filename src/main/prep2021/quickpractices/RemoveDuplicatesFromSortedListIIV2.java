package main.prep2021.quickpractices;

import main.shared.ListNode;

public class RemoveDuplicatesFromSortedListIIV2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = new ListNode(0, head);
        ListNode predecessor = tempHead;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                predecessor.next = head.next;
            } else {
                predecessor = predecessor.next;
            }
            head = head.next;
        }
        return tempHead.next;
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
