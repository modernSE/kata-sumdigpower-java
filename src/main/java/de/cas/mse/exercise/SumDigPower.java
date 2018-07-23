package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	// Fehlende params und return in Javadoc
	/**
	 * Returns a sorted list of numbers that fulfill the "Sum-Dig-Power" property
	 * in the range of [lowerBound, upperBound] (inclusive).
	 */
	public List<Long> sumDigPow(long lowerBound, long upperBound) {
		// Mehrzahl "results"
		List<Long> result = new ArrayList<>();
		for (long number = lowerBound; number < upperBound; number++) {
			// We like to split the long into digits here
			// splitDigits
			// calculatePowerSum
			long powerSum = calculatePowerSumOfDecimalDigits(number);
			if (powerSum == number) {
				result.add(powerSum);
			}
		}
		return result;
	}

	// Methodenname verwirrt mehr als dass er zum Verständnis beiträgt
	private long calculatePowerSumOfDecimalDigits(long number) {
		List<Long> digitsOfNumber = splitIntoDecimalDigits(number);
		long powerSum = 0;
		int power = 1;
		// Use for(int i=...) as you need a Laufvariable for the power :D
		for (Long digit : digitsOfNumber) {
			powerSum += Math.pow(digit, power);
			power++;
		}
		return powerSum;
	}

	private List<Long> splitIntoDecimalDigits(long number) {
		List<Long> digitsOfNumber = new ArrayList<>();
		// temp ist kein guter Name. Besser numberAsText
		String temp = Long.toString(number);
		for (int i = 0; i < temp.length(); i++) {
			Long digit = Long.valueOf(temp.substring(i, i + 1));
			digitsOfNumber.add(digit);
		}
		return digitsOfNumber;
	}

}