package mylib.datastructures.nodes;

public class TNode {
  public int data;
  public TNode left;
  public TNode right;
  public TNode parent;
  public int balance;

  // Constructors
  public TNode() {
    left = null;
    right = null;
    parent = null;
    balance = 0;
  }

  public TNode(int data, int balance, TNode P, TNode L, TNode R) {
    this.data = data;
    this.balance = balance;
    parent = P;
    left = L;
    right = R;
  }

  // Getters and Setters
  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public TNode getLeft() {
    return left;
  }

  public void setLeft(TNode left) {
    this.left = left;
  }

  public TNode getRight() {
    return right;
  }

  public void setRight(TNode right) {
    this.right = right;
  }

  public TNode getParent() {
    return parent;
  }

  public void setParent(TNode parent) {
    this.parent = parent;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  // Methods
  public String toString() {
    return "Data: " + data + " Balance: " + balance;
  }

  public void print() {
    System.out.println("Data: " + data + " Balance: " + balance);
  }
}