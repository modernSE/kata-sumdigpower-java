package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> eureukaNumbersBetween(long lowerBound, long upperBound) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = lowerBound; currentNumber <= upperBound; currentNumber++) {
			
			List<Long> digits = extractDigits(currentNumber);
			long powSum = calculatePowSum(digits);

			if (checkEureka(currentNumber, powSum)){
				result.add(currentNumber);
			}	
		}

        System.out.println(result);
		return result;

	}

	private List<Long> extractDigits(long number){
		List<Long> digits = new ArrayList<>();
		String numberString = Long.toString(number);
		for (int i = 0; i < numberString.length(); i++) {
			digits.add(Long.valueOf(numberString.substring(i, i + 1)));
		}
		return digits;
	}

	private long calculatePowSum(List<Long> digits){
		long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
		}
		return sum;
	}

	private boolean checkEureka(long currentNumber, long sum){
		return sum == currentNumber;
	}
}