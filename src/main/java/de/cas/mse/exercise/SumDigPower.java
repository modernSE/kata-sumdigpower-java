package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SumDigPower {

	//rename start and end to rangeStart and rangeEnd
	// or something suitable for a Range like lowerBound and UpperBound
	public List<Long> sumDigPow(long start, long end) {
		
		List<Long> eurekaNumbersInRange = new ArrayList<>();
		//rename i because i is not an index in this case --> maybe currentNumber?
		for (long i = start; i < end; i++) {
			List<Long> listOfDigits = splitNumberToDigits(i);
			long sum = createSumWithPowOfDigitIndexInList(listOfDigits);
			
			if (isEurekaNumber(sum, i)) {
				eurekaNumbersInRange.add(sum);
			}
		}
		
		return eurekaNumbersInRange;
	}
	
	private boolean isEurekaNumber(long sum, long number) {
		//why should we use Objects.equals instead of sum == number?
		//number are primitive types...
		return Objects.equals(sum,number);
	}
	
	//rename method to more simple name, because if you write this class, you know how to calculate 
	//this sum, so that long method name could irritate you
	private long createSumWithPowOfDigitIndexInList(List<Long> listOfDigits) {
		long sum = 0;
		for (int digit = 1; digit <= listOfDigits.size(); digit++) {
			sum += Math.pow(listOfDigits.get(digit - 1), digit);
		}
		return sum;
	}

	private List<Long> splitNumberToDigits(Long number) { // rename to splitToDigits? 
		List<Long> digits = new ArrayList<>();
		String numberAsString = Long.toString(number);
		for (int i = 0; i < numberAsString.length(); i++) {
			//extract List<Long> digits = new ArrayList<>(); to variable
			digits.add(Long.valueOf(numberAsString.substring(i, i + 1))); // extract to local variable; e.g. long currentDigit= ...
		}
		return digits;
	}

}