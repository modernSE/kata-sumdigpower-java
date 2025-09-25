package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class EurekanumberCalculator {

	public List<Long> calculateFromRange(long startNumber, long stopNumber) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = startNumber; currentNumber < stopNumber; currentNumber++) {

			List<Long> potentialEurekaNumber = splitNumberToDigitList(currentNumber);

			long calculatedEurekaNumber = calculateEurekaNumber(potentialEurekaNumber);


			if (calculatedEurekaNumber == currentNumber) {
				result.add(calculatedEurekaNumber);
			}

		}

        System.out.println(result);
		return result;

	}

	private List<Long> splitNumberToDigitList(long currentNumber){
		List<Long> digitList = new ArrayList<Long>();

		String currentNumberAsString = Long.toString(currentNumber);

		for (int currentIndex = 0; currentIndex < currentNumberAsString.length(); currentIndex++) {
				digitList.add(Long.valueOf(currentNumberAsString.substring(currentIndex, currentIndex + 1)));
			}

		return digitList;
	}

	private long calculateEurekaNumber(List<Long> potentialEurokaNumber){
		long calculatedEurekaNumber = 0;
			for (int currentIndex = 1; currentIndex <= potentialEurokaNumber.size(); currentIndex++) {
				calculatedEurekaNumber += Math.pow(potentialEurokaNumber.get(currentIndex- 1), currentIndex);
			}

		return calculatedEurekaNumber;
	}

}