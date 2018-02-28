package vmsim;

public class CircularLinkedList {
	private int[] vpages;
	
	CircularLinkedList(TLB tlb) {
		vpages = tlb.getPages();
	}
	
	public void setPages(TLB tlb) {
		vpages = tlb.getPages();
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
