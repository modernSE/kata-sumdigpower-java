package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	/**
	 * 
	 * @param startNumber
	 * @param endNumber
	 * @return all values where a number is equal to the sum of its digits, raised to the power of their position in the number.
	 */
	public List<Long> findFittingNumbers(long startNumber, long endNumber) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = startNumber; currentNumber < endNumber; currentNumber++) {
			
			// block auslagern?
			List<Long> digits = splitNumberIntoDigits(currentNumber);

			long powSum = calculatePowSumOfDigits(digits);

			if (powSum == currentNumber) {
				result.add(powSum);
			}

		}
		return result;
	}
	
	private List<Long> splitNumberIntoDigits(long number) {
		List<Long> digits = new ArrayList<>();
		
		String numberString = Long.toString(number);
		for (int i = 0; i < numberString.length(); i++) {
			char digit = numberString.charAt(i);						//Schön. Leichter lesbar als mit String und substring()
			digits.add(Long.valueOf(Character.getNumericValue(digit)));
		}		
		return digits;		
	}
	
	private long calculatePowSumOfDigits(List<Long> digits) {
		long sum = 0;
		for (int i = 0; i < digits.size(); i++) {
			sum += Math.pow(digits.get(i), i + 1);
		}
		
		return sum;
	}

}