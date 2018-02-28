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
 * @author ModernCyborg
 */
public class CPU {
    private MMU mmu;
    private TLB tlb;
    
    private void nextEntry(Scanner sc) {
    	int rw = 0; // read/write
    	
    	try {
	    	rw = sc.nextInt();
	    	if (rw == 0) { // if read
	    		mmu.read(sc.nextLine());
	    	}
	    	else if (rw == 1) { // if write
	    		mmu.write(sc.nextLine(), sc.nextInt());
	    	}
	    	else {
	    		
	    	}
    	}
    	catch(NoSuchElementException e) {
    		System.out.println("Error in file reading: next field invalid");
    		e.printStackTrace();
    	}
    }
    
    public void readTestFile(String testPath) {
    	try {
        	File f = new File(testPath);
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextInt()) { // while file has more to read
				nextEntry(sc);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    
}
