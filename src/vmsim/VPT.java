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
    }
    
    public void setDbit(int i) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setDbit(true);
    }
    public void setRbit(int i) {
    	if (i > table.length || i < 0) { throw new IndexOutOfBoundsException(); }
    	table[i].setRbit(true);
    }
    
    public PageTableEntry getEntry(int i) {
    	return table[i];
    }
}
