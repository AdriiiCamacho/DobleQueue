package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.DoublyLinkedListDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class DoublyLinkedListDequeTest {

    private DoublyLinkedListDeque DQue;

    @BeforeEach
    public void setUp() {
        DQue = new DoublyLinkedListDeque<>();
    }
    @Nested
    @DisplayName("Anadir")
    public class addingItemsTests {
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
    }

    @Nested
    @DisplayName("Borrar")
    public class deletingItems {
        @Test
        public void deleteFirstTest() throws Exception {
            assertThrows(DoubleEndedQueueException.class, () -> DQue.deleteFirst());
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
            assertThrows(DoubleEndedQueueException.class, () -> DQue.deleteLast());
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
    }@Nested
    @DisplayName("PruebasSegundaImplementacion")
    public class segundaImplementacionTests {
        @Nested
        @DisplayName("get")
        public class getTests {
            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when appending an item and calling get(0) then we should get us the item we appended ")
            public void getItemTest() {
                DQue.append("1");
                assertEquals("1", DQue.get(0));
            }
            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when trying to get an item then we will elevate an exception ")

            public void getItemTestEmptyList() {
                assertThrows(DoubleEndedQueueException.class, () -> DQue.get(0));
            }

            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few items and doing the get(x>0) item then we will get the item in that position ")
            @Test
            public void getItemTestWithMoreThan1Item() {
                DQue.append("1");
                DQue.append("2");
                assertEquals("2", DQue.get(1));
            }
        }


        @Nested
        @DisplayName("sort")
        public class sortTests {
            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a item and doing the sort function then it will give us the queue as it was ")
            public void sort1Item() {
                DQue.append(1);
                DQue.sort(Comparator.naturalOrder());
                assertEquals(1, DQue.get(0));

            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few ordered items and doing the sort function then it will give us the queue as it was, ordered ")
            public void sortOrdenado() {
                DQue.append(1);
                DQue.append(5);
                DQue.append(10);
                DQue.sort(Comparator.naturalOrder());
                assertArrayEquals(new int[]{1, 5, 10}, new int[]{(int) DQue.get(0), (int) DQue.get(1), (int) DQue.get(2)});
            }


            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few unordered items and doing the sort function then it will give us the queue ordered ")

            public void sortDesordenado() {
                DQue.append(10);
                DQue.append(5);
                DQue.append(1);
                DQue.sort(Comparator.naturalOrder());
                assertArrayEquals(new int[]{1, 5, 10}, new int[]{(int) DQue.get(0), (int) DQue.get(1), (int) DQue.get(2)});
            }
        }

        @Nested
        @DisplayName("contains")
        public class Contains {
            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few unordered items and doing the contains function with an already added item then it will give us true")
            public void containsTest() {
                DQue.append(1);
                DQue.append(2);
                DQue.append(3);
                assertTrue(DQue.contains(3));
            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few unordered items and doing the contains function with a non  added item then it will give us false")
            public void notContainsTest() {
                DQue.append(1);
                DQue.append(2);
                DQue.append(3);
                assertFalse(DQue.contains(4));
            }
        }

        @Nested
        @DisplayName("Borrar")
        public class removeTests {
            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when trying to remove an item  then it will elevate an exception")
            public void RemoveTestEmptyList() {
                assertThrows(DoubleEndedQueueException.class, () -> DQue.remove(0));
            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding an item and trying to remove it then the queue wont contain the item")
            public void RemoveTest1Item() throws Exception {
                DQue.append(1);
                DQue.remove(1);
                assertFalse(DQue.contains(1));
            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few  items and trying to remove and item then the queue wont contain the item")
            public void RemoveTestMoreThan1Item() throws Exception {
                DQue.append(1);
                DQue.append(2);
                DQue.append(3);
                DQue.remove(2);
                assertFalse(DQue.contains(2));
            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few  items and trying to remove the last item then the queue wont contain the item and the structure will be okay")
            public void RemoveTestLastItem() throws Exception {
                DQue.append(1);
                DQue.append(2);
                DQue.append(3);
                DQue.remove(3);
                assertFalse(DQue.contains(3));
            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few  items and trying to remove the first item then the queue wont contain the item and the structure will be okay")
            public void RemoveTestFirstItem() throws Exception {
                DQue.append(1);
                DQue.append(2);
                DQue.append(3);
                DQue.remove(1);
                assertFalse(DQue.contains(1));
            }

            @Test
            @DisplayName("Given a empty DoubleLinkedListDeque when adding a few  items and trying to remove a non added item then the queue wont remove nothing and the queue will be the same")

            public void RemoveTestNotFoundItem() throws Exception {
                DQue.append(1);
                DQue.append(2);
                DQue.append(3);
                DQue.remove(4);
                assertTrue(DQue.contains(3));
            }
        }
    }
}