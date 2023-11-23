package main.prep2021.quickpractices.linkedlist.sizecounting;

import main.shared.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    private static class SetOnePass {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (set.contains(headB)) return headB;
                headB = headB.next;
            }
            return null;
        }
    }

    // TODO size counting implementation
    private static class SizeCounting {
//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        }
    }
}
