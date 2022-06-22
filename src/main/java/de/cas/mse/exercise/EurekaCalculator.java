package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class EurekaCalculator {

	public List<Long> compute(long lowerBound, long upperBound) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long numberToCheck = lowerBound; numberToCheck < upperBound; numberToCheck++) {
			List<Long> currentNumberDigits = splitNumberIntoDigits(numberToCheck);
			long sum = createPowSum(currentNumberDigits);
			if (sum == numberToCheck) {
				eurekaNumbers.add(sum);
			}
		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;
	}

	public long createPowSum(List<Long> longs) {
		long sum = 0;
		for (int j = 1; j <= longs.size(); j++) {
			sum += Math.pow(longs.get(j - 1), j);
		}
		return sum;
	}

	public List<Long> splitNumberIntoDigits(long index) {
		List<Long> currentNumberDigits = new ArrayList<Long>();
		String temp = Long.toString(index);
		for (int j = 0; j < temp.length(); j++) {
			currentNumberDigits.add(Long.valueOf(temp.substring(j, j + 1)));
		}
		return currentNumberDigits;
	}
}