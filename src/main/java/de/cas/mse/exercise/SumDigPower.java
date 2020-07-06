package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> getListOfNumberWhereSumDigPowEqualsNumber(long startValueOfRange, long endValueOfRange) {

		List<Long> result = new ArrayList<Long>();

		for (long actualNumber = startValueOfRange; actualNumber < endValueOfRange; actualNumber++) {

			List<Long> digitsOfActualNumber;

            String actualNumberAsString = Long.toString(actualNumber);
            
            digitsOfActualNumber = splitNumberIntoDigits(actualNumberAsString);

			long sumOfPowedDigits = sumPowedDigits(digitsOfActualNumber);

			// Test if sum is equal
			if (sumOfPowedDigits == actualNumber) {
				result.add(actualNumber);
			}

		}

        System.out.println(result);
		return result;

    }

    private long sumPowedDigits(List<Long> digitsOfActualNumber) {
        // Create sum
        long sum = 0;
        for (int actualDigitIndex = 0; actualDigitIndex < digitsOfActualNumber.size(); actualDigitIndex++) {
        	sum += Math.pow(digitsOfActualNumber.get(actualDigitIndex), actualDigitIndex + 1);
        }
        return sum;
    }
    
    private List<Long> splitNumberIntoDigits(String actualNumberAsString){
            List<Long> digitsOfActualNumber = new ArrayList<>();

        	// Split values
			for (int actualDigit = 0; actualDigit < actualNumberAsString.length(); actualDigit++) {
				digitsOfActualNumber.add(Long.valueOf(actualNumberAsString.substring(actualDigit, actualDigit + 1)));
            }
            
            return digitsOfActualNumber;
    }

}