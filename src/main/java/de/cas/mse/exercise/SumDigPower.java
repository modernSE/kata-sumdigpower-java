package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long rangeStart, long rangeEnd) {

		List<Long> result = new ArrayList<Long>();

		for (long currentNumber = rangeStart; currentNumber < rangeEnd; currentNumber++) {
            if (checkNumber(currentNumber)) {
				result.add(currentNumber);
			}
		}
        System.out.println(result);
		return result;
    }
    
    private boolean checkNumber(Long numberToCheck) {
        List<Long> digits = splitNumberIntoDigits(Long.toString(numberToCheck));        
        
        return calculateSumDigPower(digits) == numberToCheck;
    }

    private List<Long> splitNumberIntoDigits(String currentNumber) {
        List<Long> digits = new ArrayList<>();
        for (int digitIndex = 0; digitIndex < currentNumber.length(); digitIndex++) {
            digits.add(Long.valueOf(currentNumber.substring(digitIndex, digitIndex + 1)));
        }
        return digits;
    }

    private long calculateSumDigPower(List<Long> digits) {
        long sum = 0;
        for (int digitIndex = 1; digitIndex <= digits.size(); digitIndex++) {
            sum += Math.pow(digits.get(digitIndex - 1), digitIndex);
        }
        return sum;
    }

}