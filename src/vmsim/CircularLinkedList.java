package vmsim;

/**
 * The OS requires using a CircularLinkedList to determine which page to evict,
 * and since we can't use default utilities, we have to make the class ourselves.
 * Adds new entries to the tail (head - 1).
 */
public class CircularLinkedList<T> {
	private final Object[] nodes;
	private int current_index = 0;
	
	CircularLinkedList (int items) {
		this.nodes = new Object[items];
	}

	public void add (T element) {
		this.nodes[this.current_index] = element;
	}

	public T current () {
		@SuppressWarnings("unchecked")		
		final T e = (T) this.nodes[this.current_index];
		return e;
	}

	public T next () {
		this.current_index++;
		this.current_index %= this.nodes.length;
		return this.current();
	}
}


