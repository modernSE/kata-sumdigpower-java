package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	// rangeStart could be renamed to rangeStartInclusive
	// same for rangeEnd
	public List<Long> sumDigPow(long rangeStart, long rangeEnd) {

		// good name for variable!
		List<Long> eurekaNumbers = new ArrayList<Long>(); // remove Long in Array

		for (long number = rangeStart; number < rangeEnd; number++) {
			List<Long> digits = extractDigits(Long.toString(number));
			long eurekaValue = calculateEurekaValue(digits); // maybe put extractDigits() call into calculateEurekaValue()
			
			boolean isEurekaNumber = eurekaValue == number; // to if or into own method
			if (isEurekaNumber) {
				eurekaNumbers.add(number);
			}
		}
		return eurekaNumbers;
	}
	
	private List<Long> extractDigits(String number) { // Long here with Long.toString(..)
		List<Long> longs = new ArrayList<Long>(); // digits - not longs // remove Long
		for (int i = 0; i < number.length(); i++) {
			String digit = number.substring(i, i + 1); // nice!
			longs.add(Long.valueOf(digit));
		}
		return longs;
	}

	// good name for method!
	private long calculateEurekaValue(List<Long> digits) {
		long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
		}
		return sum;
	}
}