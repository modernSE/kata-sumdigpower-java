package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long rangeFromIncl, long rangeToExcl) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = rangeFromIncl; currentNumber < rangeToExcl; currentNumber++) {

			List<Long> digits = extractDigits(currentNumber);

			long powerSum = calculatePowerSum(digits);

			if (powerSum == currentNumber) {
				result.add(powerSum);
			}

		}

        System.out.println(result);
		return result;

	}

	private long calculatePowerSum(List<Long> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;

	}

	private List<Long> extractDigits(long number) {
		List<Long> digits = new ArrayList<Long>();

		String numberString = Long.toString(number);

		for (int j = 0; j < numberString.length(); j++) {
			digits.add(Long.valueOf(numberString.substring(j, j + 1)));
		}
		return digits;
	}

}