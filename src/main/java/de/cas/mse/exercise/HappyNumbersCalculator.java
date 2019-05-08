package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class HappyNumbersCalculator {

	// What are happy numbers?
	public List<Long> extractHappyNumbers(long startNumber, long endNumber) {

		List<Long> happyNumbers = new ArrayList<Long>();
		
		for (long i = startNumber; i < endNumber; i++) {
			// great solution! very readable! Merlin you're a wizard!  
			if (isHappyNumber(i)) {
				happyNumbers.add(i);
			}
		}

		return happyNumbers;
	}

	private boolean isHappyNumber(long number) {
		List<Long> digits = splitIntoDigits(number);
		long sumOfDigitPowers = calculateSumOfPowers(digits);
		
		// "? true : false" -> redundant! 
		return sumOfDigitPowers == number ? true : false;
	}

	private List<Long> splitIntoDigits(long number) {
		List<Long> digits = new ArrayList<Long>();

		String numberAsString = Long.toString(number);

		for (int i = 0; i < numberAsString.length(); i++) {
			String digit = numberAsString.substring(i, i + 1);
			digits.add(Long.valueOf(digit));
		}

		return digits;
	}

	private long calculateSumOfPowers(List<Long> digits) {
		long sumOfPowers = 0;

		// i starts at 0 -> great again!
		for (int i = 0; i < digits.size(); i++) {
			sumOfPowers += Math.pow(digits.get(i), i + 1);
		}

		return sumOfPowers;
	}

}