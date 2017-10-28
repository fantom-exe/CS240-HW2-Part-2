
/**
 * A class implementing a Queue using linked data
 */

public class LinkedQueue<T> implements QueueInterface<T> {
	// member variables
	private Node firstNode; // front of queue
	private Node lastNode; // back of queue
	
	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	}
	
	/** Adds a new entry to the back of this queue.
	 @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	}
	
	/** Removes and returns the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() {
		if(isEmpty())
			throw new EmptyQueueException();
		
		T front = getFront();
		
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		
		if(firstNode == null)
			lastNode = null;
		
		return front;
	}
	
	/**  Retrieves the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty. */
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		
		return firstNode.getData();
	}
	
	/** Detects whether this queue is empty.
	 @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return firstNode == null && lastNode == null;
	}
	
	/** Removes all entries from this queue. */
	public void clear() {
		firstNode = null;
		lastNode = null;
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
