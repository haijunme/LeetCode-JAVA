import java.util.ArrayList;

class Solution {
    ArrayList<Integer> reversedDigits = new ArrayList<>();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        getAllNumbers(l1, l2, 0);
        if (reversedDigits.isEmpty()) {
            return new ListNode(0, null);
        }
        ListNode head = new ListNode(reversedDigits.get(0));
        ListNode originalHead = head;
        for (int i = 1; i < reversedDigits.size(); i++) {
            head.next = new ListNode(reversedDigits.get(i), null);
            head = head.next;
        }
        return originalHead;
    }

    private void getAllNumbers(ListNode l1, ListNode l2, int carryOverValue) {
        int l1Value = 0;
        int l2Value = 0;
        int newCarryOverValue = 0;
        ListNode l1Node = null;
        ListNode l2Node = null;

        if (l1 != null) {
            l1Value = l1.val;
            l1Node = l1.next;
        }

        if (l2 != null) {
            l2Value = l2.val;
            l2Node = l2.next;
        }

        int currentSum = l1Value + l2Value + carryOverValue;
        if (currentSum >= 10) {
            newCarryOverValue = 1;
            reversedDigits.add(currentSum - 10);
        } else {
            reversedDigits.add(currentSum);
        }

        if (l1Node == null && l2Node == null) {
            if (newCarryOverValue != 0) {
                reversedDigits.add(newCarryOverValue);
            }
            return;
        }

        getAllNumbers(l1Node, l2Node, newCarryOverValue);
    }

    public static void main(String[] args) {
        ListNode node17 = new ListNode(9, null);
        ListNode node16 = new ListNode(9, node17);
        ListNode node15 = new ListNode(9, node16);
        ListNode node14 = new ListNode(9, node15);
        ListNode node13 = new ListNode(9, node14);
        ListNode node12 = new ListNode(9, node13);
        ListNode node11 = new ListNode(9, node12);

        ListNode node24 = new ListNode(9, null);
        ListNode node23 = new ListNode(9, node24);
        ListNode node22 = new ListNode(9, node23);
        ListNode node21 = new ListNode(9, node22);

        Solution solution = new Solution();
        ListNode node31 = solution.addTwoNumbers(node11, node21);
        System.out.println(node31.val);
        while (node31.next != null) {
            node31 = node31.next;
            System.out.println(node31.val);
        }
    }
}
