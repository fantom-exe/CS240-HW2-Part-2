
/**
 * A class implementing a Queue using fixed sized array
 */

public class ArrayQueue<T> implements QueueInterface<T> {
	// member variables
	private static final int MAX_CAPACITY = 10;
	private T[] queue;
	private int front; // front of queue
	private int back; // back of queue
	
//	private EmptyQueueException emptyQueueException = new EmptyQueueException(); // exception to throw of queue is empty
	
	public ArrayQueue() {
		checkCapacity();
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[MAX_CAPACITY - 1];
		queue = tempQueue;
		front = 0;
		back = MAX_CAPACITY;
	}
	
	/** Adds a new entry to the back of this queue.
	 @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		if(checkCapacity()) {
			back++;
			queue[back] = newEntry;
		}
		else System.out.println("Queue is full!");
	}
	
	/** Removes and returns the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		
		T frontEntry = queue[front];
		queue[front] = null;
		front++;
		
		return frontEntry;
	}
	
	/**  Retrieves the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		return queue[front];
	}
	
	/** Detects whether this queue is empty.
	 @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return front == ((back + 1) % queue.length);
	}
	
	/** Removes all entries from this queue. */
	public void clear() {
		while (!isEmpty()) {
			dequeue();
		}
	}
	
	/** Check if there is room to add onto queue.
	 @return  True if the queue has room to add. */
	private boolean checkCapacity() {
		return front == ((back + 2) % queue.length);
	}
	
}
