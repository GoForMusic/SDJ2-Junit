package queue;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private QueueADT<String> q;

    @BeforeEach
    public void createQueue()
    {
        // arrange
        q = new BoundedArrayQueue(5);
    }


    @Test
    public void addedElementIsInQueue(){
        // act
        q.enqueue("A");
        // assert
        assertTrue(q.contains("A"));
    }

    @Test
    public void addMultipleElementsToQueue(){
        // act
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        // assert
        assertTrue(q.contains("A"));
        assertTrue(q.contains("B"));
        assertTrue(q.contains("C"));
        assertTrue(q.contains("D"));
    }

    @Test
    public void sizeIs4AfterAdding4Elements()
    {
        // act
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        // assert
        assertEquals(4,q.size());
    }

}