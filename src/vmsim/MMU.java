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
	
	/**
	 * Take the address given by a TestEntry, and return its index in the VPT.
	 * @param str address from test_file
	 * @return index in VPT
	 */
	private int indexVPT(String str) {
		//TODO
		return 0;
	}
	
	/**
	 * Take the address given by a TestEntry, and return its index in the TLB.
	 * @param str address from test_file
	 * @return index in TLB
	 */
	private int indexTLB(String str) {
		//TODO
		return 0;
	}
	
	/**
	 * A single function the CPU can call to fulfill the instructions of a single
	 * entry from a test_file.
	 * @param te the next TestEntry from file
	 */
	public void processEntry(TestEntry te) {
		if (te.getRW() == 0) {
			read(te);
		}
	}
    
	/**
	 * Find the contents of the given address and print the int to the console.
	 * Should trap to OS on soft/hard miss.
	 * @param te an individual TestEntry provided by the CPU
	 */
	public void read(TestEntry te) {
		setRbit(te.getAddr());
		//TODO
	}
	
	/**
	 * Change the contents of the file of the address given in TestEntry. Should trap
	 * to OS on soft/hard miss.
	 * @param te an individual TestEntry provided by the CPU
	 */
	public void write(TestEntry te) {
		setDbit(te.getAddr());
		// TODO: write value to memory
	}
}



