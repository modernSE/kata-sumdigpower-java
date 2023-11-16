package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPowerCalculator {

	public List<Long> calculate(long lowerBoundary, long upperBoundary) {
		List<Long> result = new ArrayList<Long>();

		for (long index = lowerBoundary; index < upperBoundary; index++) {
			final String indexAsString = Long.toString(index);
			final List<Long> splittedValues = split(indexAsString);
			final Long powerSum = sumUpPowersOf(splittedValues);

			final boolean powerSumEqualsIndex = powerSum == index;
			if (powerSumEqualsIndex) {
				result.add(powerSum);
			}
		}

        System.out.println(result);
		return result;
	}

	private List<Long> split(String values){
		List<Long> splittedValues = new ArrayList<Long>();
		for (int i = 0; i < values.length(); i++) {
			splittedValues.add(Long.valueOf(values.substring(i, i + 1)));
		}
		return splittedValues;
	}

	private long sumUpPowersOf(List<Long> values){
		long sum = 0;
		for (int i = 1; i <= values.size(); i++) {
			sum += Math.pow(values.get(i - 1), i);
		}
		return sum;
	}
}