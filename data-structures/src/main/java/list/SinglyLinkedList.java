package list;

import java.util.NoSuchElementException;

public class SinglyLinkedList <E> {

    protected Node<E> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node<E> p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) {
                return k;
            }
            p = p.getNext();
        }
        return -1;
    }

    public void insertFront(E newItem) {
        head = new Node<E>(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node<E> p) {
        p.setNext(new Node<E>(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        size--;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void deleteAfter(Node<E> p) {
        if (p == null) {
            throw new NoSuchElementException();
        }
        Node<E> t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }
}
