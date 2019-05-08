package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	// Methodenname klingt so als wenn nur ein Wert berechnet wird.
	public List<Long> getSumDigPowerOfRange(long startValue, long endValue) { 

		List<Long> result = new ArrayList<Long>();
		
		for (long i = startValue; i < endValue; i++) {
			long sum = calculateSumDigPowOfSingleValue(i);		
			if (sum == i) {
				result.add(sum);
			}
		}
		return result;
	}
	
	// gut, dass das extra splitten wegfällt.
	private long calculateSumDigPowOfSingleValue(long value) {
		String stringOfValue = Long.toString(value);
		long sum = 0;
		for (int i = 0; i < stringOfValue.length(); i++) {
			int valueOfDigit = Character.getNumericValue(stringOfValue.charAt(i)); 
			sum += Math.pow(valueOfDigit, i+1);
		}
		return sum;
	}

}