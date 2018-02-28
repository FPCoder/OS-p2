/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 * @author ModernCyborg
 */
public class OS {
    /* INST. NOTES:
        the OS uses the clock algorithm for page replacement (must use circular 
        linked list)
        the OS resets the r-bit every 20 instuctions
    */
    
    OS() {
        
    }
    
    /**
     * 
     * @param page
     */
    private void evictPage(TlbEntry page) {
        
    }
    
    /**
     * 
     * @param page
     */
    public void load(TlbEntry page) {//TODO: is param correct data type?
        
    }
    
    /**
     * 
     * @param page
     */
    public void write(TlbEntry page) {
        
    }
    
    public void readTestFile(String fileName) {
        /* TODO
        the first value represents whether it is a read (0) or write (1), The 
        second value is the address to be read from or written to. If the action
        is a write (1) then there will be a third value which represents the 
        integer to be written to memory.
        */
    }
}
