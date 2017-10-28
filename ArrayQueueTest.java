public class ArrayQueueTest {
	
	public static void main(String[] args) { // rename to 'main' and run
		ArrayQueue queue = new ArrayQueue();
		
		String person1 = "person1";
		String person2 = "person2";
		String person3 = "person3";
		String person4 = "person4";
		
		queue.enqueue(person1);
		queue.enqueue(person2);
		queue.enqueue(person3);
		queue.enqueue(person4);
		
		System.out.println(queue.getFront()); // person1
		
		System.out.println(queue.dequeue()); // person1
		
		System.out.println(queue.getFront()); // person2
		
		System.out.println(queue.isEmpty()); // false
		
		queue.clear();
		
		System.out.println(queue.isEmpty()); // true
		
		queue.enqueue(person4);
		
		System.out.println(queue.getFront()); // person4
		
		// test when full
		for(int i = 0; i < 10; i++) {
			queue.enqueue(person1);
		}
		
	}
	
}
