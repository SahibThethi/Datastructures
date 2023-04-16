package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

public class BST {
  private TNode root;

  public BST() {
    root = null;
  }

  public BST(int val) {
    root = new TNode(val, 0, null, null, null);
  }

  public BST(TNode obj) {
    root = obj;
  }

  public TNode getRoot() {
    return root;
  }

  public void setRoot(TNode root) {
    this.root = root;
  }

  public void insert(int val) {
    TNode newNode = new TNode(val, 0, null, null, null);
    if (root == null) {
      root = newNode;
    } else {
      TNode current = root;
      TNode parent;
      while (true) {
        parent = current;
        if (val < current.getData()) {
          current = current.getLeft();
          if (current == null) {
            parent.setLeft(newNode);
            newNode.setParent(parent);
            return;
          }
        } else {
          current = current.getRight();
          if (current == null) {
            parent.setRight(newNode);
            newNode.setParent(parent);
            return;
          }
        }
      }
    }
  }

  public void insert(TNode node) {
    if (root == null) {
      root = node;
    } else {
      TNode current = root;
      TNode parent;
      while (true) {
        parent = current;
        if (node.getData() < current.getData()) {
          current = current.getLeft();
          if (current == null) {
            parent.setLeft(node);
            return;
          }
        } else {
          current = current.getRight();
          if (current == null) {
            parent.setRight(node);
            return;
          }
        }
      }
    }
  }

  public void delete(int val) {
    TNode current = root;
    TNode parent = root;
    boolean isLeftChild = true;

    while (current.getData() != val) {
      parent = current;
      if (val < current.getData()) {
        isLeftChild = true;
        current = current.getLeft();
      } else {
        isLeftChild = false;
        current = current.getRight();
      }
      if (current == null) {
        return;
      }
    }

    if (current.getLeft() == null && current.getRight() == null) {
      if (current == root) {
        root = null;
      } else if (isLeftChild) {
        parent.setLeft(null);
      } else {
        parent.setRight(null);
      }
    } else if (current.getRight() == null) {
      if (current == root) {
        root = current.getLeft();
      } else if (isLeftChild) {
        parent.setLeft(current.getLeft());
      } else {
        parent.setRight(current.getLeft());
      }
    } else if (current.getLeft() == null) {
      if (current == root) {
        root = current.getRight();
      } else if (isLeftChild) {
        parent.setLeft(current.getRight());
      } else {
        parent.setRight(current.getRight());
      }
    } else {
      TNode successor = getSuccessor(current);
      if (current == root) {
        root = successor;
      } else if (isLeftChild) {
        parent.setLeft(successor);
      } else {
        parent.setRight(successor);
      }
      successor.setLeft(current.getLeft());
    }
  }

  public TNode getSuccessor(TNode delNode) {
    TNode successorParent = delNode;
    TNode successor = delNode;
    TNode current = delNode.getRight();
    while (current != null) {
      successorParent = successor;
      successor = current;
      current = current.getLeft();
    }
    if (successor != delNode.getRight()) {
      successorParent.setLeft(successor.getRight());
      successor.setRight(delNode.getRight());
    }
    return successor;
  }

  public TNode search(int val) {
    TNode current = root;
    while (current.getData() != val) {
      if (val < current.getData()) {
        current = current.getLeft();
      } else {
        current = current.getRight();
      }
      if (current == null) {
        return null;
      }
    }
    return current;
  }

  public void printInOrder() {
    printInOrder(root);
  }

  public void printInOrder(TNode root) {
    if (root != null) {
      printInOrder(root.getLeft());
      System.out.print(root.getData() + " ");
      printInOrder(root.getRight());
    }
  }

  public void printBF() {
    printBF(root);
  }

  public void printBF(TNode root) {
    int h = height(root);
    for (int i = 1; i <= h; i++) {
      printGivenLevel(root, i);
      System.out.println();
    }
  }

  public void printGivenLevel(TNode root, int level) {
    if (root == null) {
      return;
    }
    if (level == 1) {
      System.out.print(root.getData() + " ");
    } else if (level > 1) {
      printGivenLevel(root.getLeft(), level - 1);
      printGivenLevel(root.getRight(), level - 1);
    }
  }

  public int height(TNode root) {
    if (root == null) {
      return 0;
    } else {
      int lheight = height(root.getLeft());
      int rheight = height(root.getRight());

      if (lheight > rheight) {
        return (lheight + 1);
      } else {
        return (rheight + 1);
      }
    }
  }
}