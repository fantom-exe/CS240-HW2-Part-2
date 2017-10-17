
/**
 * A class implementing a Queue using circular linked data
 */

public class CircularLinkedQueue<T> implements QueueInterface<T> {
	// member variables
//	private Node firstNode; // first node
//	private Node emptyNode; // back node
	
	private Node queueNode; // References first node in queue
	private Node freeNode;
	
	public CircularLinkedQueue() {
		freeNode = new Node(null, null);
		freeNode.setNextNode(freeNode);
		queueNode = freeNode;
	}
	
	/** Adds a new entry to the back of this queue.
	 @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		freeNode.setData(newEntry);
		
		if(isChainFull()) {
			Node newNode = new Node(null, freeNode.getNextNode());
			freeNode.setNextNode(newNode);
		}
		
		freeNode = freeNode.getNextNode();
	}
	
	/** Removes and returns the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException {
		if (isChainFull())
			throw new EmptyQueueException();
		
		T front = getFront();
		
		queueNode.setData(null);
		queueNode = queueNode.getNextNode();
		
		return front;
	}
	
	/**  Retrieves the entry at the front of this queue.
	 @return  The object at the front of the queue.
	 @throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		
		return queueNode.getData();
	}
	
	/** Detects whether this queue is empty.
	 @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return queueNode == freeNode;
	}
	
	/**  */
	private boolean isChainFull() {
		return queueNode == freeNode.getNextNode();
	}
	
	/** Removes all entries from this queue. */
	public void clear() {
		queueNode = null;
		freeNode = null;
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
		
		public void setData(T newData) {
			data = newData;
		}
		
		public Node getNextNode() {
			return next;
		}
		public void setNextNode(Node newNode) {
			next = newNode;
		}
		
	}
	
}
