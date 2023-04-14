package main.java.mylib.test;
import main.java.mylib.datastructures.nodes.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SNodetest {

    @Test
    public void testConstructorWithData() {
        SNode node = new SNode(10);
        assertEquals(10, node.getData());
        assertNull(node.getNext());
    }

    @Test
    public void testConstructorWithNextNode() {
        SNode node1 = new SNode(10);
        SNode node2 = new SNode(20);
        node2.setNext(node1);
        assertEquals(20, node2.getData());
        assertEquals(node1, node2.getNext());
    }

    @Test
    public void testGetData() {
        SNode node = new SNode(5);
        assertEquals(5, node.getData());
    }

    @Test
    public void testSetData() {
        SNode node = new SNode(5);
        node.setData(10);
        assertEquals(10, node.getData());
    }

    @Test
    public void testGetNext() {
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }

    @Test
    public void testSetNext() {
        SNode node1 = new SNode(5);
        SNode node2 = new SNode(10);
        node1.setNext(node2);
        assertEquals(node2, node1.getNext());
    }
}

