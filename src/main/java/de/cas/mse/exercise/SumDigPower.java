package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long minimumInclusive, long maximumExclusive) {
		List<Long> result = new ArrayList<Long>();

		for (long number = minimumInclusive; number < maximumExclusive; number++) {
			long sum = calculatePowerSumOfDigits(number);
			if (sum == number) {
				result.add(sum);
			}
		}

        System.out.println(result);
		return result;
	}

	private long calculatePowerSumOfDigits(long number) {
		List<Long> digits = extractDigits(number);

		long sum = 0;
		for (int digitIndex = 0; digitIndex < digits.size(); digitIndex++) {
			var digit = digits.get(digitIndex);
			sum += Math.pow(digit, digitIndex + 1);
		}
		return sum;
	}

	private List<Long> extractDigits(long input) {
		List<Long> result = new ArrayList<>();
		while(input >= 10) {
			result.add(input % 10);
			input = input / 10l;
		}
		result.add(input);
		return result.reversed();
	}

}