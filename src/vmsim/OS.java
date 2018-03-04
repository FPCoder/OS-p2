/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 */
public class OS {
    /* INST. NOTES:
     * the OS uses the clock algorithm for page replacement (must use circular 
     * linked list)
     * the OS resets the r-bit every 20 instuctions
     */
	private CircularLinkedList clockList;
	private Clock c = new Clock();
	private int instCount; //current instruction number
	private MMU mmu;
	private TLB tlb;
	private VPT vpt;
	
	OS(MMU m, TLB t, VPT v) {
		mmu = m;
		tlb = t;
		vpt = v;
	}
    
	private void evict(PageTableEntry pte) {
		
	}
	public void read(PageTableEntry pte) {
		
	}
	public void write(PageTableEntry pte) {
		
	}
	
	/**
	 * Needs to select the correct page to evict based on the clock.
	 */
	public void clockReplace() {
		
	}
	
	public void advanceTime() {
		c.tick();
	}
	
	public void restRbits() {
		
	}
}



