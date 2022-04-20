package main.quickpractices.array;

import main.shared.ListNode;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode node13 = new ListNode(5, null);
        ListNode node12 = new ListNode(1, node13);
        ListNode node11 = new ListNode(1, node12);

        ListNode node23 = new ListNode(6, null);
        ListNode node22 = new ListNode(1, node23);
        ListNode node21 = new ListNode(1, node22);

        ListNode result = mergeTwoSortedList.mergeTwoLists(node11, node21);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
