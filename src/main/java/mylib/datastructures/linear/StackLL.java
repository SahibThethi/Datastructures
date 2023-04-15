package mylib.datastructures.linear;
import mylib.datastructures.nodes.*;

public class StackLL extends SLL {

    public StackLL() {
        super();
    }
    public StackLL(SNode head) {
        super(head);
    }
    
    @Override
    public void insertHead(SNode node) {
        // empty body method to prevent usage in queue
    }
    @Override
    public void insertTail(SNode node) {
        // empty body method to prevent usage in stack
    }
    @Override
    public void insert(SNode node, int position) {
        // empty body method to prevent usage in stack
    }
    @Override
    public void sortedInsert(SNode node) {
        // empty body method to prevent usage in stack
    }
    @Override
    public void deleteHead() {
        // empty body method to prevent usage in stack
    }
    @Override
    public void deleteTail() {
        // empty body method to prevent usage in stack
    }
    @Override
    public void delete(SNode node) {
        // empty body method to prevent usage in queue
    }
    @Override
    public void sort() {
        // empty body method to prevent usage in stack
    }

    public void push(SNode node) {
        super.insertHead(node);
    }
    public SNode pop() {
        SNode node = super.getHead();
        super.deleteHead();
        return node;
    }
    public SNode peek() {
        return super.getHead();
    }

    @Override
    public void print() {
        System.out.print("Top -> ");
        SNode current = getHead();
        while (current != null) {
            System.out.print(current.getData());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            } else {
                System.out.print(" -> null");
            }
            current = current.getNext();
        }
    }
}