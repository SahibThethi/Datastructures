package mylib;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.linear.DLL;
import mylib.datastructures.nodes.DNode;

public class DLLtest {
        
    @Test
    public void testInsertHead() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        assertEquals(3, list.getLength());
        assertFalse(list.isSorted());
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertNull(node3.getPrev());
        assertEquals(node2, node3.getNext());
        assertEquals(node3, node2.getPrev());
        assertEquals(node1, node2.getNext());
        assertEquals(node2, node1.getPrev());
        assertNull(node1.getNext());
    }
    
    @Test
    public void testInsertTail() {
         // Create a new linked list
         DLL list = new DLL();

         // Insert a new node at the tail
         DNode node1 = new DNode(1);
         list.insertTail(node1);
 
         // Test that the head and tail are set to the inserted node
         assertEquals(node1, list.getHead());
         assertEquals(node1, list.getTail());
         assertEquals(1, list.getSize());
 
         // Insert another node at the tail
         DNode node2 = new DNode(2);
         list.insertTail(node2);
 
         // Test that the tail is set to the inserted node
         assertEquals(node2, list.getTail());
         assertEquals(2, list.getSize());
 
         // Test that the nodes are linked correctly
         assertEquals(node1, node2.getPrev());
         assertEquals(node2, node1.getNext());
    }
    
    @Test
    public void testInsert() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        
        // Test inserting at position 1
        list.insert(node1, 1);
        assertEquals(1, list.getHead().getData());
        assertEquals(1, list.getTail().getData());
        assertEquals(1, list.getSize());
        
        // Test inserting at position size+1
        list.insert(node3, 2);
        assertEquals(3, list.getTail().getData());
        assertEquals(2, list.getSize());
        
        // Test inserting at a middle position
        list.insert(node2, 2);
        assertEquals(1, list.getHead().getData());
        assertEquals(3, list.getTail().getData());
        assertEquals(3, list.getSize());
        
        // Test inserting at an invalid position
        list.insert(new DNode(4), 5);
        assertEquals(3, list.getTail().getData());
        assertEquals(3, list.getSize());
    }
    
    @Test
    public void testSortedInsert() {
        // create a sorted doubly linked list with some initial values
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(3));
        list.insertTail(new DNode(5));
        
        // insert a new node with value 4
        list.sortedInsert(new DNode(4));
        
        // check that the new node is inserted in the correct position
        assertEquals(4, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(5, list.getTail().getData());
        assertEquals(3, list.getHead().getNext().getData());
        assertEquals(4, list.getHead().getNext().getNext().getData());
        assertEquals(5, list.getHead().getNext().getNext().getNext().getData());
    }
    
    @Test
    public void testSearch() {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        assertEquals(null, list.search(4));
        assertEquals(new DNode(2).getData(), list.search(2).getData());
    }
    
    @Test
    public void testDeleteHead() {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        list.deleteHead();
        assertEquals(2, list.getLength());
    }
    
    @Test
    public void testDeleteTail() {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        list.deleteTail();
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().data);
        assertEquals(2, list.getTail().data);
    }
    
    @Test
    public void testDelete() {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        list.delete(list.search(2));
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().data);
        assertEquals(3, list.getTail().data);
    }
    
    @Test
    public void testClear() {
        DLL list = new DLL();
        list.insertHead(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        list.clear();
        assertEquals(0, list.getLength());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }
    @Test
    public void testSort() {
        DLL list = new DLL();
        list.insertHead(new DNode(3));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(1));
        list.sort();
        assertEquals(3, list.getLength());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().getNext().getData());
        assertEquals(3, list.getTail().getData());
    }

    @Test
    public void testPrint() {
        DLL list = new DLL();
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
    public void testEmptyList() {
        DLL list = new DLL();
        assertEquals(null, list.getHead());
        list.print(); // should print "List is empty"
    }
    // Test the print method on an empty list
    @Test
    public void testPrintEmptyList() {
        DLL list = new DLL();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 0\n" +
        "Sorted status: true\n" +
        "List content:";
        String[] expectedLines = expectedOutput.split("\n");

        String actualOutput = outContent.toString();
        String[] actualLines = actualOutput.split("\n");

        for (int i = 0; i < expectedLines.length; i++) {
        assertEquals(expectedLines[i], actualLines[i].trim());
        }
    }

    private DLL emptyList;
    private DLL singleItemList;
    private DLL unsortedList;
    private DLL sortedList;
    
    @Before
    public void setUp() {
        // Empty list
        emptyList = new DLL();
        
        // Single-item list
        DNode singleNode = new DNode(5);
        singleItemList = new DLL(singleNode);
        
        // Unsorted list
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(1);
        DNode node3 = new DNode(8);
        DNode node4 = new DNode(3);
        unsortedList = new DLL();
        unsortedList.insertTail(node1);
        unsortedList.insertTail(node2);
        unsortedList.insertTail(node3);
        unsortedList.insertTail(node4);
        
        // Sorted list
        DNode sortedNode1 = new DNode(1);
        DNode sortedNode2 = new DNode(3);
        DNode sortedNode3 = new DNode(5);
        DNode sortedNode4 = new DNode(8);
        sortedList = new DLL();
        sortedList.insertTail(sortedNode1);
        sortedList.insertTail(sortedNode2);
        sortedList.insertTail(sortedNode3);
        sortedList.insertTail(sortedNode4);
    }
    
    @Test
    public void testConstructor() {
        assertEquals(emptyList.getLength(), 0);
        assertEquals(singleItemList.getLength(), 1);
        assertEquals(unsortedList.getLength(), 4);
        assertEquals(sortedList.getLength(), 4);
    }
    
    @Test
    public void testSortMethodOnSorted() {
        // Test sort method on already sorted list
        sortedList.sort();
        assertTrue(sortedList.isSorted());
    }
    
    @Test
    public void testPrintOnUnsorted() {
        // Test print method on unsorted list
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        unsortedList.print();
        String expectedOutput = "List length: 4\n" +
        "Sorted status: false\n" +
        "List content: 5 1 8 3\n";
        String[] expectedLines = expectedOutput.split("\n");

        String actualOutput = outContent.toString();
        String[] actualLines = actualOutput.split("\n");

        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], actualLines[i].trim());
        }
    }
    
    @Test
    public void testIsSortedOnSorted() {
        // Test isSorted method on sorted list
        assertTrue(sortedList.isSorted());
    }
    
    @Test
    public void testIsSortedOnUnsorted() {
        // Test isSorted method on unsorted list
        assertFalse(unsortedList.isSorted());
    }
}