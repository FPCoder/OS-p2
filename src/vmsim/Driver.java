/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class Driver {
	private OS os = new OS();
	private CPU cpu = new CPU();
	private Memory mem = new Memory(); // TODO: set number of pages as param
	private MMU mmu = new MMU();
	private TLB tlb = new TLB();
	private VPT vpt = new VPT();
	
    public void readTestFile(String testPath) {
    	try {
        	File f = new File(testPath);
			Scanner sc = new Scanner(f);
			
			while (sc.hasNextInt()) { // while file has more to read
				mmu.processEntry(cpu.nextEntry(sc));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
	
	public void run(String filePath) {
		readTestFile(filePath);
		
		//TODO
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
