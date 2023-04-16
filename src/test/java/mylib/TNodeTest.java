package mylib;
import mylib.datastructures.nodes.TNode;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class TNodeTest {

  @Test
  public void testDefaultConstructor() {
    TNode node = new TNode();
    assertNull(node.getLeft());
    assertNull(node.getRight());
    assertNull(node.getParent());
    assertEquals(0, node.getBalance());
  }

  @Test
  public void testParameterizedConstructor() {
    TNode node = new TNode(5, 1, null, null, null);
    assertEquals(5, node.getData());
    assertEquals(1, node.getBalance());
    assertNull(node.getLeft());
    assertNull(node.getRight());
    assertNull(node.getParent());
  }

  @Test
  public void testSettersAndGetters() {
    TNode node = new TNode();
    node.setData(10);
    assertEquals(10, node.getData());
    node.setBalance(-1);
    assertEquals(-1, node.getBalance());
    node.setLeft(node);
    assertEquals(node, node.getLeft());
    node.setParent(node);
    assertEquals(node, node.getParent());
    node.setRight(null);
    assertNull(node.getRight());
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