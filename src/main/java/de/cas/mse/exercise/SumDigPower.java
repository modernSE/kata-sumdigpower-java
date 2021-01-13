package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

    private List<Long> extractDigits(long number) {
        String numberAsString = Long.toString(number);
        List<Long> digits = new ArrayList<Long>();
        for (int i = 0; i < numberAsString.length(); i++) {
            String digit = numberAsString.substring(i, i + 1);
			digits.add(Long.valueOf(digit));
        }
        return digits;
    }

    private long calculateSumDigPow(long number) {
        List<Long> digits = extractDigits(number);
        long sum = 0;
		for (int i = 1; i <= digits.size(); i++) {
			sum += Math.pow(digits.get(i - 1), i);
        }
        return sum;
    }

    public List<Long> calculateEurekaNumbers(long lowerBound, long upperBound) {
        List<Long> eurekaNumbers = new ArrayList<Long>();

        // BUG: upperBound should be inclusive
		for (long candidate = lowerBound; candidate < upperBound; candidate++) {
			long sum = calculateSumDigPow(candidate);
			if (sum == candidate) {
				eurekaNumbers.add(candidate);
			}
        }
        return eurekaNumbers;
    }

	public List<Long> sumDigPow(long lowerBound, long upperBound) {
		List<Long> eurekaNumbers = calculateEurekaNumbers(lowerBound, upperBound);
        System.out.println(eurekaNumbers);
		return eurekaNumbers;

	}

}