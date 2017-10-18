
/**
 * A class implementing a Queue using circular linked data
 */

public class CircularLinkedQueue<T> implements QueueInterface<T> {
	// member variables
	private Node back; // References last node in queue
	private Node free;
	private final int MAX_SIZE = 10;
	private int size;
	
	public CircularLinkedQueue() {
		free = new Node(null, null);
		free.setNextNode(free);
		back = free;
		size = 0;
	}
	
	/** Adds a new entry to the back of this queue.
	 @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		free.setData(newEntry);
		
		if(isChainFull()) {
			Node newNode = new Node(null, free.getNextNode());
			free.setNextNode(newNode);
		}
		
		free = free.getNextNode();
		size++;
	}
	
	/** Removes and returns the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		
		T front = getFront();
		
		back.setData(null);
		
		size--;
		return front;
	}
	
	/**  Retrieves the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		
		return back.getData();
	}
	
	/** Detects whether this queue is empty.
	 @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return back == free;
	}
	
	/** Returns true when chain is full */
	private boolean isChainFull() {
		return (back == free.getNextNode()) || !(size <= MAX_SIZE);
	}
	
	/** Removes all entries from this queue. */
	public void clear() {
		while (!isEmpty()) {
			back.setData(null);
			free = back;
			back = free.getNextNode();
		}
		
		size = 0;
	}
	
	/** Node class */
	private class Node {
		private T data;
		private Node next; // next node
		
		Node(T newEntry, Node next) {
			this.data = newEntry;
			this.next = next;
		}
		
		T getData() {
			return data;
		}
		
		void setData(T newData) {
			data = newData;
		}
		
		Node getNextNode() {
			return next;
		}
		void setNextNode(Node newNode) {
			next = newNode;
		}
		
	}
	
}
