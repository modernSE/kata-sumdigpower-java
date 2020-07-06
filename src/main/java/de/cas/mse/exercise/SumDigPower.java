package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class SumDigPower {

	public List<Long> sumDigPow(long lowerBound, long upperBound) {

		List<Long> result = new ArrayList<Long>();

		for (long number = lowerBound; number < upperBound; number++) {	
			List<Long> digits = getDigits(number);
			long sum = createSum(digits);
			if (sum == number) {
				result.add(sum);
			}
		}
		return result;

	}

    private long createSum(List<Long> digits) {
        long sum = 0;
        for (int index = 0; index < digits.size(); index++) {
        	sum += Math.pow(digits.get(index), index+1);
        }
        return sum;
    }

    private List<Long> getDigits(Long number) {
        String[] digits = Long.toString(number).split("");
        return Arrays.stream(digits) //
            .map(Long::valueOf) //
            .collect(Collectors.toList());
    }

}