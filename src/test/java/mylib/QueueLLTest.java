package mylib;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import mylib.datastructures.linear.*;
import mylib.datastructures.nodes.*;

public class QueueLLTest {
  private QueueLL queue;
  private SNode node1 = new SNode(1);
  private SNode node2 = new SNode(2);
  private SNode node3 = new SNode(3);
    
  @Before
  public void setUp() {
    queue = new QueueLL();
  }

  @Test
  public void testQueueLLConstructor() {
    QueueLL stack = new QueueLL();
    assertNull(stack.peek());
  }

  @Test
  public void testQueueLLConstructorWithSNode() {
    QueueLL stack = new QueueLL(node1);
    assertEquals(node1, stack.peek());
    assertEquals(1, stack.peek().getData());
  }

  @Test
  public void testPeek() {
    queue.enqueue(node1);
    queue.enqueue(node2);
    assertEquals(node1, queue.peek());
    assertEquals(1, queue.peek().getData());

    queue.dequeue();
    assertEquals(node2, queue.peek());
    assertEquals(2, queue.peek().getData());
  }

  @Test
  public void testEnqueue() {
    queue.enqueue(node1);
    assertEquals(node1, queue.peek());
    assertEquals(1, queue.peek().getData());

    queue.enqueue(node2);
    assertEquals(node1, queue.peek());
    assertEquals(1, queue.peek().getData());

    queue.dequeue();
    assertEquals(node2, queue.peek());
    assertEquals(2, queue.peek().getData());
  }

  @Test
  public void testDequeue() {
    queue.enqueue(node1);
    queue.enqueue(node2);
    assertEquals(node1, queue.peek());
    assertEquals(1, queue.peek().getData());

    queue.dequeue();
    assertEquals(node2, queue.peek());
    assertEquals(2, queue.peek().getData());

    queue.dequeue();
    assertNull(queue.peek());
  }

  @Test
  public void testClear() {
    queue.enqueue(node1);
    queue.enqueue(node2);
    assertFalse(queue.isEmpty());

    queue.clear();
    assertTrue(queue.isEmpty());
    assertNull(queue.peek());
  }

  @Test
  public void testPrint() {
    queue.enqueue(node1);
    queue.enqueue(node2);
    queue.enqueue(node3);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    queue.print();
    assertEquals("Front: 1 -> 2 -> 3 -> null", outContent.toString().trim());
  }
}