package vmsim;

public class Clock {
	private int time = 0;
	
	public void tick() { time++; } // advance time by one
	public int current() { return time; }

	public static void main(String[] args) {
		
	}

}
