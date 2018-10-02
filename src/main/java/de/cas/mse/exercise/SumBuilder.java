package de.cas.mse.exercise;

import java.util.ArrayList;

// nice to separate this logic into own class
public class SumBuilder {

	// this class variable is used as a local variable; better to leave it as local
	// instead methods have side effects
	private ArrayList<Long> numericList;

	public long calculate(String numericValue) {
		createEmptyList();
		splitValues(numericValue);
		return calculateSum();
	}

	// seems a little redundant (list initialization is straightforward as-is)
	private void createEmptyList() {
		numericList = new ArrayList<Long>();
	}

	// naming is clear (splitValues and numericValue)
	// split values receives just one value... naming unclear
	private void splitValues(String numericValue) {
		// starting from zero is a better common practice
		for (int i = 0; i < numericValue.length(); i++) {
			// substring could have been extracted to its own method/variable
			numericList.add(Long.valueOf(numericValue.substring(i, i + 1)));
		}
	}

	// does not only calculate sum but also power
	private long calculateSum() {
		long sum = 0;
		// could start from 0 (common practice) +1
		for (int i = 1; i <= numericList.size(); i++) {
			sum += Math.pow(numericList.get(i - 1), i);
		}
		return sum;
	}
}
