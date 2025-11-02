/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private boolean isDoubly;

    public LinkedList(boolean isDoubly) {
        this.head = null;
        this.tail = null;
        this.isDoubly = isDoubly;
    }

    public void insertEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.setNext(newNode);
        if (isDoubly) newNode.setPrev(tail);
        tail = newNode;
    }

    public void insertFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.setNext(head);
        if (isDoubly) head.setPrev(newNode);
        head = newNode;
    }

    public boolean deleteByValue(T key) {
        if (head == null) return false;

        Node<T> curr = head;
        while (curr != null) {
            boolean match = (curr.getData() == null && key == null) ||
                            (curr.getData() != null && curr.getData().equals(key));

            if (match) {
                if (curr == head) {
                    head = head.getNext();
                    if (head == null) tail = null;
                    else if (isDoubly) head.setPrev(null);
                } else if (curr == tail) {
                    tail = tail.getPrev();
                    if (tail != null) tail.setNext(null);
                } else {
                    curr.getPrev().setNext(curr.getNext());
                    if (isDoubly && curr.getNext() != null)
                        curr.getNext().setPrev(curr.getPrev());
                }
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public int search(T key) {
        Node<T> curr = head;
        int index = 0;
        while (curr != null) {
            if ((curr.getData() == null && key == null) ||
                (curr.getData() != null && curr.getData().equals(key))) {
                return index;
            }
            curr = curr.getNext();
            index++;
        }
        return -1;
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = head;
        int index = 0;
        while (curr != null) {
            sb.append("[").append(index).append("] ");
            sb.append(curr.getData()).append("\n");
            curr = curr.getNext();
            index++;
        }
        return sb.length() == 0 ? "(lista vacía)" : sb.toString();
    }

    public int size() {
        Node<T> curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        return count;
    }

    public T getAt(int index) {
        if (index < 0) return null;
        Node<T> curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) return curr.getData();
            curr = curr.getNext();
            i++;
        }
        return null;
    }

    public void clear() {
        head = tail = null;
    }

    // === Métodos agregados para pila/cola ===

    public T removeFirst() {
        if (head == null) return null;
        T value = head.getData();
        head = head.getNext();

        if (head == null) tail = null;
        else if (isDoubly) head.setPrev(null);

        return value;
    }

    public T peekFirst() {
        return (head == null) ? null : head.getData();
    }

    public void addLast(T data) {
        insertEnd(data);
    }
}
