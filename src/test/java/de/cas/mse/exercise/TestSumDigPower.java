package de.cas.mse.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSumDigPower {

	private SumDigPower sumDigPower;

	@BeforeEach
	public void setup() {
		sumDigPower = new SumDigPower();
	}

	@Test
	public void tenTo150_contains89and135() {
		assertThat(sumDigPower.findEurekaNumbersBetween(10l, 150l)).containsExactly(89l, 135l);
	}

	@Test
	public void ninetyTo100_isEmpty() {
		assertThat(sumDigPower.findEurekaNumbersBetween(90l, 100l)).isEmpty();
	}

	@Test
	public void zeroTo100_firstTenNumbersAnd89ShoudBeContained() {
		assertThat(sumDigPower.findEurekaNumbersBetween(1l, 100l)).containsExactly(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 89l);
	}

	@Test
	public void tenTo100_only89Contained() {
		assertThat(sumDigPower.findEurekaNumbersBetween(10l, 100l)).containsExactly(89l);
	}

	@Test
	public void firstTenNumbers_shouldBeAllContained() {
		assertThat(sumDigPower.findEurekaNumbersBetween(1l, 10l)).containsExactly(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l);
	}
}
