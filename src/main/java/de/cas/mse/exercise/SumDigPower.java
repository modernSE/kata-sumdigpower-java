package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerLimit, long upperLimit) {
		List<Long> eurokaNumbers = new ArrayList<Long>();
		for (long possibleEurokaNumber = lowerLimit; possibleEurokaNumber < upperLimit; possibleEurokaNumber++) {
			List<Long> digits = splitNumberToDigits(possibleEurokaNumber);

			long sumDigPow = calculateSumDigPow(digits);

			if (isEurokaNumber(sumDigPow, possibleEurokaNumber)) {
				eurokaNumbers.add(sumDigPow);
			}
		}
		return eurokaNumbers;
	}

	private boolean isEurokaNumber( long sumDigPow, long possibleEurokaNumber) {
		return sumDigPow == possibleEurokaNumber;
	}
	
	private long calculateSumDigPow(List<Long> digits) {
		long possibleEurokaNumber = 0;
		for (int j = 1; j <= digits.size(); j++) {
			possibleEurokaNumber += Math.pow(digits.get(j - 1), j);
		}
		return possibleEurokaNumber;
	}

	private List<Long> splitNumberToDigits(Long number) {
		String numberString = Long.toString(number);
		List<Long> digits = new ArrayList<Long>();
		for (int j = 0; j < numberString.length(); j++) {
			digits.add(Long.valueOf(numberString.substring(j, j + 1)));
		}
		return digits;
	}

}