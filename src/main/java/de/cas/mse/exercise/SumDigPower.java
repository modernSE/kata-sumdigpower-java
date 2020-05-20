package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerBound, long upperBound) {

		List<Long> propertyFullfillingNumbers = findPropertyFullfillingNumbers(lowerBound, upperBound);

        System.out.println(propertyFullfillingNumbers);
		return propertyFullfillingNumbers;
    }

    private List<Long> findPropertyFullfillingNumbers(long lowerBound, long upperBound) {
        List<Long> propertyFullfillingNumbers = new ArrayList<>();
        for (long candidate = lowerBound; candidate < upperBound; candidate++) {

            List<Long> candidateAsDigits = splitNumberIntoDigits(candidate);

			Long sumOfDigitPowers = calculateSumOfDigitPowers(candidateAsDigits);
			if (sumOfDigitPowers == candidate) {
				propertyFullfillingNumbers.add(candidate);
			}
        }
        return propertyFullfillingNumbers;
    }
    
    private List<Long> splitNumberIntoDigits (Long number) {

        String numberAsString = Long.toString(number);

        List<Long> numberAsDigits = new ArrayList<Long>();

        for (int i = 0; i < numberAsString.length(); i++) {
            Long digit = Long.valueOf(numberAsString.substring(i, i + 1));
            numberAsDigits.add(digit);
        }

        return numberAsDigits;
    }

    private Long calculateSumOfDigitPowers(List<Long> digits) {
        long sumOfDigitPowers = 0;
        for (int i = 0; i < digits.size(); i++) {
            sumOfDigitPowers += Math.pow(digits.get(i), i + 1);
        }
        return sumOfDigitPowers;
    }
}