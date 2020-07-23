package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findAllEurekaNumbersInRangeAndPrint(long lowerBound, long upperBound) {
		List<Long> eurekaNumbers = findAllEurekaNumbersInRange(lowerBound, upperBound);
        System.out.println(eurekaNumbers);
		return eurekaNumbers;
	}

    private List<Long> findAllEurekaNumbersInRange(long lowerBound, long upperBound) {
        List<Long> eurekaNumbers = new ArrayList<>();
        for (long candidate = lowerBound; candidate < upperBound; candidate++) {
			if (isEurekaNumber(candidate)) {
				eurekaNumbers.add(candidate);
			}
        }
        return eurekaNumbers;
    }

    private boolean isEurekaNumber(long candidate) {
        List<Long> digits = extractDigits(candidate);
        long sum = sumDigitsPower(digits);
        return sum == candidate;
    }

    private long sumDigitsPower(List<Long> digits) {
        long sum = 0;
        for (int j = 1; j <= digits.size(); j++) {
        	sum += Math.pow(digits.get(j - 1), j);
        }
        return sum;
    }

    private List<Long> extractDigits(long candidate) {
        List<Long> digits = new ArrayList<Long>();
        String candidateStr = Long.toString(candidate);
        for (int pos = 0; pos < candidateStr.length(); pos++) {
        	digits.add(Long.valueOf(candidateStr.substring(pos, pos + 1)));
        }
        return digits;
    }

}