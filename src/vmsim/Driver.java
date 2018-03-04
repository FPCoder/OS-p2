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
    

	private static String csv_address;
	private static String csv_rw;
	private static String csv_value;
	private static String csv_soft;
	private static String csv_hard;
	private static String csv_hit;
	private static String csv_evicted_page_number;
	private static String csv_dirty_evicted_page;

	public static void outputAddress (String address) {
		csv_address = address;
		output();
	}
	public static void outputRW (int rw) {
		csv_rw = rw;
		output();
	}
	public static void outputValue (String value) {
		csv_value = value;
		output();
	}
	public static void outputSoft (boolean soft) {
		csv_soft = soft;
		output();
	}
	public static void outputHard (boolean hard) {
		csv_hard = hard;
		output();
	}
	public static void outputHit (boolean hit) {
		csv_hit = hit;
		output();
	}
	public static void outputEvictedPageNumber (int evicted_page_number) {
		csv_evicted_page_number = evicted_page_number;
		output();
	}
	public static void outputDirtyEvictedPage (int dirty_evicted_page) {
		csv_dirty_evicted_page = dirty_evicted_page;
		output();
	}
	private static void outputHeader () {
		System.out.println("Address, r/w, value, soft, hard, hit, evicted_pg#, dirty_evicted_page");
	}
	private static void output () {
		if (
			csv_address != null &&
			csv_rw != null &&
			csv_value != null &&
			csv_soft != null &&
			csv_hard != null &&
			csv_hit != null &&
			csv_evicted_page_number != null &&
			csv_dirty_evicted_page != null
		) {
			System.out.printf("%7s, %3s, %5s, %4s, %4s, %3s, %11s, %18s", csv_address, csv_rw, csv_value, csv_soft, csv_hard, csv_hit, csv_evicted_page_number, csv_dirty_evicted_page);
			csv_address = null;
			csv_rw = null;
			csv_value = null;
			csv_soft = null;
			csv_hard = null;
			csv_hit = null;
			csv_evicted_page_number = null;
			csv_dirty_evicted_page = null;
		}
	}

}
