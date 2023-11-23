package main.prep2021.quickpractices;

import main.shared.ListNode;

import java.util.ArrayList;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode originalHead = head;
        var nodes = new ArrayList<ListNode>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        if (k > nodes.size()/2) {
            k = nodes.size() - k + 1;
        }
        if (k == 1 || k == nodes.size()) {
            if (nodes.size() == 1) {
                return originalHead;
            }
            if (nodes.size() == 2) {
                nodes.get(nodes.size() - 1).next = originalHead;
                nodes.get(0).next = null;
                return nodes.get(nodes.size() - 1);
            }
            nodes.get(nodes.size() - 1).next = nodes.get(1);
            nodes.get(nodes.size() - 2).next = nodes.get(0);
            nodes.get(0).next = null;
            return nodes.get(nodes.size() - 1);
        } else {
            if (k * 2 == nodes.size()) {
                nodes.get(k - 2).next = nodes.get(nodes.size() - k);
                nodes.get(k - 2).next.next = nodes.get(k - 1);
                nodes.get(k - 1).next = nodes.get(nodes.size() - k + 1);
            } else {
                nodes.get(k - 2).next = nodes.get(nodes.size() - k);
                nodes.get(k - 2).next.next = nodes.get(k);
                nodes.get(nodes.size() - k - 1).next = nodes.get(k - 1);
                nodes.get(nodes.size() - k - 1).next.next = nodes.get(nodes.size() - k + 1);
            }
        }
        return originalHead;
    }


    public static void main(String[] args) {
        //ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        var solution = new SwappingNodesInALinkedList();
        var head = solution.swapNodes(node1, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
