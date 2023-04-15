package main.java.mylib.test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.linear.CDLL;
import main.java.mylib.datastructures.nodes.DNode;

public class CDLLtest {
    @Test
    public void testInsertHead() {
        CDLL list = new CDLL();
        list.insertHead(new DNode(1));
        list.insertHead(new DNode(2));
        list.insertHead(new DNode(3));
        assertEquals(list.search(1), list.getTail());
        assertEquals(list.search(2), list.getTail().prev);
        assertEquals(list.search(3), list.getTail().prev.prev);
    }
    
    @Test
    public void testInsertTail() {
        CDLL list = new CDLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        assertEquals(list.search(1), list.getHead());
        assertEquals(list.search(2), list.getHead().next);
        assertEquals(list.search(3), list.getHead().next.next);
    }
    
    @Test
    public void testInsert() {
        CDLL list = new CDLL();
        list.insert(new DNode(1), 1);
        list.insert(new DNode(3), 2);
        list.insert(new DNode(2), 3);
        assertEquals(list.search(2), list.getTail());
        assertEquals(list.search(3), list.getTail().prev);
        assertEquals(list.search(1), list.getHead());
    }
    
    @Test
    public void testDeleteHead() {
        CDLL list = new CDLL(new DNode(1));
        list.insertHead(new DNode(2));
        list.insertHead(new DNode(3));
        list.deleteHead();
        assertEquals(list.search(2), list.getHead());
        assertEquals(list.search(1), list.getHead().next);
        assertEquals(list.search(1), list.getHead().prev);
    }
    
    @Test
    public void testDeleteTail() {
        CDLL list = new CDLL(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        list.deleteTail();
        assertEquals(list.search(2), list.getTail());
        assertEquals(list.search(1), list.getTail().prev);
    }
    
    @Test
    public void testDelete() {
        CDLL list = new CDLL(new DNode(1));
        list.insertHead(new DNode(2));
        list.insertHead(new DNode(3));
        list.delete(list.search(2));
        assertEquals(list.search(3), list.getHead());
        assertEquals(list.search(1), list.getTail());
    }
    
    @Test
    public void testSetCurrent() {
        CDLL list = new CDLL(new DNode(1));
        list.insertHead(new DNode(2));
        list.insertHead(new DNode(3));
        list.setCurrent(list.search(2));
        assertEquals("Setting current to node with data 2 should return that node", list.getCurrent(), list.search(2));
    }
    
    @Test
    public void testStepForward() {
        CDLL list = new CDLL(new DNode(1));
        list.insertHead(new DNode(2));
        list.insertHead(new DNode(3));
        list.setCurrent(list.search(2));
        list.stepForward();
        assertEquals(list.getCurrent(), list.search(1));
        list.stepForward();
        assertEquals(list.getCurrent(), list.search(3));
        list.stepForward();
        assertEquals(list.getCurrent(), list.search(2));
    }

    @Test
    public void testStepBackward() {
        // Test empty list
        CDLL list = new CDLL();
        list.stepBackward(); // should print "List is empty."
        
        // Test list with one element
        DNode node1 = new DNode(1);
        list.insertHead(node1);
        list.setCurrent(node1);
        list.stepBackward(); // should print "List only has one element."
        
        // Test list with multiple elements
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertTail(node2);
        list.insertTail(node3);
        list.stepBackward();
        assertEquals(node3, list.getCurrent());
        list.stepBackward();
        assertEquals(node2, list.getCurrent());
        list.stepBackward();
        assertEquals(node1, list.getCurrent());
    }
    
    @Test
    public void testPrint() {
        CDLL list = new CDLL();
        list.insertHead(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 3\n" +
        "Sorted status: true\n" +
        "List content: 1 2 3\n";
        String[] expectedLines = expectedOutput.split("\n");

        String actualOutput = outContent.toString();
        String[] actualLines = actualOutput.split("\n");

        for (int i = 0; i < expectedLines.length; i++) {
        assertEquals(expectedLines[i], actualLines[i].trim());
        }
    }
    @Test
    public void testSearch() {
        // Test empty list
        CDLL list = new CDLL();
        assertThrows(NullPointerException.class, () -> list.search(1));
        
        // Test list with one element
        DNode node1 = new DNode(1);
        list.insertHead(node1);
        list.setCurrent(node1);
        assertEquals(node1, list.search(1));
        assertNull(list.search(2));
        
        // Test list with multiple elements
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertTail(node2);
        list.insertTail(node3);
        assertEquals(node2, list.search(2));
        assertNull(list.search(4));
    }
    private CDLL list;

    @Before
    public void setUp() {
        list = new CDLL();
    }

    @Test
    public void testSortedInsert() {
        // Test inserting into an empty list
        list.SortedInsert(new DNode(5));
        assertEquals(5, list.search(5).getData());

        // Test inserting at the head
        list.SortedInsert(new DNode(3));
        assertEquals(3, list.search(3).getData());

        // Test inserting in the middle
        list.SortedInsert(new DNode(4));
        assertEquals(4, list.search(4).getData());

        // Test inserting at the tail
        list.SortedInsert(new DNode(7));
        assertEquals(7, list.search(7).getData());
    }

    @Test
    public void testSort() {
        // Test sorting an empty list
        list.Sort();
        assertTrue(list.isEmpty());
    
        // Test sorting a list with one element
        list.insertHead(new DNode(1));
        list.Sort();
        assertEquals(1, list.getLength());
        assertEquals(1, list.search(1).getData());
    
        // Test sorting a list with multiple elements
        list.insertTail(new DNode(4));
        list.insertHead(new DNode(3));
        list.insertTail(new DNode(5));
        list.insertHead(new DNode(2));
        list.Sort();
        assertEquals(5, list.getLength());
        assertTrue(list.isSorted());
        assertEquals(1, list.search(1).getData());
        assertEquals(2, list.search(2).getData());
        assertEquals(3, list.search(3).getData());
        assertEquals(4, list.search(4).getData());
        assertEquals(5, list.search(5).getData());
    
        // Test sorting an already sorted list
        list.Sort();
        assertEquals(5, list.getLength());
        assertTrue(list.isSorted());
    }    

    @Test
    public void testIsSorted() {
        // Test an empty list
        assertTrue(list.isSorted());

        // Test a list with one element
        list.insertHead(new DNode(1));
        assertTrue(list.isSorted());

        // Test a sorted list with multiple elements
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        assertTrue(list.isSorted());

        // Test an unsorted list with multiple elements
        list.insertTail(new DNode(1));
        assertFalse(list.isSorted());
    }
    @Test
    public void testDefaultConstructor() {
        CDLL cdll = new CDLL();
        assertNotNull(cdll);
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
        assertNull(cdll.getCurrent());
        assertEquals(0, cdll.getLength());
    }

    @Test
    public void testSingleElementConstructor() {
        DNode node = new DNode(1);
        CDLL cdll = new CDLL(node);
        assertNotNull(cdll);
        assertEquals(node, cdll.getHead());
        assertEquals(node, cdll.getTail());
        assertEquals(node, cdll.getCurrent());
        assertEquals(1, cdll.getLength());
    }
}
