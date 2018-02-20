package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findNumbersEqualToSumOfTheirDigitPowers(long rangeStart, long rangeEnd) {
		List<Long> numbers = new ArrayList<Long>();

		for (long i = rangeStart; i < rangeEnd; i++) {
			List<Long> digits = splitIntoDigits(i);
			long sum = calculateSumOfPowers(digits);

			if (sum == i) {
				numbers.add(sum);
			}
		}

		return numbers;
	}

	private List<Long> splitIntoDigits(long number) {
		List<Long> digits = new ArrayList<Long>();
		String numberToSplit = Long.toString(number);

		for (int j = 0; j < numberToSplit.length(); j++) {
			digits.add(Long.valueOf(numberToSplit.substring(j, j + 1)));
		}

		return digits;
	}

	private long calculateSumOfPowers(List<Long> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

}