package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> getNumbersInRange(long lowerLimit, long upperLimit) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = lowerLimit; currentNumber < upperLimit; currentNumber++) {

			List<Long> digits = getDigits(currentNumber);
			long sum = computeSum(digits);

			if (sum == currentNumber) {
				result.add(sum);
			}
		}

		System.out.println(result);
		return result;

	}

	private long computeSum(List<Long> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

	private List<Long> getDigits(long currentNumber) {
		char[] digits = Long.toString(currentNumber).toCharArray();

		return List.of(digits).stream() //
				.map(String::new)
				.map(Long::parseLong) //
				.toList();
	}

}