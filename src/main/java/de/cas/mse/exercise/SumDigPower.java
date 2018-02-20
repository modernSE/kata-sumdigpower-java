package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> getMagicNumbers(long startNumber, long endNumber) {

		List<Long> magicNumbers = new ArrayList<Long>();

		for (long number = startNumber; number < endNumber; number++) {
			if (isMagicNumber(number)) {
				magicNumbers.add(number);
			}
		}

		return magicNumbers;

	}
	
	private boolean isMagicNumber(long number) {
		long value = getMagicNumberValue(extractDigits(number));
		return value == number;
	}
	
	private long getMagicNumberValue(List<Long> digits) {
		long sum = 0;
		for (int position = 1; position <= digits.size(); position++) {
			sum += Math.pow(digits.get(position - 1), position);
		}
		return sum;
	}

	private List<Long> extractDigits(long number) {
		List<Long> digits = new ArrayList<Long>();
		String numberAsString = Long.toString(number);

		for (int j = 0; j < numberAsString.length(); j++) {
			digits.add(extractDigitAtPosition(numberAsString, j));
		}
		return digits;
	}

	private Long extractDigitAtPosition(String numberAsString, int position) {
		return Long.valueOf(numberAsString.substring(position, position + 1));
	}

}