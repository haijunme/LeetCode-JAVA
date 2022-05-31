package main.quickpractices.linkedlist;

public class AddPolynomialsRepresentedAsLinkedLists {

    private static class PolyNode {
        int coefficient, power;
        PolyNode next = null;
        PolyNode() {}
        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }
        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }
    }

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode head = null;
        PolyNode current = null;
        while (poly1 != null && poly2 != null) {
            int firstCoefficient = 0;
            int secondCoefficient = 0;
            int power = 0;
            if (poly1.power > poly2.power) {
                firstCoefficient = poly1.coefficient;
                power = poly1.power;
                poly1 = poly1.next;
            } else if (poly1.power < poly2.power) {
                secondCoefficient = poly2.coefficient;
                power = poly2.power;
                poly2 = poly2.next;
            } else {
                firstCoefficient = poly1.coefficient;
                secondCoefficient = poly2.coefficient;
                power = poly1.power;
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            if (firstCoefficient + secondCoefficient == 0) continue;
            if (head == null) {
                head = new PolyNode(firstCoefficient + secondCoefficient, power);
                current = head;
            } else {
                current.next = new PolyNode(firstCoefficient + secondCoefficient, power);
                current = current.next;
            }
        }
        if (poly1 != null) {
            current.next = poly1;
        } else {
            current.next = poly2;
        }
        return head;
    }
}
