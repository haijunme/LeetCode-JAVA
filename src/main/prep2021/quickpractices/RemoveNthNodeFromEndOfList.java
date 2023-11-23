package main.prep2021.quickpractices;

import main.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(sentinel);
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int size = nodes.size();
        nodes.get(size-n-1).next = nodes.get(size-n).next;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        var solution = new RemoveNthNodeFromEndOfList();
        ListNode newHead = solution.removeNthFromEnd(node1, 5);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
