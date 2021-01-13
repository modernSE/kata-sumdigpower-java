package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long minRange, long maxRange) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long numberToTest = minRange; numberToTest < maxRange; numberToTest++) {
            List<Long> digits = seperateDigits(numberToTest);

			long sum = sumDigitsToConsecutivePowers(digits);

			if (isEurekaNumber(sum, numberToTest)) {
				eurekaNumbers.add(sum);
			}
		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;

    }
    
    private List<Long> seperateDigits(Long numberToSeperate) {
        List<Long> digits = new ArrayList<Long>();
		String numberAsString = Long.toString(numberToSeperate);

		for (int digitCounter = 0; digitCounter < numberAsString.length(); digitCounter++) {
			digits.add(Long.valueOf(numberAsString.substring(digitCounter, digitCounter + 1)));
        }
        return digits;
    }

    private long sumDigitsToConsecutivePowers(List<Long> digits) {
		long sum = 0;
		for (int currentDigit = 1; currentDigit <= digits.size(); currentDigit++) {
			sum += Math.pow(digits.get(currentDigit - 1), currentDigit);
        }
        return sum;
    }

    private boolean isEurekaNumber(long sum, long numberToTest) {
        return sum == numberToTest;
    }
}