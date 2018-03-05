/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 */
public class VPT {
    // 16bits(address width) - 8bits (page offset) = 8bits(addressable locations in VPT)
    private static PageTableEntry[] table;
    public final static int SIZE = 256;
    
    VPT() {
    	table = new PageTableEntry[SIZE];
    	for(PageTableEntry entry : table) {
    		entry = null;
    	}
    }
    
    /**
     * Given a virtual page number, check if it is in the VPT. 
     * Returns entry at vp_num index. 
     * If entry doesn't exist yet it will return null. 
     */
    public static PageTableEntry findInVPT(int vp_num) {
    	return table[vp_num];
    }
    
    public void addToVPT(int vp_index , PageTableEntry entry) {
    	if(vp_index < 0 || vp_index > table.length) {throw new IndexOutOfBoundsException();}
    	table[vp_index] = entry;
    }
    
    public static void setDbit(int i, boolean b) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setDbit(b);
    }
    public static void setRbit(int i, boolean b) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setRbit(b);
    }
    
    public static PageTableEntry getEntry(int i) {
    	return table[i];
    }
}
