package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class EurekaNumbers {

	public List<Long> getEurekaNumbers(long startNumber, long endNumber) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = startNumber; currentNumber < endNumber; currentNumber++) {

			List<Long> digits = this.getDigits(currentNumber);

			long sum = this.sumDigPow(digits);

			// Test if sum is equal
			if (sum == currentNumber) {
				result.add(sum);
			}
		}

		return result;
    }
    
    private List<Long> getDigits(long number) {
        List<Long> digits = new ArrayList<Long>();

        String currentNumberAsString = Long.toString(number);

        // Split values
        for (int charIndex = 0; charIndex < currentNumberAsString.length(); charIndex++) {
            digits.add(Long.valueOf(currentNumberAsString.substring(charIndex, charIndex + 1)));
        }

        return digits;
    }

    private long sumDigPow(List<Long> digits) {
        long sum = 0;

        for (int digitIndex = 0; digitIndex < digits.size(); digitIndex++) {
            sum += Math.pow(digits.get(digitIndex), digitIndex + 1);
        }
        
        return sum;
    }

}