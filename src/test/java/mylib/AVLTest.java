package mylib;
import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AVLTest {
  @Test
  public void testAVLConstructor() {
    AVL avl = new AVL();
    assertNull(avl.getRoot());
  }

  @Test
  public void testAVLContstructorWithInt() {
    AVL avl = new AVL(1);
    assertEquals(1, avl.getRoot().getData());
  }

  @Test
  public void testAVLConstructorWithTNode() {
    TNode node = new TNode(2, 0, null, null, null);
    AVL avl = new AVL(node);
    assertEquals(2, avl.getRoot().getData());
  }

  @Test
  public void testGetRoot() {
    AVL avl = new AVL(3);
    assertEquals(3, avl.getRoot().getData());
  }

  @Test
  public void testSetRoot() {
    AVL avl = new AVL();
    TNode node = new TNode(4, 0, null, null, null);
    avl.setRoot(node);
    assertEquals(4, avl.getRoot().getData());
  }

  @Test
  public void testInsert() {
    AVL avl = new AVL(3);
    avl.insert(5);
    avl.insert(7);
    avl.insert(9);
    avl.insert(1);
    avl.insert(4);
    avl.insert(4);
    
    TNode root = avl.getRoot();
    assertEquals(5, root.getData());
    assertEquals(3, root.getLeft().getData());
    assertEquals(7, root.getRight().getData());
    assertEquals(1, root.getLeft().getLeft().getData());
    assertEquals(4, root.getLeft().getRight().getData());
    assertEquals(9, root.getRight().getRight().getData());

    assertTrue(avl.isBalanced(root));
  }

  @Test
  public void testInsertWithTNode() {
    AVL avl = new AVL(3);
    avl.insert(new TNode(5, 0, null, null, null));
    avl.insert(new TNode(7, 0, null, null, null));
    avl.insert(new TNode(9, 0, null, null, null));
    avl.insert(new TNode(1, 0, null, null, null));
    avl.insert(new TNode(4, 0, null, null, null));
    avl.insert(new TNode(4, 0, null, null, null));
    
    TNode root = avl.getRoot();
    assertEquals(5, root.getData());
    assertEquals(3, root.getLeft().getData());
    assertEquals(7, root.getRight().getData());
    assertEquals(1, root.getLeft().getLeft().getData());
    assertEquals(4, root.getLeft().getRight().getData());
    assertEquals(9, root.getRight().getRight().getData());

    assertTrue(avl.isBalanced(root));
  }

  @Test
  public void testSearch() {
    AVL avl = new AVL();
    avl.insert(10);
    avl.insert(20);
    avl.insert(30);
    avl.insert(40);
    avl.insert(50);
    
    TNode node = avl.search(30);
    assertEquals(30, node.getData());
    
    node = avl.search(15);
    assertNull(node);
  }
    
  @Test
  public void testPrintInOrder() {
    AVL avl = new AVL(3);
    avl.insert(5);
    avl.insert(7);
    avl.insert(9);
    avl.insert(1);
    avl.insert(4);
    avl.insert(4);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    avl.printInOrder();
    assertEquals("1 3 4 4 5 7 9", outContent.toString().trim());
  }
    
  @Test
  public void testPrintBF() {
    AVL avl = new AVL(3);
    avl.insert(5);
    avl.insert(7);
    avl.insert(9);
    avl.insert(1);
    avl.insert(4);
    avl.insert(4);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    avl.printBF();
    String expectedOutput = "5\n" +
    "3 7\n" +
    "1 4 9\n" +
    "4";
    String[] expectedLines = expectedOutput.split("\n");

    String actualOutput = outContent.toString();
    String[] actualLines = actualOutput.split("\n");

    for (int i = 0; i < expectedLines.length; i++) {
      assertEquals(expectedLines[i], actualLines[i].trim());
    }
  }
}