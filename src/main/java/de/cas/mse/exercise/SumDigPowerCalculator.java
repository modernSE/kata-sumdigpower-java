package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumDigPowerCalculator {

	public List<Long> searchSumDigPowerNumbersInRange(long lowerBoundary, long upperBoundary) {

		List<Long> foundNumbers = new ArrayList<Long>();

		for (long index = lowerBoundary; index < upperBoundary; index++) {

			String currentIndexAsString = Long.toString(index);

			List<Long> digits = splitIndexIntoDigits(currentIndexAsString);

			long sum = sumOfPoweredDigits(digits);

			if (sum == index) {
				foundNumbers.add(sum);
			}
		}

        System.out.println(foundNumbers);
		return foundNumbers;

	}

	private long sumOfPoweredDigits(List<Long> digits) {
		long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
		}
		return sum;
	}

	private List<Long> splitIndexIntoDigits(String currentIndexAsString) {
		List<Long> digits = new LinkedList<Long>();
		for (int i = 0; i < currentIndexAsString.length(); i++) {
			digits.add(Long.valueOf(currentIndexAsString.substring(i, i + 1)));
		}
		return digits;
	}
}