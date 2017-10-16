import java.util.EmptyStackException;

/**
 * A class implementing a Queue using linked data
 */

public class LinkedQueue<T> implements QueueInterface<T> {
	// member variables
	private static final int MAX_CAPACITY = 10; // default size of stack
	private T[] stack; // actual stack that will be created
	private int top; // top of the stack
	
	private EmptyStackException emptyStackException = new EmptyStackException(); // exception to throw of stack is empty
	
}
