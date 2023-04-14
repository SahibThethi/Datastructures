package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.*;

public class QueueLL extends SLL{

    public QueueLL(){
        super();
    }

    public QueueLL(SNode head){
        super(head);
    }

    @Override
    public void insertHead(SNode node) {

    }
    @Override
    public void insertTail(SNode node){

    }
    @Override
    public void insert(SNode node, int position){

    }
    @Override
    public void sortedInsert(SNode node) {

    }
    @Override
    public void deleteHead() {

    }
    @Override
    public void deleteTail() {

    }
    @Override
    public void sort() {

    }
    public SNode peek() {
        return this.head;
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
    @Override
    public void print() {
        System.out.print("Queue: ");
        super.print();
    }

}
