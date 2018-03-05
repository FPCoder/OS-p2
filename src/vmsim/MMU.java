/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmsim;

/**
 *
 */
public class MMU {
	private VPT vpt;
	private TLB tlb;
	
	public MMU(VPT v, TLB t) {
		vpt = v;
		tlb = t;
	}
	
	private static void setDbit(PageTableEntry vpt_entry , TlbEntry tlb_entry) {
		vpt_entry.setDbit(true);
		tlb_entry.setDbit(true);
	}
	private static void setRbit(PageTableEntry vpt_entry , TlbEntry tlb_entry) {
		vpt_entry.setRbit(true);
		tlb_entry.setRbit(true);
	}
	
	
	/**
	 * Find the contents of the given address and print the int to the console.
	 * Should trap to OS on soft/hard miss.
	 * @param te an individual TestEntry provided by the CPU
	 * @throws EvictException 
	 */
	public static void read(TestEntry te) throws EvictException {
		String physAdd = translateVMAToPMA(te.getAddr());
		

		
	}
	
	/**
	 * Change the contents of the file of the address given in TestEntry. Should trap
	 * to OS on soft/hard miss.
	 * @param te an individual TestEntry provided by the CPU
	 */
	public static void write(TestEntry te) {
		int i = physToVirt(te.getAddr());
		int offset = Integer.parseInt(te.getAddr().substring(2, 4) , 16);
		int[] page = Memory.getPage(i);
		page[offset] = te.getWval();
		Memory.setPage(i, page);
	}
	
	/**
	 * Translates virtual mem address (testEntry address string) to physical mem address
	 * Status: 0=hit ; 1=softMiss ; 2=hardMiss
	 * @throws EvictException 
	 */
	public static String translateVMAToPMA(String vm_address) throws EvictException {
		String offset = vm_address.substring(2, vm_address.length());
		int vp_index = Integer.parseInt(vm_address.substring(0, 2) , 16);
		int status = 0;
		
		PageTableEntry entry = TLB.findInTLB(vp_index);
		if(entry == null) {
			status++;
			entry = VPT.findInVPT(vp_index);
		}
		if(entry == null) {
			status++;
		}
		
		
		int frameNum = checkMiss(status , vp_index , entry);
		return Integer.toString(frameNum).concat(offset); 
	}
	
	private static int checkMiss(int status , int vp_index , PageTableEntry entry) throws EvictException {
		if( status == 0 ) {
			return hit(entry);
		}else if(status == 1) {
			return softMiss(vp_index);
		}
		hardMiss(entry);
		return -1; // impossible
	}
	
	private static void hardMiss(PageTableEntry pte) throws EvictException {
		Driver.outputHit(false);
		Driver.outputSoft(false);
		Driver.outputHard(true);
		
		throw new EvictException("hard", pte);
	}
	
	private static int softMiss(int vp_index) {
		Driver.outputHit(false);
		Driver.outputSoft(true);
		Driver.outputHard(false);
		TLB.add(vp_index , VPT.findInVPT(vp_index));
		return VPT.findInVPT(vp_index).getFrameNum();
	}
	
	private static int hit(PageTableEntry entry) {
		Driver.outputHit(true);
		Driver.outputSoft(false);
		Driver.outputHard(false);
		return entry.getFrameNum();
	}
	
	/*/**
	 * Take the address given by a TestEntry, and return its index in the VPT.
	 * @param str address from test_file
	 * @return index in VPT
	 
	public int indexVPT(String str) {
			TLB.add(vp_index , entry);
		}
	}*/
	
	public static int physToVirt(String vma) {
		//TODO
		return -1;
	}
	public static String virtToPhys(int phys) {
		
		return "";
	}
	
	/**
	 * A single function the CPU can call to fulfill the instructions of a single
	 * entry from a test_file.
	 * @param te the next TestEntry from file
	 * @throws EvictException 
	 */
	public static void processEntry(TestEntry te) throws EvictException {
		if (te.getRW() == 0) {
			try {
				read(te);
			} catch (EvictException e) {
				if (e.getType() == "hard") {
					throw e;
				}
				else if (e.getType() == "soft") {
					//softevict
				}
			}
		}
		else if (te.getRW() == 1) {
			write(te);
		}
	}
    
	
	
	/**
	 * 
	 * @param entry
	 * @return index in physical memory of evicted page
	 */
	public static int remove(PageTableEntry entry) {
		return -1; // TODO: implement
	}
}



