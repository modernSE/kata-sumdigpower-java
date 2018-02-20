package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findDigPowNumbersInRange(Range range) {
		List<Long> digPowNumbers = new ArrayList<Long>();
		while (range.getCurrentNumber() < range.getEnd()) {
			List<Long> allDigitsOfCurrentNumber = getAllDigitsOfCurrentNumber(range.getCurrentNumber());
			addDigPowNumbers(digPowNumbers, range, allDigitsOfCurrentNumber);
			range.incrementCurrentNumber();
		}
		return digPowNumbers;
	}

	private void addDigPowNumbers(List<Long> digPowNumbers, Range range, List<Long> allDigitsOfCurrentNumber) {
		if (getPowSumOfNumber(allDigitsOfCurrentNumber) == range.getCurrentNumber())
			digPowNumbers.add(getPowSumOfNumber(allDigitsOfCurrentNumber));
	}

	private long getPowSumOfNumber(List<Long> allDigitsOfCurrentNumber) {
		long sum = 0;
		for (int positionOfNumberInContainer = 0; positionOfNumberInContainer < allDigitsOfCurrentNumber
				.size(); positionOfNumberInContainer++) {
			sum += Math.pow(allDigitsOfCurrentNumber.get(positionOfNumberInContainer), positionOfNumberInContainer + 1);
		}
		return sum;
	}

	private List<Long> getAllDigitsOfCurrentNumber(long i) {
		List<Long> allDigitsOfCurrentNumber = new ArrayList<Long>();
		String currentNumber = Long.toString(i);

		for (int j = 0; j < currentNumber.length(); j++) {
			String nextCharakterinNumber = currentNumber.substring(j, j + 1);
			Long nextDigit = Long.valueOf(nextCharakterinNumber);
			allDigitsOfCurrentNumber.add(nextDigit);
		}
		return allDigitsOfCurrentNumber;
	}

}