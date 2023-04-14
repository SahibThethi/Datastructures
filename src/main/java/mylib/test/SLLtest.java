package main.java.mylib.test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;

public class SLLtest {
    private SLL emptyList;
    private SLL list;
    private SLL multiNodeList;
    
    @Before
    public void setUp() throws Exception {
        emptyList = new SLL();
        multiNodeList = new SLL();
        multiNodeList.insertHead(new SNode(5));
        multiNodeList.insertHead(new SNode(3));
        multiNodeList.insertTail(new SNode(7));
    }
    
    @Test
    public void testInsertHead() {
        emptyList.insertHead(new SNode(1));
        assertEquals("Size should be 1", 1, emptyList.getSize());
        assertEquals("Head should be the new node", 1, emptyList.getHead().data);
        
        SNode node = new SNode(2);
        multiNodeList.insertHead(node);
        assertEquals("Size should be 4", 4, multiNodeList.getSize());
        assertEquals("Head should be the new node", 2, multiNodeList.getHead().data);
        assertEquals("Next node should be the previous head", 3, multiNodeList.getHead().next.data);
    }
    
    @Test
    public void testInsertTail() {
        emptyList.insertTail(new SNode(1));
        assertEquals("Size should be 1", 1, emptyList.getSize());
        assertEquals("Tail should be the new node", 1, emptyList.getTail().data);
        
        SNode node = new SNode(6);
        multiNodeList.insertTail(node);
        assertEquals("Size should be 4", 4, multiNodeList.getSize());
        assertEquals("Tail should be the new node", 6, multiNodeList.getTail().data);
    }
    
    @Test
    public void testInsert() {
        emptyList.insert(new SNode(1), 1);
        assertEquals("Size should be 1", 1, emptyList.getSize());
        assertEquals("Head and tail should be the new node", 1, emptyList.getHead().data);
        assertEquals("Head and tail should be the new node", 1, emptyList.getTail().data);
        
        SNode node = new SNode(4);
        multiNodeList.insert(node, 2);
        assertEquals("Size should be 4", 4, multiNodeList.getSize());
        assertEquals("Second node should be the new node", 4, multiNodeList.getHead().next.data);
        
        multiNodeList.insert(new SNode(8), 5);
        assertEquals("Size should be 5", 5, multiNodeList.getSize());
        assertEquals("Tail should be the new node", 8, multiNodeList.getTail().data);
    }

    @Test
    public void testSortedInsert() {
        list = new SLL();
        SNode node1 = new SNode(1);
        list.sortedInsert(node1);
        assertEquals(1, list.getSize());
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertTrue(list.isSorted());
    
        SNode node2 = new SNode(2);
        list.sortedInsert(node2);
        assertEquals(2, list.getSize());
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertTrue(list.isSorted());
    
        SNode node0 = new SNode(0);
        list.sortedInsert(node0);
        assertEquals(3, list.getSize());
        assertEquals(node0, list.getHead());
        assertEquals(node2, list.getTail());
        assertTrue(list.isSorted());
    
        SNode node3 = new SNode(3);
        list.sortedInsert(node3);
        assertEquals(4, list.getSize());
        assertEquals(node0, list.getHead());
        assertEquals(node3, list.getTail());
        assertTrue(list.isSorted());
    }

    @Test
    public void testEmptyList() {
        SLL list = new SLL();
        assertEquals(null, list.getHead());
        list.print(); // should print "List is empty"
    }

    @Test
    public void testSingleNodeList() {
        SNode node = new SNode(42);
        SLL list = new SLL(node);
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        assertEquals(1, list.getSize());
        assertEquals(true, list.isSorted());
        list.print(); // should print "List length: 1\nSorted: Yes\nList content: 42\n"
    }

    @Test
    public void testSearch() {
        list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(node1, list.search(1));
        assertEquals(node2, list.search(2));
        assertEquals(node3, list.search(3));
        assertNull(list.search(0));
        assertNull(list.search(4));
    }

