package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerBoundary, long upperBoundary) {

		List<Long> result = new ArrayList<Long>();

		for (long i = lowerBoundary; i < upperBoundary; i++) {

			List<Long> digits = new ArrayList<Long>();

			String number = Long.toString(i);

			// Split values
			digits = splitValues(digits, number);

			// Create sum
			long sum = createSum(digits);

			// Test if sum is equal
			if (sum == i) {
				result.add(sum);
			}

		}

        System.out.println(result);
		return result;

	}

	private List<Long> splitValues(List<Long> digits, String number) {
		for (int j = 0; j < number.length(); j++) {
			String digit = number.substring(j, j + 1);
			digits.add(Long.valueOf(digit));
		}
		return digits;
	}

	private long createSum(List<Long> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

}