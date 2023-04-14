package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.*;

public class StackLL extends SLL {

    public StackLL() {
        super();
    }
    public StackLL(SNode head) {
        super(head);
    }
    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
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

    }
    @Override
    public void deleteTail() {

    }

    @Override
    public void delete(SNode node) {
        super.delete(node);
    }

    @Override
    public void sort() {
        // empty body method to prevent usage in stack
    }
    @Override
    public SNode search(int data) {
        // do nothing, as searching is not necessary for a stack
        return null;
    }

    @Override
    public void clear() {
        super.clear();
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
    public boolean isSorted() {
        // empty body method to prevent usage in stack
        return true;
    }

    @Override
    public void print() {
        System.out.print("Top: ");
        super.print();
    }
}
