package main.java.mylib.test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.CSLL;
import main.java.mylib.datastructures.nodes.*;

public class CSLLtest {
    @Test
    public void testConstructor1() {
        // Test constructor with no arguments
        CSLL list = new CSLL();
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
    }

    @Test
    public void testConstructor2() {
        // Test constructor with one argument
        SNode head = new SNode(1);
        CSLL list = new CSLL(head);
        assertEquals(1, list.getSize());
        assertEquals(head, list.getHead());
        assertEquals(head, list.getHead().getNext());
    }

    @Test
    public void testInsertHead() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        
        list.insertHead(node1);
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());
        
        list.insertHead(node2);
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(2, list.getSize());
        assertEquals(node1, node2.getNext());
        assertEquals(node2, node1.getNext());
    }
    @Test
    public void testInsertTail() {
        // create a new CSLL instance
        CSLL csll = new CSLL();

        // create some nodes to insert
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        // insert the nodes into the CSLL
        csll.insertTail(node1);
        csll.insertTail(node2);
        csll.insertTail(node3);

        // check that the tail of the CSLL points to the head
        assertEquals(csll.tail.getNext(), csll.head);
    }
    @Test
    public void testInsert() {
    // Create a new CSLL
    CSLL list = new CSLL();
    
    // Create some nodes to insert
    SNode node1 = new SNode(1);
    SNode node2 = new SNode(2);
    SNode node3 = new SNode(3);
    
    // Insert the nodes into the CSLL at positions 0, 1, and 2
    list.insert(node1, 1);
    list.insert(node2, 2);
    list.insert(node3, 3);
    
    // Check that the head and tail of the list are correct
    assertNotNull(list.head);
    assertNotNull(list.tail);
    assertEquals(node1, list.head);
    assertEquals(node3, list.tail);
    assertEquals(node1, list.tail.getNext());
    
    // Check that the nodes are in the correct positions
    assertNotNull(node1.getNext());
    assertNotNull(node2.getNext());
    assertNotNull(node3.getNext());
    assertEquals(node1.getNext(), node2);
    assertEquals(node2.getNext(), node3);
    assertEquals(node3.getNext(), node1);
    }
    @Test(expected = NullPointerException.class)
    public void testDeleteHeadFromEmptyList() {
        CSLL list = new CSLL();
        list.deleteHead();
    }

    @Test
    public void testDeleteHeadNonEmptyList() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertHead(node3);
        list.insertHead(node2);
        list.insertHead(node1);
        list.deleteHead();
        assertEquals(2, list.getSize());
        assertEquals(2, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        assertEquals(list.getHead().getNext(), list.getTail());
    }
    @Test
    public void testSearch() {
        // Create a new circular singly linked list
        CSLL list = new CSLL();
        
        // Test case 1: Search an empty list
        try {
            list.search(10);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        }
        
        // Test case 2: Search a list with one node
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        SNode node3 = new SNode(15);
        list.insertHead(node1);
        SNode result = list.search(5);
        assertEquals(5, result.data);
        
        // Test case 3: Search a list with multiple nodes
        list.insertHead(node2);
        list.insertHead(node3);
        result = list.search(10);
        assertEquals(10, result.data);
        
        // Test case 4: Search for a non-existent value
        result = list.search(20);
        assertNull(result);
    }
    @Test(expected = NullPointerException.class)
    public void testDeleteTailWithEmptyList() {
        CSLL list = new CSLL();
        list.deleteTail();
    }

    @Test
    public void testDeleteTailWithOneNode() {
        CSLL list = new CSLL();
        SNode node = new SNode(1);
        list.insertTail(node);
        list.deleteTail();
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testDeleteTailWithMultipleNodes() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteTail();
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteWithEmptyList() {
        CSLL list = new CSLL();
        list.delete(null);
    }

    @Test
    public void testDeleteWithOneNode() {
        CSLL list = new CSLL();
        SNode node = new SNode(1);
        list.insertTail(node);
        list.delete(node);
        assertEquals(null, list.getHead());
        assertEquals(null, list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testDeleteWithMultipleNodes() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.delete(node2);
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testSort() {
        // Create a linked list with unsorted data
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        CSLL list = new CSLL();
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.insertTail(node4);
        
        // Call the sort method to sort the list
        list.sort();
        
        // Check that the list is now sorted
        assertEquals(4, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().getNext().getData());
        assertEquals(3, list.getHead().getNext().getNext().getData());
        assertEquals(4, list.getTail().getData());
    }
    
    @Test
    public void testSortEmptyList() {
        // Create an empty linked list
        CSLL list = new CSLL();
        
        // Call the sort method on the empty list
        Exception exception = assertThrows(NullPointerException.class, () -> {
            list.sort();
        });
        
        // Check that the expected exception is thrown
        assertEquals("List is empty", exception.getMessage());
    }
    @Test
    public void testClear() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.clear();
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testPrintSortedList() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 3\n" +
        "Sorted status: sorted\n" +
        "List content: 1 2 3\n";
        String[] expectedLines = expectedOutput.split("\n");

        String actualOutput = outContent.toString();
        String[] actualLines = actualOutput.split("\n");

        for (int i = 0; i < expectedLines.length; i++) {
        assertEquals(expectedLines[i], actualLines[i].trim());
        };
    }
    
    @Test
    public void testPrintUnsortedList() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        list.insertTail(node2);
        list.insertTail(node3);
        list.insertTail(node1);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 3\n" +
        "Sorted status: unsorted\n" +
        "List content: 2 3 1\n";
        String[] expectedLines = expectedOutput.split("\n");

        String actualOutput = outContent.toString();
        String[] actualLines = actualOutput.split("\n");

        for (int i = 0; i < expectedLines.length; i++) {
        assertEquals(expectedLines[i], actualLines[i].trim());
        }
    }
    
    @Test(expected = NullPointerException.class)
    public void testPrintEmptyList() {
        CSLL list = new CSLL();
        list.print();
    }
    private CSLL list;

    @Before
    public void setUp() {
        list = new CSLL();
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(3));
        list.insertTail(new SNode(5));
    }
   
    @Test
    public void testSortedInsertHead() {
        CSLL list = new CSLL(new SNode(20));
        list.insertHead(new SNode(10));
        SNode node = new SNode(5);
        list.sortedInsert(node);
        assertEquals(3, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(20, list.getTail().getData());
        assertEquals(node.getNext(), list.getHead().getNext());
    }
    
    @Test
    public void testSortedInsertTail() {
        CSLL list = new CSLL(new SNode(10));
        list.insertTail(new SNode(20));
        SNode node = new SNode(30);
        list.sortedInsert(node);
        assertEquals(3, list.getSize());
        assertEquals(10, list.getHead().getData());
        assertEquals(node, list.getTail());
        assertEquals(node.getNext(), list.getHead());
    }
    
    @Test
    public void testSortedInsertMiddle() {
        CSLL list = new CSLL(new SNode(10));
        list.insertTail(new SNode(20));
        list.insertTail(new SNode(30));
        SNode node = new SNode(25);
        list.sortedInsert(node);
        assertEquals(4, list.getSize());
        assertEquals(10, list.getHead().getData());
        assertEquals(30, list.getTail().getData());
        assertEquals(node.getNext(), list.getTail());
        assertEquals(node, list.getHead().getNext().getNext());
    }
    
}
