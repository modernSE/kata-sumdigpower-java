package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> getEurekaNumbers(long start, long exclusiveEnd) {
		List<Long> result = new ArrayList<Long>();

		for (long candidate = start; candidate < exclusiveEnd; candidate++) {
			List<Long> digits = getDigits(candidate);
			long eurekaSum = getEurekaSum(digits);

			if (eurekaSum == candidate) {
				 result.add(eurekaSum);
			}
		}

        System.out.println(result);
		return result;

	}

	private long getEurekaSum(List<Long> digits) {
		long sum = 0;

		for (int exponent = 1; exponent <= digits.size(); exponent++) {
			int index = exponent - 1;
			sum += Math.pow(digits.get(index), exponent);
		}

		return sum;
	}

	private List<Long> getDigits(long candidate) {
		String candidateString = Long.toString(candidate);
		List<Long> digits = new ArrayList<Long>();

		for (int index = 0; index < candidateString.length(); index++) {
			long digit = getDigitAtIndex(candidateString, index);
			digits.add(digit); 
		}

		return digits;
	}

	private Long getDigitAtIndex(String candidateString, int index) {
		String digit = candidateString.substring(index, index + 1);
		return Long.valueOf(digit);
	}

}