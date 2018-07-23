package de.cas.mse.exercise;

public class EurekaNumberInputRange {
	long lowerBoundInclusive;
	long upperBoundInclusive;
	
	public EurekaNumberInputRange(long lowerBoundInclusive, long upperBoundInclusive) {
		if (lowerBoundInclusive > upperBoundInclusive) {
			throw new RuntimeException("lowerBoundInclusive should be lower as upperBoundInclusive");
		}
		
		this.lowerBoundInclusive = lowerBoundInclusive;
		this.upperBoundInclusive = upperBoundInclusive;
	}

}
