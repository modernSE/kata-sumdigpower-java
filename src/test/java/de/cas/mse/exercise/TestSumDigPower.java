package de.cas.mse.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TestSumDigPower {

	private EurekaNumbers eurekaNumbers;

	@Before
	public void setup() {
		eurekaNumbers = new EurekaNumbers();
	}

	@Test
	public void shouldReturn89And135() {
		assertThat(eurekaNumbers.getEurekaNumbers(10, 150)).containsExactly(89l, 135l);
	}

	@Test
	public void shouldReturnNoValues() {
		assertThat(eurekaNumbers.getEurekaNumbers(90, 100)).isEmpty();
	}

	@Test
	public void shouldReturnFirstTenNumbersAnd89() {
		assertThat(eurekaNumbers.getEurekaNumbers(1, 100)).containsExactly(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l, 89l);
	}

	@Test
	public void tenTo100_only89Contained() {
		assertThat(eurekaNumbers.getEurekaNumbers(10, 100)).containsExactly(89l);
	}

	@Test
	public void firstTenNumbers_shouldBeAllContained() {
		assertThat(eurekaNumbers.getEurekaNumbers(1, 10)).containsExactly(1l, 2l, 3l, 4l, 5l, 6l, 7l, 8l, 9l);
	}
}
