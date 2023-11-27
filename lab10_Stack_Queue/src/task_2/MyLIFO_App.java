package task_2;

import java.util.LinkedList;
import java.util.Queue;

public class MyLIFO_App {
	public static void main(String[] args) {
		// Example usage
		Queue<Integer> queue1 = new LinkedList<>();
		queue1.add(1);
		queue1.add(2);
		queue1.add(3);

		System.out.println("Before stutter: " + queue1);
		stutter(queue1);
		System.out.println("After stutter: " + queue1);

		Queue<String> queue2 = new LinkedList<>();
		queue2.add("a");
		queue2.add("b");
		queue2.add("c");

		System.out.println("Before mirror: " + queue2);
		mirror(queue2);
		System.out.println("After mirror: " + queue2);
	}

	// method stutter that accepts a queue of integers as a parameter
	// and replaces every element of the queue with two copies of that element
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			input.offer(element);
			input.offer(element);
		}
	}

	// Method mirror that accepts a queue of strings as a parameter
	// and appends the queue's contents to itself in reverse order
	public static <E> void mirror(Queue<E> input) {
		int size = input.size();
		// Create a temporary queue to store the reversed elements
		Queue<E> tempQueue = new LinkedList<>();

		// Reverse the elements and add them to the temporary queue
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			tempQueue.offer(element);
			input.offer(element);
		}

		// Add the reversed elements back to the original queue
		while (!tempQueue.isEmpty()) {
			input.offer(tempQueue.poll());
		}
	}

}
