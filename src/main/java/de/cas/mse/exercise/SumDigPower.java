package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumDigPower {

	public List<Long> computeAllSpecialNumbersInRange(long lowerBound, long upperBound) {

		List<Long> result = new ArrayList<Long>();
		
		for (long candidate = lowerBound; candidate < upperBound; candidate++) {
			List<Long> digits = splitDigits(candidate);

			long sum = calculateSumOfPowers(digits);

			if (sum == candidate) {
				result.add(sum);
			}
		}

		return result;

	}
	
	private List<Long> splitDigits(long number) {
		String numberAsString = Long.toString(number);
		List<Long> digits = new ArrayList<>();
		
		for (int position = 0; position < numberAsString.length(); position++) {
			Long value = digitValueAtPosition(numberAsString, position);
			digits.add(value);
		}
		
		return digits;
	}

	private Long digitValueAtPosition(String numberAsString, int position) {
		String digit = numberAsString.substring(position, position + 1);
		return Long.valueOf(digit);
	}

	private long calculateSumOfPowers(List<Long> digits) {
		long sum = 0;
		long exponent = 1;
		
		for (Long digit : digits) {
			sum += Math.pow(digit, exponent);
			exponent += 1;
		}
		
		return sum;
	}



}