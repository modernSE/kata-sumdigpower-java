package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerBound, long upperBound) {

		List<Long> matchingNumbers = new ArrayList<Long>();

		for (long currNumberToCheck = lowerBound; currNumberToCheck < upperBound; currNumberToCheck++) {

			List<Integer> places = splitNumber(currNumberToCheck);			

			long sum = calculateSum(places);
			
			if (sum == currNumberToCheck) {
				matchingNumbers.add(sum);
			}

		}

        System.out.println(matchingNumbers);
		return matchingNumbers;

	}

	private List<Integer> splitNumber(long numberToSplit) {
		List<Integer> returnList = new ArrayList<>();

		String numberToCheckString = Long.toString(numberToSplit);

		// Split values
		for (int index = 0; index < numberToCheckString.length(); index++) {
			returnList.add(Integer.valueOf(numberToCheckString.substring(index, index + 1)));
		}

		return returnList;
	}

	private long calculateSum(List<Integer> numbers) {
		long sum = 0;
		for (int j = 1; j <= numbers.size(); j++) {
			sum += Math.pow(numbers.get(j - 1), j);
		}
		return sum;
	}

}