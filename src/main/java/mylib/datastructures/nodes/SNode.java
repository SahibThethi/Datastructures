package mylib.datastructures.nodes;

public class SNode {
    public int data;
    public SNode next;

    public SNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SNode getNext() {
        return this.next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}