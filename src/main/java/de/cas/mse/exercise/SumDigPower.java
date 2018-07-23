package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(Collection<EurekaNumberInputRange> ranges) {
		for (EurekaNumberInputRange range : ranges) {
		List<Long> result = new ArrayList<Long>();
		for (long number = lowerBoundInclusive; number < upperBoundInclusive; number++) {
			List<Long> digits = extractDigits(number);
			long eurekaValue = calculateEurekaValue(digits);
			addToResultIfEurekaNumberFound(result, number, eurekaValue);
		}
		return result;
		}
	}

	private void addToResultIfEurekaNumberFound(List<Long> result, final long number, final long eurekaValue) {
		if (eurekaValue == number) {
			result.add(eurekaValue);
		}
	}

	private long calculateEurekaValue(final List<Long> digits) {
		long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
		}
		return sum;
	}

	private List<Long> extractDigits(final Long number) {
		String numberAsString = Long.toString(number);
		List<Long> digits = new ArrayList<Long>();
		for (int i = 0; i < numberAsString.length(); i++) {
			String digit = numberAsString.substring(i, i + 1);
			digits.add(Long.valueOf(digit));
		}
		return digits;
	}

}