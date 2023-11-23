package main.prep2021.quickpractices;

import main.shared.ListNode;

import java.util.ArrayList;

public class ReturnMiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head);
            head = head.next;
        }
        return arrayList.get(arrayList.size() / 2);
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ReturnMiddleLinkedList returnMiddleLinkedList = new ReturnMiddleLinkedList();
        ListNode head = returnMiddleLinkedList.middleNode(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
