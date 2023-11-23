package main.prep2021.quickpractices.linkedlist;

import main.shared.ListNode;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        // 4 -> 3 -> 1 -> 1
        ListNode current = node;
        while (current != null) {
            ListNode next = current.next;
            current.val = next.val;
            if (next.next == null) {
                current.next = null;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node0 = new ListNode(0, node1);

        var solution = new DeleteNodeInALinkedList();
        solution.deleteNode(node2);
        System.out.println(node0);
    }
}
