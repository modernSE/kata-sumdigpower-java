package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findAndPrintEurekaNumbers(long minNumber, long maxNumber) {

		List<Long> eurakeNumbers = new ArrayList<Long>();

		for (long currentNumber = minNumber; currentNumber < maxNumber; currentNumber++) {

			List<Long> currentNumberAsList = new ArrayList<Long>();
			String currentNumberAsString = Long.toString(currentNumber);

			splitStringToList(currentNumberAsList, currentNumberAsString);

			long potentialEurekaSum = createPotentialEurekaSum(currentNumberAsList);

			if(potentialEurekaSum == currentNumber) {
				eurakeNumbers.add(potentialEurekaSum);
			}
		}

        System.out.println(eurakeNumbers);
		return eurakeNumbers;

	}

	private long createPotentialEurekaSum(List<Long> currentNumberAsList) {
		long potentialEurekaSum = 0;
		for (int j = 1; j <= currentNumberAsList.size(); j++) {
			potentialEurekaSum += Math.pow(currentNumberAsList.get(j - 1), j);
		}
		return potentialEurekaSum;
	}

	private void splitStringToList(List<Long> currentNumberAsList, String currentNumberAsString) {
		for (int j = 0; j < currentNumberAsString.length(); j++) {
			currentNumberAsList.add(Long.valueOf(currentNumberAsString.substring(j, j + 1)));
		}
	}

}