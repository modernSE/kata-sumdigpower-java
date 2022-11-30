package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerLimit, long upperLimit) {
		List<Long> eurekaNumbers = new ArrayList<Long>();
		for (long testCandidate = lowerLimit; testCandidate < upperLimit; testCandidate++) {
			if (isEurekaNumber(testCandidate)) {
				eurekaNumbers.add(testCandidate);
			}
		}
        System.out.println(eurekaNumbers);
		return eurekaNumbers;
	}

	private boolean isEurekaNumber(long testCandidate) {
		List<Long> digits = extractDigits(testCandidate);
		long sumOfDigits = sumDigits(digits);

		return testCandidate == sumOfDigits;
	}

	private List<Long> extractDigits(long number) {
		List<Long> digits = new ArrayList<Long>();
		String numberAsString = Long.toString(number);

		//temp.chars().forEach(c -> digits.add(Long.valueOf(c)));
		for (int j = 0; j <numberAsString.length(); j++) {	        
			digits.add(Long.valueOf(numberAsString.substring(j, j + 1)));	        
	   }
		return digits;
	}

	private long sumDigits(List<Long> digits) {
		long sum = 0;
		for (int position = 1; position <= digits.size(); position++) {
			sum += Math.pow(digits.get(position - 1), position);
		}
		return sum;
	}

}