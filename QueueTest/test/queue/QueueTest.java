package queue;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private QueueADT<String> q;

    //create a q before every test
    @BeforeEach
    public void createQueue()
    {
        // arrange
        q = new BoundedArrayQueue(5);
    }


    //pass the test if A exist in q
    @Test
    public void addedElementIsInQueue(){
        // act
        q.enqueue("A");
        // assert
        assertTrue(q.contains("A"));
    }

    //pass the test if ABCD exist in q
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

    //will pass the test if the q size is 4
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

    //expected to get an argument exception if the parameter is null
    @Test
    public void nullArgumentResultsInIllegalArgumentStateException(){
        //assert using lambda
        assertThrows(IllegalArgumentException.class,()-> q.enqueue(null));
    }

    //expected to get a state exception if we try to add a new elem when the size limit was exceeded.
    @Test
    public void fullQueueResultsInIllegalStateException(){
        // act
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");

        //assert using lambda
        assertThrows(IllegalStateException.class,()-> q.enqueue("whatever"));
    }

    //expected to not contain A in q
    @Test
    public void emptyQueueDoesntContainElementA(){
        //assert
        assertFalse(q.contains("A"));
    }
}