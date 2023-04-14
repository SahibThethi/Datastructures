package main.java.mylib.test;
import main.java.mylib.datastructures.nodes.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class DNodetest {
    @Test
    public void testConstructorWithData() {
        DNode node = new DNode(5);
        assertEquals(5, node.getData());
        assertNull(node.getPrev());
        assertNull(node.getNext());
    }

    @Test
    public void testGetData() {
        DNode node = new DNode(5);
        assertEquals(5, node.getData());
    }

    @Test
    public void testGetPrev() {
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        node1.setPrev(node2);
        assertEquals(node2, node1.getPrev());
    }

    @Test
    public void testGetNext() {
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }

    @Test
    public void testSetData() {
        DNode node = new DNode(5);
        node.setData(10);
        assertEquals(10, node.getData());
    }

    @Test
    public void testSetPrev() {
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node3.setPrev(node2);
        node2.setPrev(node1);
        assertEquals(node2, node3.getPrev());
    }

    @Test
    public void testSetNext() {
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(15);
        node1.setNext(node2);
        node2.setNext(node3);
        assertEquals(node3, node2.getNext());
    }

    @Test
    public void testSetPrevNull() {
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        node1.setPrev(node2);
        node1.setPrev(null);
        assertNull(node1.getPrev());
    }

    @Test
    public void testSetNextNull() {
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(10);
        node1.setNext(node2);
        node1.setNext(null);
        assertNull(node1.getNext());
    }
    
}
