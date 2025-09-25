package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	private List<Long> extractDigits(Long number) {
		List<Long> digits = new ArrayList<Long>();

		String temp = Long.toString(number);

		for (int pos = 0; pos < temp.length(); pos++) {
			var currentDigit = temp.substring(pos, pos + 1);
			digits.add(Long.valueOf(currentDigit));
		}

		return digits;
	}

	private long calculateSum(List<Long> digits) {
		long sum = 0;
		for (int pos = 1; pos <= digits.size(); pos++) {
			sum += Math.pow(digits.get(pos - 1), pos);
		}
		return sum;
	}

	public List<Long> sumDigPow(long from, long to) {

		List<Long> result = new ArrayList<Long>();

		for (long current = from; current < to; current++) {
			long sum = calculateSum(extractDigits(current));

			if (sum == current) {
				result.add(sum);
			}

		}

        System.out.println(result);
		return result;

	}

}