package main.prep2021.quickpractices;

import main.shared.ListNode;

public class AddAllNumbersAlternative {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode newCurrent = null;

        int carryOver = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            int sum = l1.val + l2.val + carryOver;
            carryOver = sum / 10;
            sum = sum % 10;
            newCurrent = (newHead == null) ? (newHead = new ListNode(sum)) : (newCurrent.next = new ListNode(sum));
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carryOver == 1) {
            newCurrent.next = new ListNode(1);
        }
        return newHead;
    }

    public static void main(String[] args) {
        var solution = new AddAllNumbersAlternative();
        ListNode node17 = new ListNode(9);
        ListNode node16 = new ListNode(9, node17);
        ListNode node15 = new ListNode(9, node16);
        ListNode node14 = new ListNode(9, node15);
        ListNode node13 = new ListNode(9, node14);
        ListNode node12 = new ListNode(9, node13);
        ListNode node11 = new ListNode(9, node12);


        ListNode node24 = new ListNode(9);
        ListNode node23 = new ListNode(9, node24);
        ListNode node22 = new ListNode(9, node23);
        ListNode node21 = new ListNode(9, node22);
        System.out.println(solution.addTwoNumbers(node11, node21));
    }
}
