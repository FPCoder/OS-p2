/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 *
 */
public class Driver {
	private static TLB tlb = new TLB();
	private static VPT vpt = new VPT();
	private static Memory mem = new Memory(); // TODO: set number of pages as param
	private static MMU mmu = new MMU(vpt, tlb);
	private static OS os = new OS(mmu, tlb, vpt, mem);
	private static CPU cpu = new CPU(mmu);
	
	private static String generateWorkingSet(String file_path) throws Exception {
		//TODO: copy the contents of the test_file to the working set for modification.
		File file = new File(file_path);
		if (!file.isFile()) {
			throw new Exception("Error: Invalid file location. Parameter must be a file, not a directory.");
		}

		int dot_index = file_path.lastIndexOf('.');
		String new_file_path = file_path.substring(0, dot_index) + "-ws" + file_path.substring(dot_index);
		File new_file = new File(new_file_path);
		Files.copy(file.toPath(), new_file.toPath());
		return new_file_path;
	}
	
	public static void run(String filePath) {
		cpu.readTestFile(filePath);
		
		//TODO
	}

	/**
		* @param args the command line arguments
		*/
	public static void main(String[] args) throws Exception {
		// Check that parameters are valid
		if (args.length == 1) {
			String working_set = generateWorkingSet(args[0]);
			run(working_set);
			outputHeader();
		} else {
			throw new Exception("Error: First argument must be test file path populated with virtual memory addresses.");
		}
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
		csv_rw = rw + "";
		output();
	}
	public static void outputValue (String value) {
		csv_value = value;
		output();
	}
	public static void outputSoft (boolean soft) {
		csv_soft = soft + "";
		output();
	}
	public static void outputHard (boolean hard) {
		csv_hard = hard + "";
		output();
	}
	public static void outputHit (boolean hit) {
		csv_hit = hit + "";
		output();
	}
	public static void outputEvictedPageNumber (int evicted_page_number) {
		csv_evicted_page_number = evicted_page_number + "";
		output();
	}
	public static void outputDirtyEvictedPage (int dirty_evicted_page) {
		csv_dirty_evicted_page = dirty_evicted_page + "";
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
