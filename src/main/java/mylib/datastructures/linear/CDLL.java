package mylib.datastructures.linear;

import mylib.datastructures.nodes.*;

public class CDLL extends DLL {
    private DNode current;

    public CDLL() {
        super();
        current = null;
    }

    public CDLL(DNode node) {
        super(node);
        current = node;
        node.setNext(node);
        node.setPrev(node);
    }

    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        head.setPrev(tail);
        tail.setNext(head);
        current = head;
    }

    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public void insert(DNode node, int position) {
        if (position == 1 && size == 0) {
            insertHead(node);
            return;
        }
        if (position > size) {
            insertTail(node);
            return;
        }
        super.insert(node, position);
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public void deleteHead() {
        super.deleteHead();
        head.setPrev(tail);
        tail.setNext(head);
        current = head;
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        head.setPrev(tail);
        tail.setNext(head);
    }

    @Override
    public void delete(DNode node) {
        super.delete(node);
        head.setPrev(tail);
        tail.setNext(head);
    }

    public void setCurrent(DNode node) {
        if (search(node.getData()) == null) {
            System.out.println("Node not found.");
            return;
        }
        current = node;
    }

    public DNode getCurrent() {
        return current;
    }

    public void stepForward() {
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        current = current.getNext();
    }

    public void stepBackward() {
        if (current == null) {
            System.out.println("List is empty.");
            return;
        }
        current = current.getPrev();
    }

    @Override
    public void print() {
        System.out.println("List length: " + getLength());
        System.out.println("Sorted status: " + isSorted());
        System.out.print("List content: ");
        DNode curr = head;
        do {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        } while (curr != head);
        System.out.println();
    }

    @Override
    public DNode search(int data) {
        if (this.head == null) {
            throw new NullPointerException("List is empty");
        }
        DNode curr = this.head;
        while (curr.next != this.head) {
            if (curr.data == data) {
                return curr;
            }
            curr = curr.next;
        }
        if (curr.data == data) {
            return curr;
        }
        return null;
    }

    public void SortedInsert(DNode node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.prev = node;
            node.next = node;
            return;
        }

        // Check if the list is sorted
        if (!isSorted()) {
            // If not sorted, sort the list first
            Sort();
        }

        // Find the proper position to insert the node
        DNode curr = this.head;
        while (curr != this.tail && curr.data < node.data) {
            curr = curr.next;
        }

        if (curr == this.head && node.data <= this.head.data) {
            // Insert at the head
            node.next = this.head;
            node.prev = this.tail;
            this.head.prev = node;
            this.head = node;
            this.tail.next = node;
        } else if (curr == this.tail && node.data >= this.tail.data) {
            // Insert at the tail
            node.next = this.head;
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
            this.head.prev = node;
        } else {
            // Insert in the middle
            node.next = curr;
            node.prev = curr.prev;
            curr.prev.next = node;
            curr.prev = node;
        }
    }

    public void Sort() {
        if (this.head == null) {
            return;
        }
    
        DNode curr = this.head.next;
        if (this.tail == null) {
            this.tail = this.head;
        }
        while (curr != this.head) {
            DNode temp = curr.prev;
            while (temp != this.tail && temp.data > curr.data) {
                temp = temp.prev;
            }
            if (curr.prev != temp) { // insert only if necessary
                // Remove the current node from its position
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
    
                // Insert the current node before temp
                curr.next = temp.next;
                temp.next.prev = curr;
                curr.prev = temp;
                temp.next = curr;
            } else {
                curr = curr.next;
            }
        }
    }
    
    public boolean isSorted() {
        if (this.head == null) {
            return true;
        }
    
        // Check if the list is sorted in ascending order
        DNode curr = this.head;
        while (curr != this.tail) {
            if (curr.data > curr.next.data) {
                break;
            }
            curr = curr.next;
        }
        if (curr == this.tail) {
            return true;
        }
    
        // Check if the list is sorted in descending order
        curr = this.tail;
        while (curr != this.head) {
            if (curr.data > curr.prev.data) {
                break;
            }
            curr = curr.prev;
        }
        if (curr == this.head) {
            return true;
        }
    
        return false;
    }
}

