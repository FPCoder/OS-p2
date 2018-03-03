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
	//FIXME: is this the correct # of pages?
    private int numPages = 4; // INST. NOTES: address width is 12 bits
    private int[][] RAM;
    
    Memory() {
    	RAM = new int[numPages][1024];
    }
    
    /**
     * Initializes the cache with 'n' pages. Given page size is 1 KB or 1024 B.
     * @param n number of pages in cache
     */
    Memory(int n) {
        RAM = new int[n][1024];
    }
    
    public int[] getPage(int i) {
    	return RAM[i];
    }
    public void setPage(int[] i) {
    	
    }
}
