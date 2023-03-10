import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListDequeTest {

    private DoublyLinkedListDeque DQue;

    @BeforeEach
    public void setUp() {
        DQue = new DoublyLinkedListDeque<>();
    }

    @Test
    public void appendTest() {
        DQue.append("AP");
        assertEquals("AP", DQue.first());
        assertEquals("AP", DQue.last());
        assertEquals(1, DQue.size());

        DQue.append("AP2");
        assertEquals("AP", DQue.first());
        assertEquals("AP2", DQue.last());
        assertEquals(2, DQue.size());

        DQue.append("AP3");
        assertEquals("AP", DQue.first());
        assertEquals("AP3", DQue.last());
        assertEquals(3, DQue.size());
    }

    @Test
    public void prependTest() {
        DQue.prepend("PR");
        assertEquals("PR", DQue.first());
        assertEquals("PR", DQue.last());
        assertEquals(1, DQue.size());

        DQue.prepend("PR2");
        assertEquals("PR2", DQue.first());
        assertEquals("PR", DQue.last());
        assertEquals(2, DQue.size());

        DQue.prepend("PR3");
        assertEquals("PR3", DQue.first());
        assertEquals("PR", DQue.last());
        assertEquals(3, DQue.size());
    }

    @Test
    public void deleteFirstTest() throws Exception {

        DQue.prepend("AP");
        DQue.deleteFirst();
        assertEquals(0, DQue.size());

        DQue.append("AP");
        DQue.prepend("AP2");
        DQue.deleteFirst();
        assertEquals(1, DQue.size());
        assertEquals("AP", DQue.first());
        assertEquals("AP", DQue.last());
    }

    @Test
    public void deleteLastTest() throws Exception {

        DQue.append("AP");
        DQue.deleteLast();
        assertEquals(0, DQue.size());

        DQue.append("AP");
        DQue.prepend("AP2");
        DQue.deleteLast();
        assertEquals(1, DQue.size());
        assertEquals("AP2", DQue.first());
        assertEquals("AP2", DQue.last());
    }

    @Test
    public void sizeTest() throws Exception {
        assertEquals(0, DQue.size());

        DQue.append("AP");
        DQue.prepend("PR");
        assertEquals(2, DQue.size());

        DQue.deleteFirst();
        assertEquals(1, DQue.size());

        DQue.deleteFirst();
        assertEquals(0, DQue.size());
    }
}