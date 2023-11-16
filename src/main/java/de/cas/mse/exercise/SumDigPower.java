package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long min, long max) {

		List<Long> result = new ArrayList<>();

		for (long currentNumber = min; currentNumber < max; currentNumber++) {

			List<Long> numbers = new ArrayList<>();

			splitValues(numbers, currentNumber);

			long currentSum = calculateSum(numbers);

			if (currentSum == currentNumber) {
				result.add(currentSum);
			}

		}

        System.out.println(result);
		return result;

	}

	private void splitValues(List<Long> numbers, long currentNumber) {
		char[] digits = Long.toString(currentNumber).toCharArray();
		for (int i = 0; i < digits.length; i++) {
			long digit = Long.valueOf(String.valueOf(digits[i]));
			numbers.add(digit);
		}
	}

	private long calculateSum(List<Long> numbers) {
		long sum = 0;
		for (int power = 1; power <= numbers.size(); power++) {
			sum += Math.pow(numbers.get(power - 1), power);
		}
		return sum;
	}

}