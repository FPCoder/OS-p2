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
	private static int nextReset; //instruction number for resetting r-bits
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
	
	private static PageTableEntry nextEvict() {
		//TODO
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
		if (!pte.isDirty()) {
			return; // do nothing if file not updated
		}
		else {
			int[] page = Memory.getPage(pte);
			int i = -1;
			//TODO
			pte.setDbit(true);
		}
	}
	
	/**
	 * Needs to select the correct page to evict based on the clock.
	 */
	public static void clockReplace() {
		
	}
	
	public static void advanceTime() {
		c.tick();
		if (instCount >= nextReset) {
			resetRbits();
			nextReset += 20;
		}
	}
	
	public static void resetRbits() {
		for (int i = 0; i < TLB.size(); ++i) {
			TLB.setRbit(i, false);
		}
		for (int i = 0; i < VPT.size(); ++i) {
			VPT.setRbit(i, false);
		}
	}
	
	public static void main(String[] args) {
        
    }
}



