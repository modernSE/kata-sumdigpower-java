package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> findHappyNumbersInRange(long start, long end) {

		List<Long> result = new ArrayList<Long>();

		for (long happyNumberCandidate = start; happyNumberCandidate < end; happyNumberCandidate++) {

			long sum = doHappyNumberCalculation(happyNumberCandidate);

			if (sum == happyNumberCandidate) {
				result.add(happyNumberCandidate);
			}

		}

        System.out.println(result);
		return result;

	}

    private long doHappyNumberCalculation(long happyNumberCandidate) {
        List<Integer> singleDigits = toListOfDigits(happyNumberCandidate);
        long sum = calculateSum(singleDigits);
        return sum;
    }

    private long calculateSum(List<Integer> singleDigits) {
        long sum = 0;
        for (int index = 0; index < singleDigits.size(); index++) {
            int exponent = index + 1;
        	sum += Math.pow(singleDigits.get(index), exponent);
        }
        return sum;
    }

    private List<Integer> toListOfDigits(long happyNumberCandidate) {
        List<Integer> singleDigits = new ArrayList<Integer>();

        String digitAsString = Long.toString(happyNumberCandidate);
        for(char letter : digitAsString.toCharArray()){
            singleDigits.add(toInteger(letter));
        }

        return singleDigits;
    }

    private Integer toInteger(char letter) {
        return Integer.valueOf(String.valueOf(letter));
    }

}