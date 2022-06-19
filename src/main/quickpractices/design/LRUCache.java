package main.quickpractices.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        final int key;
        int value;
        Node previous;
        Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private final int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node target = cache.get(key);
            moveNodeToTail(target);
            return target.value;
        }
        return -1;
    }

    private void moveNodeToTail(Node target) {
        if (target != tail) {
            if (target == head) {
                target.next.previous = null;
                head = head.next;
            } else {
                Node previous = target.previous;
                Node next = target.next;
                previous.next = next;
                next.previous = previous;
            }
            // handling the tail
            target.next = null;
            tail.next = target;
            target.previous = tail;
            tail = tail.next;
        }
    }

    public void put(int key, int value) {
        if (head == null) {
            tail = (head = new Node(key, value));
            cache.put(key, tail);
            return;
        }
        if (cache.containsKey(key)) {
            Node target = cache.get(key);
            target.value = value;
            moveNodeToTail(target);
        } else {
            tail.next = new Node(key, value);
            tail.next.previous = tail;
            tail = tail.next;
            cache.put(key, tail);
        }
        if (cache.size() > this.capacity) {
            cache.remove(head.key);
            head.next.previous = null;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

    }
}
