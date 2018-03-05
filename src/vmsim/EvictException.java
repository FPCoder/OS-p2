package vmsim;

public class EvictException extends Exception {
	private String type;
	private PageTableEntry pte;

	EvictException (String str) {
		type = str;
	}

	EvictException(String str, PageTableEntry pte) { 
		type = str; 
		this.pte = pte;
	}
	
	public String getType() { return type; }
}
