package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream; //unused import!
import java.util.stream.LongStream;

public class SumDigPower {
	
	// definition of minimum and maximum can be confusing as parameters of a range bounds
	public List<Long> sumDigPow(long minimum, long maximum) {
		
		List<Long> result = new ArrayList<Long>(); // pls remove Long from ArrayList 
		
		// Use of range(startInclusive, endExclusive) can cause bugs
		// i could be renamed to number
		LongStream.range(minimum, maximum).forEach(i -> {
			List<Long> digits = extractDigits(i);
			long sum = calculateSum(digits); 

			if (sum == i) {
				result.add(sum);
			}
		});
		
		return result;
	}

	private List<Long> extractDigits(long number) {
		List<Long> digits = new ArrayList<Long>(); // pls remove Long from ArrayList 
		String numberAsString = Long.toString(number);

		for (int i = 0; i < numberAsString.length(); i++) {
			String currentDigitAsString = numberAsString.substring(i, i + 1);
			digits.add(Long.valueOf(currentDigitAsString));
		}
		
		return digits;
	}

	// calculateSum is a misleading name
	private long calculateSum(List<Long> digits) {
		long sum = 0;
		
		for (int i = 1; i <= digits.size(); i++) {
			Long currentDigit = digits.get(i - 1); //sehr gut
			sum += Math.pow(currentDigit, i);
		}
		
		return sum;
	}

}