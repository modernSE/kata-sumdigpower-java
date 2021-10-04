package de.cas.mse.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestSumDigPower {

	private SumDigPower sumDigPower;

	@Before
	public void setup() {
		sumDigPower = new SumDigPower();
	}

	@Test
	public void tenTo150_contains89and135() {
		assertThat(sumDigPower.sumDigPow(10L, 150L)).containsExactly(89L, 135L);
	}

	@Test
	public void ninetyTo100_isEmpty() {
		assertThat(sumDigPower.sumDigPow(90L, 100L)).isEmpty();
	}

	@Test
	public void zeroTo100_firstTenNumbersAnd89ShoudBeContained() {
		assertThat(sumDigPower.sumDigPow(1L, 100L)).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 89L);
	}

	@Test
	public void tenTo100_only89Contained() {
		assertThat(sumDigPower.sumDigPow(10L, 100L)).containsExactly(89L);
	}

	@Test
	public void firstTenNumbers_shouldBeAllContained() {
		assertThat(sumDigPower.sumDigPow(1L, 10L)).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
	}
}
