/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 */
public class MMU {
	// NOTE: MMU uses FIFO for replacement
	// TODO: implement replacement algorithm
	private VPT vpt = new VPT();
	private TLB tlb = new TLB();
	
	private void setDbit(String vp) {
		int i = -1;
		int j = -1;
		//TODO: convert vp to index in TLB and VPT
		vpt.setDbit(i);
		tlb.setDbit(j);
	}
	
	public void processEntry(TestEntry te) {
		if (te.getRW() == 0) {
			read(te);
		}
	}
    
	public void read(TestEntry te) {
		//TODO
	}
	
	/**
	 * 
	 * @param te an individual TestEntry provided by the CPU
	 */
	public void write(TestEntry te) {
		setDbit(te.getAddr());
		// TODO: write value to memory
	}
}



