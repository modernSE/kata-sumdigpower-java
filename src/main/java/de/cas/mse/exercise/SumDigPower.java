package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findEurekaNumbersBetween(Long lowerBound, Long upperBound) {

		var result = new ArrayList<Long>();

		for (var i = lowerBound; i < upperBound; i++) {

			var numberAsString = Long.toString(i);
			var values = splitValues(numberAsString);

			long eurekaOfValues = calculateEureka(values);

			if (eurekaOfValues == i) result.add(eurekaOfValues);
		}

        System.out.println(result);
		return result;

	}

	private List<Long> splitValues(String input){
		var ret = new ArrayList<Long>();
		for (var i = 0; i < input.length(); i++) {
			var currentValue = Long.valueOf(input.substring(i, i + 1));
			ret.add(currentValue);
		}

		return ret;
	}

	private Long calculateEureka(List<Long> input){
		long sum = 0;
		for (var i = 0; i < input.size(); i++) {
			var powerOf = i + 1;
			sum += Math.pow(input.get(i), powerOf);
		}
		return sum;
	}
}