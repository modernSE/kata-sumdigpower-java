package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

// Class name anpassen um zu wissen was die Klasse macht
public class SumDigPower {

	// vielleicht auch mit kürzerem Namen möglich
	public List<Long> findNumbersWithSumOfDigitPowersEqualsNumber(long startNumber, long endNumber) {
		List<Long> results = new ArrayList<Long>();
		
		// auslagern in Methode: checkCandidate o.Ä.?
		for (long currentNumber = startNumber; currentNumber < endNumber; currentNumber++) {
			List<Long> digitsOfNumber = splitValues(currentNumber);
			long sum = sumOfDigitPowers(digitsOfNumber);
	
			if (sum == currentNumber) {
				results.add(sum);
			}
		}
		return results;
	}
	
	//Einzahl?
	List<Long> splitValues(long numberToSplit) {
		List<Long> digitsOfNumber = new ArrayList<Long>();
		String  stringOfNumber = Long.toString(numberToSplit);
		
		// i statt j?
		for (int j = 0; j < stringOfNumber.length(); j++) {
			digitsOfNumber.add(Long.valueOf(stringOfNumber.substring(j, j + 1)));
		}
		return digitsOfNumber;
	}
	
	
	long sumOfDigitPowers (List<Long> digitsOfNumber) {
		// sum statt result?
		long result = 0; 
		
		// i statt j
		for (int j = 0; j <= digitsOfNumber.size() -1; j++) {
			result += Math.pow(digitsOfNumber.get(j), j+1);
		}
		return result; 
	}

}