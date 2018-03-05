/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class OS {
    /* INST. NOTES:
     * the OS uses the clock algorithm for page replacement (must use circular 
     * linked list)
     * the OS resets the r-bit every 5 instuctions
     */
	private static CircularLinkedList clockList;
	private static Clock c = new Clock();
	private static int instCount; //current instruction number
	private static MMU mmu;
	private static TLB tlb;
	private static VPT vpt;
	private static Memory mem;
	
	OS(MMU m, TLB t, VPT v, Memory me) {
		mmu = m;
		tlb = t;
		vpt = v;
		mem = me;
	}
	
	// Implements the Clock Replacement Algorithm
	private static PageTableEntry nextEvict() {
		// Try to find an entry in the clock who is not referenced
		for (int i = 0; i < 5; i++) {
			if (!clockList.current().isReferenced()) {
				return clockList.current();
			} else {
				clockList.current().setRbit(false);
				clockList.next();
			}
		}
		// If all five entries are referenced, return the next one regardless
		return clockList.current();
	}
    
	/**
	 * 
	 * @return index in memory of evicted page
	 */
	public static int evict() {
		//TODO: evict page based on eviction algorithm
		PageTableEntry e = nextEvict();
		
		if (e.isDirty()) {
			write(e);
		}
		Memory.remove(e);
		MMU.remove(e);
		return -1;
	}

	public static void load(TestEntry te) throws FileNotFoundException {
		String fileAddr = te.getAddr().substring(0, 2);
		FileInputStream fis = new FileInputStream(fileAddr);
		Scanner sc = new Scanner(fis);
		int[] page = new int[256]; // page being loaded in
		int i = -1; // index to load to
		/*int offset = Integer.parseInt(te.getAddr().trim(), 16); // convert hex address to dec offset
		
		if (te.getRW() == 0) { // is read
			Driver.outputValue(Integer.toString(page[offset])); //add requested value to output line
		}
		else if (te.getRW() == 1) {
			Driver.outputValue(Integer.toString(page[offset])); //add requested value to output line
			
		}*/
		
		i = evict();
		for (int j = 0; j < 256; ++i) {
			page[j] = sc.nextInt();
		}
		Memory.setPage(i, page);
		
	}
	public static void write(PageTableEntry pte) {
		
	}
	
	/**
	 * Needs to select the correct page to evict based on the clock.
	 */
	public static void clockReplace() {
		
	}
	
	public static void advanceTime() {
		c.tick();
	}
	
	public static void restRbits() {
		
	}
	
	public static void main(String[] args) {
        
    }
}



