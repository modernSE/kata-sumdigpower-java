package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> getEurekaNumbers(long intervalStart, long intervalEnd) {

		List<Long> eurekaNumbers = new ArrayList<Long>();

		for (long currentNumber = intervalStart; currentNumber < intervalEnd; currentNumber++) {

			List<Long> digits = splitInDigits(currentNumber);

			long sum = sumExponents(digits);

			if (sum == currentNumber) {
				eurekaNumbers.add(sum);
			}

		}

        System.out.println(eurekaNumbers);
		return eurekaNumbers;
	}

    private List<Long> splitInDigits(long currentNumber) {
        List<Long> digits = new ArrayList<Long>();

        String currentNumberAsString = Long.toString(currentNumber);

        for (int j = 0; j < currentNumberAsString.length(); j++) {
        	digits.add(Long.valueOf(currentNumberAsString.substring(j, j + 1)));
        }
        return digits;
    }

    private long sumExponents(List<Long> digits) {
        long sum = 0;
        for (int power = 1; power <= digits.size(); power++) {
            int index = power - 1;
        	sum += Math.pow(digits.get(index), power);
        }
        return sum;
    }

}