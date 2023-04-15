package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
  public TNode root;

  public AVL() {
    super();
  }

  public AVL(int val) {
    super(val);
  }

  public AVL(TNode obj) {
    if (obj.getLeft() != null || obj.getRight() != null) {
      AVLfromBST(obj);
    } else {
      insert(obj);
    }
  }

  private void AVLfromBST(TNode node) {
    if (node != null) {
      AVLfromBST(node.getLeft());
      insert(node);
      AVLfromBST(node.getRight());
    }
  }

  @Override
  public void setRoot(TNode root) {
    if (root.getLeft() != null || root.getRight() != null) {
      AVLfromBST(root);
    } else {
      super.setRoot(root);
    }
  }

  public void balance(TNode node) {
    if (node != null) {
      balance(node.getLeft());
      balance(node.getRight());
      if (node.getBalance() > 1) {
        if (node.getLeft().getBalance() > 0) {
          // left-left case
          rotateRight(node);
        } else {
          // left-right case
          rotateLeft(node.getLeft());
          rotateRight(node);
        }
      } else if (node.getBalance() < -1) {
        if (node.getRight().getBalance() < 0) {
          // right-right case
          rotateLeft(node);
        } else {
          // right-left case
          rotateRight(node.getRight());
          rotateLeft(node);
        }
      }
    }
  }

  public void rotateLeft(TNode node) {
    TNode parent = node.getParent();
    TNode right = node.getRight();
    TNode rightLeft = right.getLeft();

    if (parent != null) {
      if (parent.getLeft() == node) {
        parent.setLeft(right);
      } else {
        parent.setRight(right);
      }
    } else {
      root = right;
    }

    right.setParent(parent);
    right.setLeft(node);
    node.setParent(right);
    node.setRight(rightLeft);
    if (rightLeft != null) {
      rightLeft.setParent(node);
    }
  }

  public void rotateRight(TNode node) {
    TNode parent = node.getParent();
    TNode left = node.getLeft();
    TNode leftRight = left.getRight();

    if (parent != null) {
      if (parent.getLeft() == node) {
        parent.setLeft(left);
      } else {
        parent.setRight(left);
      }
    } else {
      root = left;
    }

    left.setParent(parent);
    left.setRight(node);
    node.setParent(left);
    node.setLeft(leftRight);
    if (leftRight != null) {
      leftRight.setParent(node);
    }
  }

  public boolean isBalanced(TNode node) {
    if (node != null) {
      if (node.getBalance() > 1 || node.getBalance() < -1) {
        return false;
      } else {
        return isBalanced(node.getLeft()) && isBalanced(node.getRight());
      }
    } else {
      return true;
    }
  }

  @Override
  public void insert(int val) {
    super.insert(val);
    balance(root);
  }

  @Override
  public void insert(TNode node) {
    super.insert(node);
    balance(root);
  }
}