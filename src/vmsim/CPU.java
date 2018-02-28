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
 *
 */
public class CPU {
    // INST. NOTES: the cpu address width is 16 bits
	private int addrWidth = 16;
	private MMU mmu;
	
	CPU(MMU m) {
		mmu = m;
	}
    
    public TestEntry nextEntry(Scanner sc) {
    	int rw = -1; // read/write
    	String addr = null;
    	TestEntry ret = new TestEntry();
    	
    	try {
	    	rw = sc.nextInt();
	    	addr = sc.nextLine();
	    	if (rw == 1) { // if write, read the writeValue
	    		ret.setWval(sc.nextInt());
	    	}
    	}
    	catch(NoSuchElementException e) {
    		System.out.println("Error in file reading: next field invalid");
    		e.printStackTrace();
    	}
    	
    	ret.setRW(rw);
    	ret.setAddr(addr);
    	
    	return ret;
    }

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
