package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	// Kommentare müssen weg
	public List<Long> findDigPowNumbersInRange(long minNumber, long maxNumber) {

		List<Long> digPowNumbers = new ArrayList<Long>();
		for (long currentNumber = minNumber; currentNumber < maxNumber; currentNumber++) {

			List<Long> allDigitsOfCurrentNumber = getAllDigitsOfCurrentNumber(currentNumber);
			long powSum = getPowSumOfNumber(allDigitsOfCurrentNumber);

			// Test if sum is equal
			if (powSum == currentNumber) {
				digPowNumbers.add(powSum);
			}

		}
		return digPowNumbers;

	}
	// Kommentare müssen weg
	// i steht für 'index' => in der for-Schleife würden wir i stehen lassen (+ nicht konsistent mit dem Rest des Codes)
	// allDigitsOfCurrentNumber ist ein guter Name
	private long getPowSumOfNumber(List<Long> allDigitsOfCurrentNumber) {
		// Create sum 
		long sum = 0;
		for (int positionOfNumberInContainer = 0; positionOfNumberInContainer < allDigitsOfCurrentNumber.size(); positionOfNumberInContainer++) {
			Long numberToPow = allDigitsOfCurrentNumber.get(positionOfNumberInContainer);
			sum += Math.pow(numberToPow, positionOfNumberInContainer + 1);
		}
		return sum;
	}

	// Kommentare müssen weg
	// i ist kein guter Parametername
	// nextCharakterinNumber (Tippfehler + Namenkonventionen + ist kein Char) => besser wäre nextDigitInNumber
	// Worauf bezieht sich current in currentNumber? Einfach number wäre ausreichend.
	
	private List<Long> getAllDigitsOfCurrentNumber(long i) {
		List<Long> allDigitsOfCurrentNumber = new ArrayList<Long>();

		String currentNumber = Long.toString(i);

		// Split values
		for (int j = 0; j < currentNumber.length(); j++) {
			String nextCharakterinNumber = currentNumber.substring(j, j + 1);
			Long nextDigit = Long.valueOf(nextCharakterinNumber);
			allDigitsOfCurrentNumber.add(nextDigit);
		}
		return allDigitsOfCurrentNumber;
	}

}