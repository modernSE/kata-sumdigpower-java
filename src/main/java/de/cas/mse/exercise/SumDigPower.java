package de.cas.mse.exercise;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumDigPower {

	record NumberWithDigits(long number, List<Long> digits){

		static NumberWithDigits of(long number) {
			var digits = String.valueOf(number)
				.chars()
				.mapToObj(Character::toString)
				.map(Long::valueOf)
				.toList();
				  
			return new NumberWithDigits(number, digits);
		}
	}

	public List<Long> sumDigPow(long lowerBoundInclusive, long upperBoundExclusive) {
		return LongStream.range(lowerBoundInclusive, upperBoundExclusive)
				  .mapToObj(NumberWithDigits::of)
				  .filter(this::isEurekaNumber)
				  .mapToLong(NumberWithDigits::number)
				  .boxed()
				  .toList();

	}

	private boolean isEurekaNumber(NumberWithDigits number) {
		var digits = number.digits();
		var sumOfDigitToPositionPower = IntStream.rangeClosed(1, digits.size())
			.mapToLong(pos -> (long)Math.pow(digits.get(pos - 1), pos))
			.sum();
		return sumOfDigitToPositionPower == number.number();
	}

}