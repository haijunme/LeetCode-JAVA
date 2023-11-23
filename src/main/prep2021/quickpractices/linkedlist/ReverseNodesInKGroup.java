package main.prep2021.quickpractices.linkedlist;

import main.shared.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseLinkedList(ListNode head) {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode firstNode = head;
        ListNode current = head;
        int loopCounter = 0;
        while (current != null) {
            loopCounter++;
            if (loopCounter == k) {
                break;
            }
            current = current.next;
        }
        if (loopCounter < k || current == null) {
            return firstNode;
        }
        ListNode next = current.next;
        current.next = null;
        ListNode newHead = reverseLinkedList(firstNode);
        firstNode.next = reverseKGroup(next, k);
        return newHead;
    }

    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);
//        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1);

        var solution = new ReverseNodesInKGroup();
        ListNode result = solution.reverseKGroup(node1, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
