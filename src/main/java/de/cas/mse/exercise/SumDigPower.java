package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> getEurekaNumbersInRange(long min, long maxExclusive) {

		List<Long> result = new ArrayList<Long>();

		for (long currNumber = min; currNumber < maxExclusive; currNumber++) {

			List<Long> currDigits = new ArrayList<Long>();

			String currNumberString = Long.toString(currNumber);

			// Split values
			for (int i = 0; i < currNumberString.length(); i++) {
				currDigits.add(Long.valueOf(currNumberString.substring(i, i + 1)));
			}

			// Create sum
			long currSum = 0;
			for (int i = 1; i <= currDigits.size(); i++) {
				currSum += Math.pow(currDigits.get(i - 1), i);
			}

			// Test if sum is equal
			if (currSum == currNumber) {
				result.add(currSum);
			}

		}

		return result;

	}

	public void printEurekaNumbersInRange(long min, long maxExclusive) {
		System.out.println(this.getEurekaNumbersInRange(min, maxExclusive));
	}

}