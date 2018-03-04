/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 */
public class OS {
    /* INST. NOTES:
     * the OS uses the clock algorithm for page replacement (must use circular 
     * linked list)
     * the OS resets the r-bit every 5 instuctions
     */
	private CircularLinkedList clockList;
	private Clock c = new Clock();
	private int instCount; //current instruction number
	private MMU mmu;
	private TLB tlb;
	private VPT vpt;
	private Memory ram;
	
	OS(MMU m, TLB t, VPT v, Memory mem) {
		mmu = m;
		tlb = t;
		vpt = v;
		ram = mem;
	}
    
	public void evict() {
		//TODO: evict page based on eviction algorithm
	}
	public void load(String addr) {
		
	}
	public void write(String addr, int val) {
		
	}
	
	/**
	 * Needs to select the correct page to evict based on the clock.
	 */
	public void clockReplace() {
		
	}
	
	public void advanceTime() {
		c.tick();
	}
	
	public void restRbits() {
		
	}
	
	public static void main(String[] args) {
        
    }
}



