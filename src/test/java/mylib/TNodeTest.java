package mylib;
import mylib.datastructures.nodes.TNode;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class TNodeTest {
  
  @Test
  public void testTNode() {
    // Test the default constructor
    TNode node1 = new TNode();
    assertNull(node1.getLeft());
    assertNull(node1.getRight());
    assertNull(node1.getParent());
    assertEquals(0, node1.getBalance());

    // Test the parameterized constructor
    TNode node2 = new TNode(5, 1, null, null, null);
    assertEquals(5, node2.getData());
    assertEquals(1, node2.getBalance());
    assertNull(node2.getLeft());
    assertNull(node2.getRight());
    assertNull(node2.getParent());

    // Test the setters and getters
    node1.setData(10);
    assertEquals(10, node1.getData());
    node1.setBalance(-1);
    assertEquals(-1, node1.getBalance());
    node1.setLeft(node2);
    assertEquals(node2, node1.getLeft());
    node1.setParent(node2);
    assertEquals(node2, node1.getParent());
    node1.setRight(null);
    assertNull(node1.getRight());
  }

  @Test
  public void testToString() {
    TNode node = new TNode(5, 1, null, null, null);
    assertEquals("Data: 5 Balance: 1", node.toString());
  }

  @Test
  public void testPrint() {
    TNode node = new TNode(5, 1, null, null, null);
    // redirect standard output to a stream
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    // call the print method and check the output
    node.print();
    assertEquals("Data: 5 Balance: 1", outContent.toString().trim());
    // restore the original output stream
    System.setOut(System.out);
  }
}