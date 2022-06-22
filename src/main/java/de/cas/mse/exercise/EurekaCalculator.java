package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class EurekaCalculator {

	public List<Long> calculateEurekaNumbersBetween(long start, long end) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long i = start; i < end; i++) {

			String numberToValidate = Long.toString(i);

			List<Long> digits = splitDigits(numberToValidate);

			long sum = calculateSumOfCrosses(digits);

			if (sum == i) {
				eurekaNumbers.add(sum);
			}

		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;

	}

	private List<Long> splitDigits(String numberToValidate) {
		List<Long> digits = new ArrayList<>();
		for (int j = 0; j < numberToValidate.length(); j++) {
			digits.add(Long.valueOf(numberToValidate.substring(j, j + 1)));
		}

		return digits;
	}

	private long calculateSumOfCrosses(List<Long> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

}