package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumOfDigitsPowered(long startOfInterval, long endOfInterval) {

		List<Long> result = new ArrayList<Long>();

		for (long i = startOfInterval; i < endOfInterval; i++) {

			List<Long> digits = new ArrayList<Long>();

			String currentNumber = Long.toString(i);

			List<Long> splittedCurrentNumber = splitCurrentNumber(digits, currentNumber);

			long sum = createSum(splittedCurrentNumber);

			// Test if sum is equal
			if (sum == i) {
				result.add(sum);
			}

		}

        System.out.println(result);
		return result;
	}

	private List<Long> splitCurrentNumber(List<Long> digits,String currentNumber) {
		for (int j = 0; j < currentNumber.length(); j++) {
			digits.add(Long.valueOf(currentNumber.substring(j, j + 1)));
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