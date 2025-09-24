package de.cas.mse.exercise;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SumDigPower {

	public List<Long> sumDigPow(long startInclusive, long endExclusive) {
		return LongStream
			.range(startInclusive, endExclusive)
			.filter(this::isEureka)
			.boxed()
			.toList();
	}

	boolean isEureka(Long candidate) {
		var sumOfConsecutivePowers = Number.of(candidate)
			.streamDigits()
			.mapToDouble(digit -> Math.pow(digit.asInt(), digit.position()))
			.sum();

		return candidate == sumOfConsecutivePowers;
	}

	record Number(String number){
		static Number of(Long num){
			return new Number(num.toString());
		}

		Digit digitAt(Integer index){
			var digitAsChar = number.charAt(index);
			var digitAsString = Character.toString(digitAsChar);
			return new Digit(Integer.valueOf(digitAsString), index + 1);
		}

		Stream<Digit> streamDigits() {
			return IntStream.range(0, number.length())
				.mapToObj(this::digitAt);
		}
	}

	record Digit(Integer asInt, Integer position){}
}