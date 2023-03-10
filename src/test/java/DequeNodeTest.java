import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    DequeNode N1, N2, N3, N4;
    @Test
    void isNotATerminalNodeTestTrue(){
        N1 = new DequeNode<>(1, null, N2);
        N2 = new DequeNode<>(2, N1, N3);
        N3 = new DequeNode<>(3, N2, N4);
        N4 = new DequeNode<>(4, N3, null);
        assertEquals(N2.isNotATerminalNode(), true);
        assertEquals(N2.isNotATerminalNode(), true);
    }
    @Test
    void isNotATerminalNodeFalseTest(){
        N1 = new DequeNode<>(1, null, N2);
        N4 = new DequeNode<>(4, N3, null);
        assertEquals(N1.isNotATerminalNode(), false);
        assertEquals(N4.isNotATerminalNode(), false);
    }

    @Test
    void IsLastNodeTest(){
        N1 = new DequeNode<>(1, null, N2);
        N2 = new DequeNode<>(2, N1, N3);
        N3 = new DequeNode<>(3, N2, null);
        assertEquals(N3.isLastNode(), true);
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