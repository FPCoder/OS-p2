/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 * An entry for the Virtual Page Table.
 * 
 * INST: The page table will be an array of PageTableEntries (so the page table will be 
 * a one-dimensional array). You will use the virtual page number (V-Page#) as the index 
 * to the elements of this array.
 */
public class PageTableEntry{
    // INST. NOTE: the page offset is 8 bits
    private boolean vbit; // valid bit
    private boolean rbit; // referenced bit
    private boolean dbit; // dirty bit
    private int pageFrameNum; // address in memory
    
    public PageTableEntry(boolean v , boolean r , boolean d , int p) {
    	vbit = v;
    	rbit = r;
    	dbit = d;
    	pageFrameNum = p;
    }
    
    public boolean isDirty() { return dbit; }
    public boolean isReferenced() { return rbit; }
    public boolean isValid() { return vbit; }
    public int getFrameNum() { return pageFrameNum; }
    
    public void setVbit(boolean v) { vbit = v; }
    public void setDbit(boolean d) { dbit = d; }
    public void setRbit(boolean r) { rbit = r; }
    public void setFrameNum(int fnum) { pageFrameNum = fnum; }
}
