package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SumDigPower {

	public List<Long> getEurekaNumbersInRange(long startInclusive, long endExclusive) {
		List<Long> result = new ArrayList<Long>();

		for (long i = startInclusive; i < endExclusive; i++) {
			if (isEurekaNumber(i)) {
				result.add(i);
			}
		}

        System.out.println(result);
		return result;
	}

	private boolean isEurekaNumber(long number) {
		List<Long> digits = getDigits(number);
		long sum = getPowerSum(digits);
		return sum == number;
	}

	private List<Long> getDigits(long number) {
		if (number == 0) {
			return List.of(0L);
		}

		Deque<Long> digits = new ArrayDeque<>();
		while (number > 0) {
			digits.addFirst(number % 10);
			number /= 10;
		}

		return new ArrayList<>(digits);
	} 

	private long getPowerSum(List<Long> values) {
		long sum = 0;
		for (int position = 0; position < values.size(); position++) {
			sum += Math.pow(values.get(position), position + 1);
		}
		return sum;
	}

}