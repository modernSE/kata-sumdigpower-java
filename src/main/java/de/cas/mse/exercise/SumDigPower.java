package de.cas.mse.exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SumDigPower {

	public List<Long> sumDigPow(long start, long end) {
		return LongStream.rangeClosed(start, end)
				.flatMap(this::numberIsSumOfItsDigitsPairwisePowers)
				.mapToObj(Long::valueOf)
				.collect(Collectors.toList());
	}

	private LongStream numberIsSumOfItsDigitsPairwisePowers(Long number) {
		List<Integer> digits = extractDigits(number.toString());
		long sumOfPairwisePowers = sumDigitsPairwisePowers(digits);
		if (sumOfPairwisePowers == number) {
			return LongStream.of(number);
		} else {
			return LongStream.empty();
		}
	}

	private long sumDigitsPairwisePowers(List<Integer> digits) {
		long sum = 0;
		for (int j = 1; j <= digits.size(); j++) {
			sum += Math.pow(digits.get(j - 1), j);
		}
		return sum;
	}

	private List<Integer> extractDigits(String completeNumber) {
		return completeNumber.chars()
				.mapToObj(it -> Character.toString((char) it))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
	}

}