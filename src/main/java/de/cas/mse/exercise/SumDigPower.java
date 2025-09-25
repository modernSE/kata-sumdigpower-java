package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> eureukaNumbersBetween(long lowerBound, long upperBound) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = lowerBound; currentNumber < upperBound; currentNumber++) {
			
			List<Long> digits = extractDigits(currentNumber);
			long sum = calculateSum(digits);

			if (checkEureka(currentNumber, sum)){
				result.add(currentNumber);
			}	
		}

        System.out.println(result);
		return result;

	}

	private List<Long> extractDigits(long number){
		List<Long> list = new ArrayList<>();
		String numberString = Long.toString(number);
		for (int j = 0; j < numberString.length(); j++) {
			list.add(Long.valueOf(numberString.substring(j, j + 1)));
		}
		return list;
	}

	private long calculateSum(List<Long> digits){
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

	private boolean checkEureka(long currentNumber, long sum){
		return sum == currentNumber;
	}
}