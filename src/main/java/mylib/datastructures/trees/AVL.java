package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
  public AVL() {
    super();
  }
  
  public AVL(int val) {
    super(val);
  }
  
  public AVL(TNode obj) {
    super(obj);
    balance();
  }
  
  public void setRoot(TNode root) {
    super.setRoot(root);
    balance();
  }
  
  public void insert(int val) {
    super.insert(val);
    balance();
  }
  
  public void insert(TNode node) {
    super.insert(node);
    balance();
  }
  
  public TNode search(int val) {
    return super.search(val);
  }
  
  public void printInOrder() {
    super.printInOrder();
  }
  
  public void printBF() {
    super.printBF();
  }
  
  private void balance() {
  if (getRoot() == null) {
    return;
  }
  int balanceFactor = getBalanceFactor(getRoot());
  if (balanceFactor > 1) {
    if (getBalanceFactor(getRoot().getLeft()) >= 0) {
      setRoot(rightRotate(getRoot()));
    } else {
      getRoot().setLeft(leftRotate(getRoot().getLeft()));
      setRoot(rightRotate(getRoot()));
    }
  } else if (balanceFactor < -1) {
    if (getBalanceFactor(getRoot().getRight()) <= 0) {
      setRoot(leftRotate(getRoot()));
    } else {
      getRoot().setRight(rightRotate(getRoot().getRight()));
      setRoot(leftRotate(getRoot()));
    }
  }
  }

  public boolean isBalanced(TNode node) {
  if (node == null) {
    return true;
  }
  int balanceFactor = getBalanceFactor(node);
  if (balanceFactor < -1 || balanceFactor > 1) {
    return false;
  }
  return isBalanced(node.getLeft()) && isBalanced(node.getRight());
}
  
  private int getHeight(TNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
  }
  
  private int getBalanceFactor(TNode node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.getLeft()) - getHeight(node.getRight());
  }
  
  private TNode leftRotate(TNode node) {
    TNode newRoot = node.getRight();
    TNode temp = newRoot.getLeft();
    newRoot.setLeft(node);
    node.setRight(temp);
    return newRoot;
  }
  
  private TNode rightRotate(TNode node) {
    TNode newRoot = node.getLeft();
    TNode temp = newRoot.getRight();
    newRoot.setRight(node);
    node.setLeft(temp);
    return newRoot;
  }
}