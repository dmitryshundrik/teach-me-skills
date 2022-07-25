package collection;

import java.util.Map;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private final Node<K, V>[] table = (Node<K, V>[]) new Node[5];
    private int size = 0;

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new Node<>(key, value, null);
        } else {
            for (Node<K, V> head = table[index]; head != null; head = head.next) {
                if (head.key.equals(key)) {
                    V oldValue = head.value;
                    head.value = value;
                    size++;
                    return oldValue;
                }
            }
            table[index].next = new Node<>(key, value, null);
        }
        size++;
        return value;
    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        int index = hash % table.length;
        return Math.abs(index);
    }

    @Override
    public V get(K key) {
        return table[getIndex(key)] == null ? null : getNode(getIndex(key), key).value;
    }

    private Node<K, V> getNode(int index, K key) {
        Node<K, V> head = table[index];
        while (true) {
            if (head.key.equals(key)) {
                return head;
            }
            head = head.next;
        }
    }

    @Override
    public V remove(K key) {
        V value = null;
        int index = getIndex(key);
        Node<K, V> head = table[index];

        if (head.next == null) {
            value = head.value;
            table[index] = null;
        } else {
            while (head != null) {
                if (head.key.equals(key)) {
                    value = head.value;
                    Node<K, V> nextNode = head.next;
                    table[index] = nextNode;
                }
                head = head.next;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    public static class Node<K, V> implements Map.Entry<K, V> {

        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node<K, V> kvNode : table) {
            for (Node<K, V> head = kvNode; head != null; head = head.next) {
                stringBuilder.append(head.key.toString()).append(" ").append(head.value.toString()).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
