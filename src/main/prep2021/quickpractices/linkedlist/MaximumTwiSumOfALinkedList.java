package main.prep2021.quickpractices.linkedlist;

import main.shared.ListNode;
import java.util.*;

public class MaximumTwiSumOfALinkedList {

    private int getCount(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count ++;
            current = current.next;
        }
        return count;
    }

    public int pairSum(ListNode head) {
        int count = getCount(head);
        ListNode current = head;
        int loopCounter = 0, answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (current != null) {
            if (loopCounter < count/2) {
                stack.addLast(current.val);
            } else {
                answer = Math.max(stack.removeLast() + current.val, answer);
            }
            current = current.next;
            loopCounter++;
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new MaximumTwiSumOfALinkedList();
//        ListNode node3 = new ListNode(3);
//        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1000000);
        ListNode node0 = new ListNode(1, node1);
        System.out.println(solution.pairSum(node0));
    }
}
