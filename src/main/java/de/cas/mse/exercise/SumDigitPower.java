package de.cas.mse.exercise;

// remove unused imports 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

// rename test accordingly
public class SumDigitPower {

	// finde ich gut den Namen :)
	public List<Long> findNumbersInRange(long rangeBegin, long rangeEnd) {

		List<Long> result = new ArrayList<Long>();

		// extract body of for loop to method
		for (long number = rangeBegin; number < rangeEnd; number++) {

			List<Long> digits = splitToDigits(number);

			// method name too long?
			// perfekter Name!
			long sum = sumDigitsRaisedToConsecutivePowers(digits);

			// different level of abstraction
			if (sum == number) {
				result.add(sum);
			}

		}

		return result;

	}

	private long sumDigitsRaisedToConsecutivePowers(List<Long> digits) {
		// method does two things: calculate powers and sums
		// maybe split?
		long sum = 0;
		for (int j = 0; j < digits.size(); j++) {
			int power = j + 1;
			sum += Math.pow(digits.get(j), power);
		}
		return sum;
	}

	// move method up one
	private List<Long> splitToDigits(long number) {
		List<Long> digits = new ArrayList<Long>();

		String numberAsString = Long.toString(number);

		// Comments are a bad sign -> // Split values
		for (int j = 0; j < numberAsString.length(); j++) {
			// substring can be extracted to its own method/variable
			digits.add(Long.valueOf(numberAsString.substring(j, j + 1)));
		}
		return digits;
	}

}