import java.util.NoSuchElementException;

/**
 * A class implementing a Queue using fixed sized array
 */

public class ArrayQueue<T> implements QueueInterface<T> {
	// member variables
	private T[] queue;
	private static final int MAX_CAPACITY = 10;
	private int front; // front of queue
	private int back; // back of queue
	
	private EmptyQueueException emptyQueueException = new EmptyQueueException(); // exception to throw of queue is empty
	
	public ArrayQueue() {
		checkCapacity();
		
		
	}
	
	/** Adds a new entry to the back of this queue.
	 @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
	
	}
	
	/** Removes and returns the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException {
	
	}
	
	/**  Retrieves the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException {
	
	}
	
	/** Detects whether this queue is empty.
	 @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
	
	}
	
	/** Removes all entries from this queue. */
	public void clear() {
	
	}
	
	/** Detects whether this queue is empty.
	 @return  True if the queue is empty. */
	public boolean isEmpty() {
		return (top < 0);
	}
	
	/** Check if there is room to add onto queue.
	 @return  True if the queue has room to add. */
	private boolean checkCapacity() {
		return (MAX_CAPACITY - top > 0);
	}
	
}
