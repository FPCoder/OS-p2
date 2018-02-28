package vmsim;

public class TestEntry {
	private int readWrite;
	private String address;
	private int writeVal;
	
	TestEntry() {
		readWrite = -1;
		address = null;
		writeVal = -1;
	}
	
	TestEntry(int rw, String addr, int wval) {
		readWrite = rw;
		address = addr;
		writeVal = wval;
	}
	
	public void setRW(int rw) { readWrite = rw; }
	public void setAddr(String addr) { address = addr; }
	public void setWval(int wval) { writeVal = wval; }
	public int getRW() { return readWrite; }
	public String getAddr() { return address; }
	public int getWval() { return writeVal; }
}
