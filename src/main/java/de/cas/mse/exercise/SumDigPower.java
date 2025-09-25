package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerLimit, long upperLimit) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long numberToCheck = lowerLimit; numberToCheck < upperLimit; numberToCheck++) {

			List<Long> splittedNumber = new ArrayList<Long>();

			String numberAsString = Long.toString(numberToCheck);
			
			// Alles mit Kommentar sollte eigene Methode sein

			// Split values
			for (int indexOfNumber = 0; indexOfNumber < numberAsString.length(); indexOfNumber++) {
				splittedNumber.add(Long.valueOf(numberAsString.substring(indexOfNumber, indexOfNumber + 1)));
			}

			// Create sum
			long poweredSum = 0;
			for (int positionOfNumber = 1; positionOfNumber <= splittedNumber.size(); positionOfNumber++) {
				poweredSum += Math.pow(splittedNumber.get(positionOfNumber - 1), positionOfNumber);
			}

			// Test if sum is equal
			if (poweredSum == numberToCheck) {
				eurekaNumbers.add(poweredSum);
			}

		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;

	}

}