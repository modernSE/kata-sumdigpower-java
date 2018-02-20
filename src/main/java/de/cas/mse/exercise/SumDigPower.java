package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	// Zu viele Numbers! startRange, endRange, candidate.
	
	public List<Long> getMagicNumbers(long startNumber, long endNumber) {

		List<Long> magicNumbers = new ArrayList<Long>();

		for (long number = startNumber; number < endNumber; number++) {
			if (isMagicNumber(number)) {
				magicNumbers.add(number);
			}
		}

		return magicNumbers;

	}
	
	// was ist Magic?
	private boolean isMagicNumber(long number) {
		long value = getMagicNumberValue(extractDigits(number));
		return value == number;
	}
	
	// Name: getSumOfDigitPowers?
	private long getMagicNumberValue(List<Long> digits) {
		long sum = 0;
		// Schleife mit 0 anfangen
		for (int position = 1; position <= digits.size(); position++) {
			// lokale Variable einführen
			sum += Math.pow(digits.get(position - 1), position);
		}
		return sum;
	}

	private List<Long> extractDigits(long number) {
		List<Long> digits = new ArrayList<Long>();
		String numberAsString = Long.toString(number);

		// Schleifenvariable: j -> pos?. Zumindest: j -> i
		for (int j = 0; j < numberAsString.length(); j++) {
			digits.add(extractDigitAtPosition(numberAsString, j));
		}
		return digits;
	}

	private Long extractDigitAtPosition(String numberAsString, int position) {
		// lokale Variablen
		return Long.valueOf(numberAsString.substring(position, position + 1));
	}

}