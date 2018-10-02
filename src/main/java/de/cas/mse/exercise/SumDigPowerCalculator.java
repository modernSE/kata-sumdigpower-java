package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SumDigPowerCalculator {

	// not really calculating anything (or at least, the calculation isn't
	// important)
	public List<Long> calculateNumbers(long lowerBound, long upperBound) {
		List<Long> result = new ArrayList<>();
		for (long i = lowerBound; i < upperBound; i++) {
			// ist das nötig?
			processNumber(i).ifPresent(result::add);
		}
		return result;
	}

	// ist verkompliziert worden. Ursprüngliche Lösung war einfacher zu
	// verstehen.... und schneller!
	private Optional<Long> processNumber(long number) {
		List<Long> digits = extractDigits(number);
		List<Long> digitPowers = calculatePowers(digits);
		long sum = calculateSum(digitPowers);

		// schlechter lesbar
		return sum == number ? Optional.of(number) : Optional.empty();
	}

	private long calculateSum(List<Long> digits) {
		// ist ok
		return digits.stream().mapToLong(l -> l).sum();
	}

	private List<Long> calculatePowers(List<Long> digits) {
		List<Long> result = new ArrayList<>();
		for (int i = 0; i < digits.size(); i++) {
			result.add((long) Math.pow(digits.get(i), i + 1));
		}
		return result;
	}

	private List<Long> extractDigits(long number) {
		String numberString = Long.toString(number);

		List<Long> digits = new ArrayList<>();
		for (int i = 0; i < numberString.length(); i++) {
			String digitString = String.valueOf(numberString.charAt(i));
			Long digit = Long.valueOf(digitString);
			digits.add(digit);
		}
		return digits;
	}

}