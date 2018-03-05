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
    private static int size = 256;
    private static PageTableEntry[] table;
    
    VPT() {
    	table = new PageTableEntry[size];
    	for(PageTableEntry entry : table) {
    		entry = null;
    	}
    }
    
    /**
     * Given a virtual page number, check if it is in the VPT. 
     * Returns entry at vp_num index. 
     * If entry doesn't exist yet it will return null. 
     */
    public PageTableEntry findInVPT(int vp_num) {
    	return table[vp_num];
    }
    
    public static int size() { return size; }
    
    public static void setDbit(int i, boolean b) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setDbit(b);
    }
    public static void setRbit(int i, boolean b) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setRbit(b);
    }
    
    public PageTableEntry getEntry(int i) {
    	return table[i];
    }
}
