package mylib.datastructures.linear;
import mylib.datastructures.nodes.*;

public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }
    public QueueLL(SNode head) {
        super(head);
    }

    @Override
    public void insertHead(SNode node) {
        // empty body method to prevent usage in queue
    }
    @Override
    public void insertTail(SNode node) {
        // empty body method to prevent usage in queue
    }
    @Override
    public void insert(SNode node, int position) {
        // empty body method to prevent usage in queue
    }
    @Override
    public void sortedInsert(SNode node) {
        // empty body method to prevent usage in queue
    }
    @Override
    public void deleteHead() {
        // empty body method to prevent usage in queue
    }
    @Override
    public void deleteTail() {
        // empty body method to prevent usage in queue
    }
    @Override
    public void sort() {
        // empty body method to prevent usage in queue
    }

    public void enqueue(SNode node) {
        super.insertTail(node);
    }
    public SNode dequeue() {
        SNode node = null;
        if (head != null) {
            node = head;
            super.deleteHead();
        }
        return node;
    }
    public SNode peek() {
        return this.head;
    }

    @Override
    public void print() {
        System.out.print("Front: ");
        SNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            } else {
                System.out.print(" -> null");
            }
            current = current.next;
        }
        System.out.println();
    }
}