    @Test
    public void testDeleteHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SLL list = new SLL(node1);
        list.insertHead(node2);
        list.insertTail(node3);
        assertEquals(3, list.getSize());
        assertEquals(2, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        list.deleteHead();
        assertEquals(2, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
    }

    @Test
    public void testDeleteTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SLL list = new SLL(node1);
        list.insertHead(node2);
        list.insertTail(node3);
        assertEquals(3, list.getSize());
        assertEquals(2, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        list.deleteTail();
        assertEquals(2, list.getSize());
        assertEquals(2, list.getHead().getData());
        assertEquals(1, list.getTail().getData());
        list.sort();
        assertTrue(list.isSorted());
    }
    
    @Test
    public void testDelete() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SLL list = new SLL(node1);
        list.insertHead(node2);
        list.insertTail(node3);
        assertEquals(3, list.getSize());
        assertEquals(2, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        list.delete(node2);
        assertEquals(2, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        list.delete(node3);
        assertEquals(1, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(1, list.getTail().getData());
        list.delete(node1);
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    // Test the constructor with no arguments
    @Test
    public void testConstructor() {
        SLL list = new SLL();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getSize());
        assertTrue(list.isSorted());
    }
    
    // Test the constructor with one argument
    @Test
    public void testConstructorWithHead() {
        SNode head = new SNode(1);
        SLL list = new SLL(head);
        assertEquals(head, list.getHead());
        assertEquals(head, list.getTail());
        assertEquals(1, list.getSize());
        assertTrue(list.isSorted());
    }
    
    // Test the sort method on an unsorted list
    @Test
    public void testSort() {
        SLL list = new SLL();
        list.head = new SNode(3);
        list.head.next = new SNode(1);
        list.head.next.next = new SNode(2);
        list.tail = list.getHead().next.next;
        list.size = 3;
        list.sort();
        assertTrue(list.isSorted());
        assertEquals(1, list.getHead().data);
        assertEquals(2, list.getHead().next.data);
        assertEquals(3, list.getTail().data);
    }
    
    // Test the sort method on a sorted list
    @Test
    public void testSortOnSorted() {
        SLL list = new SLL();
        list.head = new SNode(1);
        list.head.next = new SNode(2);
        list.head.next.next = new SNode(3);
        list.tail = list.getHead().next.next;
        list.size = 3;
        list.sort();
        assertTrue(list.isSorted());
        assertEquals(1, list.getHead().data);
        assertEquals(2, list.getHead().next.data);
        assertEquals(3, list.getTail().data);
    }
    
    // Test the clear method
    @Test
    public void testClear() {
        SNode head = new SNode(1);
        SLL list = new SLL(head);
        list.clear();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getSize());
        assertTrue(list.isSorted());
    }
    
    // Test the print method on an empty list
    @Test
    public void testPrintEmptyList() {
        list = new SLL();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        assertEquals("List is empty", outContent.toString().trim());
    }

    @Test
    public void testPrintUnsorted() {
        SNode head = new SNode(3);
        head.next = new SNode(1);
        head.next.next = new SNode(2);
        SLL list = new SLL();
        list.head = head;
        list.size = 3;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 3\n" +
        "Sorted status: not sorted\n" +
        "List content: 3 1 2\n";
        String[] expectedLines = expectedOutput.split("\n");

        String actualOutput = outContent.toString();
        String[] actualLines = actualOutput.split("\n");

        for (int i = 0; i < expectedLines.length; i++) {
        assertEquals(expectedLines[i], actualLines[i].trim());
        }
    }

    // Test the isSorted method on a sorted list
    @Test
    public void testIsSortedSorted() {
        SNode head = new SNode(1);
        head.next = new SNode(2);
        head.next.next = new SNode(3);
        SLL list = new SLL();
        list.head = head;
        list.size = 3;
        assertTrue(list.isSorted());
    }

    // Test the isSorted method on an unsorted list
    @Test
    public void testIsSortedUnsorted() {
        SNode head = new SNode(3);
        head.next = new SNode(1);
        head.next.next = new SNode(2);
        SLL list = new SLL();
        list.head = head;
        list.size = 3;
        assertFalse(list.isSorted());
    }
}
