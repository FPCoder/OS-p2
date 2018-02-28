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
	private VPT vpt;
	private TLB tlb;
	
	MMU(VPT v, TLB t) {
		vpt = v;
		tlb = t;
	}
	
	private void setDbit(String vp) {
		//TODO: convert vp to index in TLB and VPT
		vpt.setDbit(indexVPT(vp));
		tlb.setDbit(indexTLB(vp));
	}
	private void setRbit(String vp) {
		//TODO
		vpt.setRbit(indexVPT(vp));
		tlb.setRbit(indexTLB(vp));
	}
	private int indexVPT(String str) {
		//TODO
	}
	private int indexTLB(String str) {
		//TODO
	}
	
	public void processEntry(TestEntry te) {
		if (te.getRW() == 0) {
			read(te);
		}
	}
    
	public void read(TestEntry te) {
		setRbit(te.getAddr());
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



