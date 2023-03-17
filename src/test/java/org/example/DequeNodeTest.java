package org.example;

import org.example.DequeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    DequeNode N1, N2, N3, N4;
    @Test
    void isNotATerminalNodeTestTrue(){
        N1 = new DequeNode<>(1, null, null);
        N2 = new DequeNode<>(2, N1, null);
        N1.setNext(N2);
        N3 = new DequeNode<>(3, N2, null);
        N2.setNext(N3);
        N4 = new DequeNode<>(4, N3, null);
        N3.setNext(N4);
        assertEquals(N2.isNotATerminalNode(), true);
        assertEquals(N3.isNotATerminalNode(), true);
    }
    @Test
    void isNotATerminalNodeFalseTest(){
        N2= new DequeNode(5, null,null);
        N3= new DequeNode(5, null,null);
        N1 = new DequeNode<>(1, null, N2);
        N4 = new DequeNode<>(4, N3, null);
        assertEquals(N1.isNotATerminalNode(), false);
        assertEquals(N4.isNotATerminalNode(), false);
        assertEquals(N3.isNotATerminalNode(), false);

    }



    @Test
    void IsLastNodeTest(){
        N1 = new DequeNode<>(1, null, N2);
        N2 = new DequeNode<>(2, N1, N1);
        N3 = new DequeNode<>(3, N2, null);
        assertEquals(N3.isLastNode(), true);
        assertEquals(N2.isLastNode(),false);
    }
    @Test
    void IsFirstNodeTest(){
        N1 = new DequeNode<>(1, null, N2);
        N2 = new DequeNode<>(2, N1, N3);
        N3 = new DequeNode<>(3, N2, null);
        assertEquals(N1.isFirstNode(), true);
    }

    @Test
    void SetItem(){
        N1 = new DequeNode<>(1, null, null);
        N1.setItem(5);
        assertEquals(N1.getItem(), 5);

        N2 = new DequeNode<>(2, null, null);
        N2.setItem(10);
        assertEquals(N2.getItem(), 10);

        N3 = new DequeNode<>(3, null, null);
        N3.setItem(15);
        assertEquals(N3.getItem(), 15);

        N4 = new DequeNode<>(4, null, null);
        N4.setItem(20);
        assertEquals(N4.getItem(), 20);
    }
}