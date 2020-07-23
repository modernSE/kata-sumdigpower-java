package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long start, long end) {

		List<Long> results = new ArrayList<Long>();

		for (long currentNumber = start; currentNumber < end; currentNumber++) {

			List<Long> splitCharacters = new ArrayList<Long>();
			String currentNumberAsString = Long.toString(currentNumber);
            
            splitNumber(splitCharacters, currentNumberAsString);
            
			long sum = 0;
			sum = createSum(splitCharacters, sum);

			// Test if sum is equal
			if (sum == currentNumber) {
				results.add(sum);
			}
		}

        System.out.println(results);
		return results;

    }

    private void splitNumber(List<Long> splitCharacters, String currentNumberAsString) {
        for (int index = 0; index < currentNumberAsString.length(); index++) {
        	splitCharacters.add(Long.valueOf(currentNumberAsString.substring(index, index + 1)));
        }
    }

    private long createSum(List<Long> splitCharacters, long sum) {
        for (int index = 0, pow; index < splitCharacters.size(); index++) {
           pow = index + 1;
            sum += Math.pow(splitCharacters.get(index), pow);
        }
        return sum;
    }
    
    // 123
    // 1^1  2^2 3^3 

}