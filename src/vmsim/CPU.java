/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Finds the test_file containing the read/write entries, which is then passed to
 * the MMU to handle the entry. Entries either read and simply print, or write to
 * file.
 */
public class CPU {
	private int addrWidth = 16; // INST. NOTES: the cpu address width is 16 bits
	private MMU mmu; // points to the MMU, required as a paramter for init.
	
	/**
	 * No default is available, so the class must be declared by passing the
	 * instance of the MMU the computer is communicating with. Reasoning is the
	 * functions which interface the MMU with the CPU are described in terms of
	 * being completed by the CPU, but the MMU is not a component of the CPU class.
	 * @param m instance of the MMU (do not create new instance, pass existing object)
	 */
	CPU(MMU m) {
		mmu = m;
	}
    
    public TestEntry nextEntry(Scanner sc) {
    	int rw = -1; // read/write
    	String addr = null; // address referenced by a read/write entry
    	TestEntry ret = new TestEntry(); // Contains all fields of a read/write
    	
    	try {
	    	rw = sc.nextInt();
	    	addr = sc.nextLine();
	    	if (rw == 1) { // if write, get the value to write
	    		ret.setWval(sc.nextInt());
	    	}
    	}
    	// should only throw if a read/write has an invalid number of fields given
    	catch(NoSuchElementException e) {
    		System.out.println("Error in file reading: next field invalid");
    		e.printStackTrace();
    	}
    	
    	ret.setRW(rw);
    	ret.setAddr(addr);
    	
    	return ret;
    }

    /**
     * Given the string for the path to the testFile, read the entry and send to
     * the MMU for processing, until the end of the file.
     * @param testPath path to the testFile
     */
    public void readTestFile(String testPath) {
    	try {
        	File f = new File(testPath);
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextInt()) { // while file has more to read
				mmu.processEntry(nextEntry(sc));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}




