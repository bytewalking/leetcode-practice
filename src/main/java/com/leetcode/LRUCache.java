package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    private final Map<Integer, Node> cache;
    private Node head, tail;
    private int nodeSize = 0;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        if (node.getPrev() != null) {
            // 移动到最前面
            Node prev = node.getPrev();
            Node next = node.getNext();
            prev.setNext(next);
            if (next != null) {
                next.setPrev(prev);
            }else{
                tail = prev;
            }


            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;

        }

        return node.getValue();
    }

    public void put(int key, int value) {
        int oldValue = this.get(key);
        if (oldValue != -1) {
            // 已存在
            head.setValue(value);
            return;
        }

        // 首次添加缓存
        if (head == null) {
            head = new Node(key, value, null, null);
            tail = head;
            cache.put(key, head);
            nodeSize = nodeSize + 1;
            return;
        }

        if (nodeSize == capacity) {
            // 移除最后一个
            Node prev = tail.getPrev();
            cache.remove(tail.getKey());
            if (prev != null) {
                prev.setNext(null);
                tail = prev;
            }
            nodeSize = nodeSize - 1;
        }

        Node n = new Node(key, value, null, head);
        head.setPrev(n);
        head = n;
        nodeSize = nodeSize + 1;
        cache.put(key, n);
    }

    class Node {
        private int key, value;
        private Node prev, next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
