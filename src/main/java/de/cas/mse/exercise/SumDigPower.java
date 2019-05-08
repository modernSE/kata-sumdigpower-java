package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumDigPower { //class umbenennen? 
	//methodenname zu(?) lang 
	
	//müssen es longs sein? sind doch immer integer - alles andere wäre fehlerhaft? 
	public List<Long> findNumbersWhereSumOfDigitPowersIsEqualToTheNumberItselfInInterval(long lowerBound, long upperBound) {
		List<Long> result = new ArrayList<Long>();

		for (long number = lowerBound; number < upperBound; number++) { //laufvariable umbenannt?
			long sum = calculateSumOfPowers(extractDigitsFromNumber(number));

			if (sum == number) {
				result.add(sum);
			}
		}

		return result;
	}
	private long calculateSumOfPowers(List<Long> digits) {
		long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
		}
		return sum;
	}

	private List<Long> extractDigitsFromNumber(long number) {
		List<Long> digits = new ArrayList<Long>();

		String numberAsString = Long.toString(number);
		
		for (int j = 0; j < numberAsString.length(); j++) {
			digits.add(Long.valueOf(numberAsString.substring(j, j + 1)));
		}
		
		return digits;
	}

}