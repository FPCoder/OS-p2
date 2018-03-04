/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 * Table entry for the TLB. Structure is very similar to PageTableEntry, so it extends
 * and adds vPageNum.
 * 
 * INST: The TLB will be a one-dimensional array of TlbEntries. A TlbEntry consists of a 
 * virtual page number and a frame number. The TLB is small and must be scanned on every 
 * lookup. The arrays used to implement the page table and TLB will be arrays of data 
 * structures that represent the tables entries.
 */
public class TlbEntry extends PageTableEntry {
    private int vPageNum; 
    
    public int getVnum() { return vPageNum; }
}
