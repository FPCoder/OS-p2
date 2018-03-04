package vmsim;

public class EvictException extends Exception {
	private String type;
	EvictException(String str) { type = str; }
	
	public String getType() { return type; }
}
