package main.java.mylib.test;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.java.mylib.datastructures.linear.*;
import main.java.mylib.datastructures.nodes.*;

public class StackLLTest {
  private StackLL stack;
  private SNode node1 = new SNode(1);
  private SNode node2 = new SNode(2);
  private SNode node3 = new SNode(3);
    
  @Before
  public void setUp() {
    stack = new StackLL();
  }
  
  @Test
  public void testPeek() {
    stack.push(node1);
    stack.push(node2);
    assertEquals(node2, stack.peek());
    assertEquals(2, stack.peek().getData());

    stack.pop();
    assertEquals(node1, stack.peek());
    assertEquals(1, stack.peek().getData());
  }
      
  @Test
  public void testPush() {
    stack.push(node1);
    assertEquals(node1, stack.peek());
    assertEquals(1, stack.peek().getData());
    
    stack.push(node2);
    assertEquals(node2, stack.peek());
    assertEquals(2, stack.peek().getData());
  }
  
  @Test
  public void testPop() {
    stack.push(node1);
    stack.push(node2);
    assertEquals(node2, stack.peek());
    assertEquals(2, stack.peek().getData());

    stack.pop();
    assertEquals(node1, stack.peek());
    assertEquals(1, stack.peek().getData());

    stack.pop();
    assertNull(stack.peek());
  }
  
  @Test
  public void testClear() {
    stack.push(node1);
    stack.push(node2);
    assertFalse(stack.isEmpty());

    stack.clear();
    assertTrue(stack.isEmpty());
    assertNull(stack.peek());
  }
  
  @Test
  public void testPrint() {
    stack.push(node1);
    stack.push(node2);
    stack.push(node3);
    
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    
    stack.print();
    assertEquals("Top -> 3 -> 2 -> 1 -> null", outContent.toString().trim());
  }
}