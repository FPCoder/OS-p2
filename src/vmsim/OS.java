/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 */
public class OS {
    /* INST. NOTES:
     * the OS uses the clock algorithm for page replacement (must use circular linked list)
     * the OS resets the r-bit every 5 instructions
     */
	private static CircularLinkedList<PageTableEntry> clockList = new CircularLinkedList<PageTableEntry>(256);
	private static Clock c = new Clock();
	private static int instCount; //current instruction number
	private static int nextReset; //instruction number for resetting r-bits
	private static int resetFreq = 5;
	
	// Implements the Clock Replacement Algorithm
	private static PageTableEntry nextEvict() {
		// Try to find an entry in the clock who is not referenced
		for (int i = 0; i < clockList.numNodes(); i++) {
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
	 * Evict an entry based on the Clock Eviction method.
	 * @return index in memory of evicted page
	 * @throws FileNotFoundException 
	 */
	public static int evict() throws FileNotFoundException {
		PageTableEntry e = nextEvict();
		
		if (e.isDirty()) {
			write(e);
		}
		return MMU.remove(e);
	}

	public static void load(String addr) throws FileNotFoundException {
		String fileAddr = addr.substring(0, 2);
		FileInputStream fis = new FileInputStream(fileAddr + ".pg");
		Scanner sc = new Scanner(fis);
		int[] page = new int[256]; // page being loaded in
		int i = -1; // index to load to
		
		i = evict();
		for (int j = 0; j < VPT.SIZE; ++i) {
			page[j] = sc.nextInt();
		}
		Memory.setPage(i, page);
		
		sc.close();
	}
	public static void write(PageTableEntry pte) throws FileNotFoundException {
		if (!pte.isDirty()) {
			return; // do nothing if file not updated
		}
		else {
			int[] page = Memory.getPage(pte);
			String fileName = MMU.virtToPhys(pte.getFrameNum());
			FileOutputStream fos = new FileOutputStream(fileName + ".pg");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			try {
				for (int i = 0; i < VPT.SIZE; i++) {
					bw.newLine();
					bw.write(page[i]);
				}
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pte.setDbit(false); // reset d-bit because contents are now consistent with hard-disk
		}
	}
	
	public static void advanceTime() {
		c.tick();
		if (instCount >= nextReset) {
			resetRbits();
			nextReset += resetFreq;
		}
	}
	
	public static void resetRbits() {
		for (int i = 0; i < TLB.SIZE; ++i) {
			TLB.setRbit(i, false);
		}
		for (int i = 0; i < VPT.SIZE; ++i) {
			VPT.setRbit(i, false);
		}
	}
	
	public static void hardmiss(PageTableEntry pte) {
		try {
			if (pte.isDirty()) {
				write(pte);
			}
			evict();
			load(MMU.virtToPhys(pte.getFrameNum()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        try {
			OS.write(new PageTableEntry(false, false, false, 0));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("fin");
    }
}



