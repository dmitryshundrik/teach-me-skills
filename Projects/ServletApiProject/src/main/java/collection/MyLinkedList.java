package collection;

public class MyLinkedList<T> implements MyList<T> {
    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T o) {
        Node<T> node;
        if (tail == null) {
            node = new Node<>(o, null, null);
            head = node;
        } else {
            node = new Node<>(o, null, tail);
            tail.next = node;
        }
        tail = node;
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> resultNode;
        if (index < (size >> 1)) {
            resultNode = head;
            for (int i = 0; i <= index; i++) {
                resultNode = resultNode.next;
            }
        } else {
            resultNode = tail;
            for (int i = size; i <= size - index; i--) {
                resultNode = resultNode.prev;
            }

        }
        return resultNode.object;
    }

    @Override
    public T remove(int index) {
        Node<T> resultNode;
        if (index < (size / 2)) {
            resultNode = head;
            for (int i = 0; i < index; i++) {
                if (resultNode.next != null) {
                    resultNode = resultNode.next;
                }
            }

        } else {
            resultNode = tail;
            for (int i = 0; i < size - index; i++) {
                if (resultNode.prev != null) {
                    resultNode = resultNode.prev;
                }
            }
        }
        return unlink(resultNode);

    }

    private T unlink(Node<T> node) {
        T object = node.object;
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        size--;
        return object;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        T object;
        Node<T> next;
        Node<T> prev;

        public Node(T object, Node<T> next, Node<T> prev) {
            this.object = object;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Node<T> node = head; node != null; node = node.next) {
            stringBuilder.append(node.object.toString()).append(" ");
        }
        return stringBuilder.toString();
    }
}
