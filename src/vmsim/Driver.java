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
	private TLB tlb = new TLB();
	private VPT vpt = new VPT();
	private OS os = new OS();
	private Memory mem = new Memory(); // TODO: set number of pages as param
	private MMU mmu = new MMU(vpt, tlb);
	private CPU cpu = new CPU(mmu);
	
	private void generateWorkingSet() {
		//TODO: copy the contents of the test_file to the working set for modification.
	}
	
	public void run(String filePath) {
		cpu.readTestFile(filePath);
		
		//TODO
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
