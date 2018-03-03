/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 */
public class TLB {
	private int ents = 8; // maximum number of entries in TLB
	private TlbEntry[] cache = new TlbEntry[ents]; // the TLB contains 8 entries
    
    public int[] getPages() {
    	int[] ret = new int[ents];
    	
    	for (int i = 0; i < ents; ++i) {
    		ret[i] = cache[i].getPageNum();
    	}
    	
    	return ret;
    }

    public void setDbit(int i) {
    	if (i > ents || i < 0) { throw new IndexOutOfBoundsException(); }
    	cache[i].setDbit(true);
    }
    public void setRbit(int i) {
    	if (i > ents || i < 0) { throw new IndexOutOfBoundsException(); }
    	cache[i].setRbit(true);
    }
}
