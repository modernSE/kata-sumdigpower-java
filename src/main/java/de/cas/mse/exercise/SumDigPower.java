package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

    List<Long> eurekaList = new ArrayList<Long>();

	public List<Long> sumDigPow(long lowerLimit, long upperLimit) {

		for (long currentNumber = lowerLimit; currentNumber < upperLimit; currentNumber++) {

			List<Long> currentNumberSplitted = new ArrayList<Long>();

			String numberAsString = Long.toString(currentNumber);

			splitValues(currentNumberSplitted, numberAsString);

			long sum = createSum(currentNumberSplitted);

			addToEurekaListIfEqual(currentNumber, sum);

		}

        System.out.println(eurekaList);
		return eurekaList;

	}

    private void addToEurekaListIfEqual(long currentNumber, long sum) {
        if (sum == currentNumber) {
        	eurekaList.add(sum);
        }
    }

    private long createSum(List<Long> currentNumberSplitted) {
        long sum = 0;
        for (int j = 1; j <= currentNumberSplitted.size(); j++) {
        	sum += Math.pow(currentNumberSplitted.get(j - 1), j);
        }
        return sum;
    }

    private void splitValues(List<Long> currentNumberSplitted, String temp) {
        for (int possitionPointer = 0; possitionPointer < temp.length(); possitionPointer++) {
        	currentNumberSplitted.add(Long.valueOf(temp.substring(possitionPointer, possitionPointer + 1)));
        }
    }

}