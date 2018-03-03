package vmsim;

/**
 * The ... requires using a Cirluar Linked List to track ... and since we can't
 * use default utilities, we have to make the class ourselves.
 *
 */
public class CircularLinkedList {
	private int[] vpages;
	private int head = -1; // head is the 1st item in the list
	
	CircularLinkedList(TLB tlb) {
		vpages = tlb.getPages();
	}
	
	public void setPages(TLB tlb) {
		vpages = tlb.getPages();
	}
	
	/**
	 * Retrieve the next TLB in the list
	 * @return
	 */
	public Integer getNext() {
		if (head > vpages.length || head < 0) {
			return null;
		}
	}
	
	public void addPage(TLB tlb) {
		
	}
	
	public int getPage(int i) throws ArrayIndexOutOfBoundsException {
		if (i > vpages.length || i < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			return vpages[i];
		}
	}
}
