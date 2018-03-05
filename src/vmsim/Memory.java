/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 * The TLB and VPT reference pages stored here. Interfacing should be very simple,
 * only set and get. Other objects should do more complex calculations.
 * 
 * INST: Physical memory will be a two-dimensional array to simulate the page-frame # and 
 * the page of byte-addressable, byte-sized data. For instance, if physical memory can 
 * hold 16 pages of data and each page is 1kB, then you would have a 2d array like: 
 * ram[16][1024]. Read further to determine what values you must use in your simulator. 
 * In each byte of ram you will store an integer value (yes, an int is typically larger 
 * than a byte but this will make the project simpler).
 */
public class Memory {
	// 12bits (address width) - 8bits (page offset) = 4bits (page address width)
    private static int numPages = 16; // INST. NOTES: address width is 12 bits
    private static int pageSize = 256;
    private static int[][] ram;
    
    Memory() {
    	ram = new int[numPages][pageSize];
    }
    
    /*public static int[] getPage(PageTableEntry pte) {
		// convert hex address to dec offset
		return ram[parseIndex(pte)];
    }*/
    
    /*public static int parseIndex(PageTableEntry pte) {
    	return Integer.parseInt(pte.getFrameNum().trim().substring(0, 1), 16);
    }*/
    
    public static int[] getPage(int i) {
    	return ram[i];
    }
    public static int[] setPage(int i, int[] pg) {
    	int[] ret = ram[i];
    	ram[i] = pg;
    	return ret;
    }
    
    /*public static void remove(PageTableEntry pte) {
    	ram[parseIndex(pte)] = null;
    }*/
}



