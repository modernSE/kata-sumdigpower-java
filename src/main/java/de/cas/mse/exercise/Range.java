package de.cas.mse.exercise;

public class Range {
	private long start;
	private long end;
	private long currentNumber;
	
	public Range (long start, long end) {
		this.end = end;
		this.start = start;
		this.currentNumber=start-1;
	}
	public long getStart() {
		return start;
	}
	public long getEnd() {
		return end;
	}
	
	public long getCurrentNumber() {
		return currentNumber;
	}
	
	public void incrementCurrentNumber() {
		currentNumber++;
	}
}
