package vmsim;

/**
 * The OS requires using a CircularLinkedList to determine which page to evict,
 * and since we can't use default utilities, we have to make the class ourselves.
 * Adds new entries to the tail (head - 1).
 */
public class CircularLinkedList {
	private int[] vpages;
	private int head = -1; // head is the 1st item in the list
	private int tail = -1;
	private int n = 0; // number of valid entries
	
	CircularLinkedList() {
		vpages = new int[10];
	}
	
	public void addPage(TLB tlb) {
		//TODO:
	}
}


