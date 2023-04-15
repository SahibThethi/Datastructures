package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.*;

public class SLL{
    public SNode head;
    public SNode tail;
    public int size;

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public SNode getHead() {
        return this.head;
    }
    public SNode getTail() {
        return this.tail;
    }
    public int getSize() {
        return this.size;
    }

    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertTail(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insert(SNode node, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
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
        SNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

     //sorted insert
     public void sortedInsert(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else if (node.data < head.data) {
            insertHead(node);
        } else if (node.data > tail.data) {
            insertTail(node);
        } else {
            SNode current = head;
            while (current.next != null && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }
    
    
    public SNode search(int data) {
        SNode current = head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteHead() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Empty list");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            SNode curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
        }
        size--;
    }

    public void delete(SNode node) {
        if (head == null) {
            return;
        }
    
        if (head == node) {
            deleteHead();
            if (head == null) {
                tail = null;
            }
            return;
        }
    
        SNode current = head;
        while (current.next != null) {
            if (current.next == node) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
    }
    public void sort() {
        if (head == null) {
            return;
        }
        SNode curr = head;
        while (curr != null) {
            SNode next = curr.next;
            while (next != null) {
                if (curr.data > next.data) {
                    int temp = curr.data;
                    curr.data = next.data;
                    next.data = temp;
                }
                next = next.next;
            }
            curr = curr.next;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
    
        // Print list length
        System.out.println("List length: " + size);
    
        // Print sorted status
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "not sorted"));
    
        // Print list content
        System.out.print("List content: ");
        SNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public boolean isSorted() {
        if (size <= 1) {
            return true;
        }
        SNode current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}   
           


