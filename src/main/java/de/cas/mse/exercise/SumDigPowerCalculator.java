package de.cas.mse.exercise;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumDigPowerCalculator {

	public List<Long> calculateNumbers(long lowerBound, long upperBound) {
		return LongStream.range(lowerBound, upperBound + 1)//
				.mapToObj(this::processNumber)//
				.filter(Optional::isPresent)//
				.map(Optional::get)//
				.collect(toList());
	}

	private Optional<Long> processNumber(long number) {
		long sum = Long.toString(number).chars()//
				.mapToObj(c -> String.valueOf((char) c))//
				.map(Long::valueOf)//
				.collect(collectingAndThen(toList(), this::calculatePowers))//
				.sum();
		return sum == number ? Optional.ofNullable(number) : Optional.empty();
	}

	private LongStream calculatePowers(List<Long> digits) {
		return IntStream.range(0, digits.size())//
				.mapToDouble(i -> Math.pow(digits.get(i), i + 1))//
				.mapToLong(d -> (long) d);
	}
}