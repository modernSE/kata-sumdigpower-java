package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

// SumDigPower is somewhat unclear (1. what is a Dig, 2. what does the class do?)
public class SumDigPower {

	// computeList is too generic
	// maxLength instead of last in range is good; leaves fewer possibilities for
	// misinterpretation
	// ^ has nothing to do with lenght?
	public List<Long> computeList(long startIndex, long maxLength) {

		List<Long> resultList = new ArrayList<Long>();
		SumBuilder sumBuilder = new SumBuilder();

		for (long i = startIndex; i < maxLength; i++) {
			// numericValue is a String?
			String numericValue = Long.toString(i);

			// inline comments could have been remove
			// Create sum
			long resultItem = sumBuilder.calculate(numericValue);

			// Test if sum is equal
			if (isEqual(i, resultItem)) {
				resultList.add(resultItem);
			}

		}

		return resultList;
	}

	// expected/actual naming doesn't fit to the context
	// this extraction is pretty much useless
	private boolean isEqual(long expected, long actual) {
		return expected == actual;
	}

}