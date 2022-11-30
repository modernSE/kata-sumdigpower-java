package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class ExtractEurekaNumbers {

	public List<Long> extractEurekaNumbers(long intervalBegin, long intervalEnd) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long i = intervalBegin; i < intervalEnd; i++) {

			List<Long> digits = this.splitNumberIntoDigits(i);
			
			long sum = this.calcPotentialEurekaNumber(digits);

			this.checkEurekaNumber(eurekaNumbers, sum, i);
		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;

	}

	private List<Long> splitNumberIntoDigits(long number) {
		String temp = Long.toString(number);
		List<Long> digits = new ArrayList<Long>();

		for (int j = 0; j < temp.length(); j++) {
			digits.add(Long.valueOf(temp.substring(j, j + 1)));
		}
		return digits;
	}

	private long calcPotentialEurekaNumber(List<Long> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

	private void checkEurekaNumber(List<Long> result, long sum, long initialNumber) {
		if (sum == initialNumber) {
			result.add(sum);
		}
	}

}