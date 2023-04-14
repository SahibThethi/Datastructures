package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.*;


public class DLL{
    protected DNode head;
    protected DNode tail;
    protected int size;
    protected boolean sorted;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.sorted = true;
    }

    public DLL(DNode node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
        this.sorted = true;
    }

    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
        sorted = false;
    }

    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
        sorted = false;
    }

    public void insert(DNode node, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertHead(node);
            return;
        }
        if (position == size + 1) {
            insertTail(node);
            return;
        }
        DNode current = head;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        node.setPrev(current.getPrev());
        node.setNext(current);
        current.getPrev().setNext(node);
        current.setPrev(node);
        size++;
        sorted = false;
    }
    private boolean isSorted() {
        DNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data > curr.next.data) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
    public void sortedInsert(DNode node) {
        if (!sorted) {
            sort();
        }
        if (head == null) {
            head = node;
            tail = node;
        } else if (node.getData() <= head.getData()) {
            insertHead(node);
        } else if (node.getData() >= tail.getData()) {
            insertTail(node);
        } else {
            DNode current = head.getNext();
            while (current != null && node.getData() > current.getData()) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }
    private void swap(DNode a, DNode b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public void sort() {
        if (head == null || head == tail) {
            return;
        }
        DNode curr = head.next;
        while (curr != null) {
            DNode prev = curr.prev;
            while (prev != null && curr.data < prev.data) {
                swap(prev, curr);
                curr = prev;
                prev = curr.prev;
            }
            curr = curr.next;
        }
    }

    public DNode search(int data) {
        DNode current = head;
        while (current != null) {
            if (current.getData() == data) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
    }
    public void deleteTail() {
        if (tail != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    public void delete(DNode node) {
        if (node == head) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public int getLength() {
        return size;
    }
    public void print() {
        System.out.print("List length: " + getLength());
        System.out.print(", Sorted status: " + isSorted());
        System.out.print(", List content: ");
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
