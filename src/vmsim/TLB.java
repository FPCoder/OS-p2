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
	public final static int SIZE = 8; // maximum number of entries in TLB
	private static TlbEntry[] cache = new TlbEntry[SIZE]; // the TLB contains 8 entries
	private static int nextEntryPointer = 0;
    
    public static int[] getPages() {
    	int[] ret = new int[SIZE];
    	
    	for (int i = 0; i < SIZE; ++i) {
    		ret[i] = cache[i].getVnum();
    	}
    	
    	return ret;
    }
    
    /**
     * Given a virtual page number, check if it is in the TLB. 
     * Returns TlbEntry if hit, null if miss.
     * @throws EvictException 
     */
    public static TlbEntry findInTLB(int vp_num) throws EvictException {
    	for(int i = 0 ; i < cache.length ; i++) {
    		if(cache[i].getVnum() == vp_num) {
    			return cache[i];
    		}
    	}
    	throw new EvictException("soft");
    	//return null;
    }
    
    public static void add(int vpt_index , PageTableEntry entry) {
		cache[nextEntryPointer] = new TlbEntry(vpt_index , entry);
	}
    
    private static void incrementNextEntryPointer() {
    	nextEntryPointer++;
    	if(nextEntryPointer >= cache.length) {
    		nextEntryPointer = 0;
    	}
    }

    public static void setDbit(int i, boolean b) {
    	if (i > SIZE || i < 0) { throw new IndexOutOfBoundsException(); }
    	cache[i].setDbit(b);
    }
    public static void setRbit(int i, boolean b) {
    	if (i > SIZE || i < 0) { throw new IndexOutOfBoundsException(); }
    	cache[i].setRbit(b);
    }
}
