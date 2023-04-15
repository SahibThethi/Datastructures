package mylib;
import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.BST;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BSTTest {
  @Test
  public void testBSTConstructor() {
    BST bst = new BST();
    assertNull(bst.getRoot());
  }

  @Test
  public void testBSTConstructorWithInt() {
    BST bst = new BST(1);
    assertEquals(1, bst.getRoot().getData());
  }

  @Test
  public void testBSTConstructorWithTNode() {
    TNode node = new TNode(2, 0, null, null, null);
    BST bst = new BST(node);
    assertEquals(2, bst.getRoot().getData());
  }

  @Test
  public void testGetRoot() {
    BST bst = new BST(3);
    assertEquals(3, bst.getRoot().getData());
  }

  @Test
  public void testSetRoot() {
    BST bst = new BST();
    TNode node = new TNode(4, 0, null, null, null);
    bst.setRoot(node);
    assertEquals(4, bst.getRoot().getData());
  }

  @Test
  public void testInsert() {
    BST bst = new BST(7);
    bst.insert(10); // Inserting a value larger than the root node
    bst.insert(5);  // Inserting a value smaller than the root node
    bst.insert(12);
    bst.insert(15);
    bst.insert(4);
    bst.insert(4);  // Inserting a duplicate value
    bst.insert(6);
    
    TNode root = bst.getRoot();
    assertEquals(7, root.getData()); // Asserting that the root node has a value of 7
    assertEquals(10, root.getRight().getData()); // Asserting that the right child of the root node has a value of 20
    assertEquals(5, root.getLeft().getData()); // Asserting that the left child of the root node has a value of 5
    assertEquals(12, root.getRight().getRight().getData());
    assertEquals(15, root.getRight().getRight().getRight().getData());
    assertEquals(4, root.getLeft().getLeft().getData());
    assertEquals(6, root.getLeft().getRight().getData());
  }

  @Test
  public void testInsertWithTNode() {
    BST bst = new BST();
    bst.insert(new TNode(8, 0, null, null, null));
    bst.insert(new TNode(11, 0, null, null, null)); // Inserting a value larger than the root node
    bst.insert(new TNode(6, 0, null, null, null));  // Inserting a value smaller than the root node
    bst.insert(new TNode(13, 0, null, null, null));
    bst.insert(new TNode(3, 0, null, null, null));
    bst.insert(new TNode(3, 0, null, null, null));  // Inserting a duplicate value
    bst.insert(new TNode(9, 0, null, null, null));
    
    TNode root = bst.getRoot();
    assertEquals(8, root.getData()); // Asserting that the root node has a value of 7
    assertEquals(11, root.getRight().getData()); // Asserting that the right child of the root node has a value of 20
    assertEquals(6, root.getLeft().getData()); // Asserting that the left child of the root node has a value of 5
    assertEquals(13, root.getRight().getRight().getData());
    assertEquals(3, root.getLeft().getLeft().getData());
    assertEquals(9, root.getRight().getLeft().getData());
  }

  @Test
  public void testBSTDelete() {
    BST bst = new BST(5); // Create a new BST with a root node of 5
    bst.insert(6);
    bst.insert(4);

    bst.delete(4);
    assertEquals(5, bst.getRoot().getData()); // Same root node
    assertNull(bst.search(4));                // Deleted node should not be found
    assertEquals(6, bst.search(6).getData()); // Other nodes should still be there

    bst.delete(5);
    assertEquals(6, bst.getRoot().getData()); // Root node should now be 6
    assertNull(bst.search(5));

    bst.delete(6);
    assertNull(bst.getRoot()); // Root node should now be null
  }

  @Test
  public void testSearch() {
    BST bst = new BST();
    bst.insert(10);
    bst.insert(20);
    bst.insert(30);
    bst.insert(40);
    bst.insert(50);
    
    TNode node = bst.search(30);      // Search for a node with a value of 30
    assertEquals(30, node.getData()); // Node should be found
    
    node = bst.search(15);  // Search for a node with a value of 15
    assertNull(node);       // Node should not be found
  }
    
  @Test
  public void testPrintInOrder() {
    BST bst = new BST(7);
    bst.insert(10); // Inserting a value larger than the root node
    bst.insert(5);  // Inserting a value smaller than the root node
    bst.insert(12);
    bst.insert(15);
    bst.insert(4);
    bst.insert(4);  // Inserting a duplicate value
    bst.insert(6);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    bst.printInOrder();
    assertEquals("4 4 5 6 7 10 12 15", outContent.toString().trim());
  }
    
  @Test
  public void testPrintBF() {
    BST bst = new BST(7);
    bst.insert(10); // Inserting a value larger than the root node
    bst.insert(5);  // Inserting a value smaller than the root node
    bst.insert(12);
    bst.insert(15);
    bst.insert(4);
    bst.insert(4);  // Inserting a duplicate value
    bst.insert(6);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    bst.printBF();
    String expectedOutput = "7\n" +
    "5 10\n" +
    "4 6 12\n" +
    "4 15";
    String[] expectedLines = expectedOutput.split("\n");

    String actualOutput = outContent.toString();
    String[] actualLines = actualOutput.split("\n");

    for (int i = 0; i < expectedLines.length; i++) {
      assertEquals(expectedLines[i], actualLines[i].trim());
    }
  }
}