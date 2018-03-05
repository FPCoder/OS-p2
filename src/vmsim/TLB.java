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
	private static int ents = 8; // maximum number of entries in TLB
	private static TlbEntry[] cache = new TlbEntry[ents]; // the TLB contains 8 entries
	private int nextEntryPointer = 0;
    
    public int[] getPages() {
    	int[] ret = new int[ents];
    	
    	for (int i = 0; i < ents; ++i) {
    		ret[i] = cache[i].getVnum();
    	}
    	
    	return ret;
    }
    
    public static int size() { return ents; }
    
    /**
     * Given a virtual page number, check if it is in the TLB. 
     * Returns TlbEntry if hit, null if miss.
     * @throws EvictException 
     */
    public TlbEntry findInTLB(int vp_num) throws EvictException {
    	for(int i = 0 ; i < cache.length ; i++) {
    		if(cache[i].getVnum() == vp_num) {
    			return cache[i];
    		}
    	}
    	throw new EvictException("soft");
    	//return null;
    }
    
    public void add(int vpt_index , PageTableEntry entry) {
		cache[nextEntryPointer] = new TlbEntry(vpt_index , entry);
	}
    
    private void incrementNextEntryPointer() {
    	nextEntryPointer++;
    	if(nextEntryPointer >= cache.length) {
    		nextEntryPointer = 0;
    	}
    }

    public static void setDbit(int i, boolean b) {
    	if (i > ents || i < 0) { throw new IndexOutOfBoundsException(); }
    	cache[i].setDbit(b);
    }
    public static void setRbit(int i, boolean b) {
    	if (i > ents || i < 0) { throw new IndexOutOfBoundsException(); }
    	cache[i].setRbit(b);
    }
}
