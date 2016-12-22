package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPow(long a, long b) {

		List<Long> result = new ArrayList<Long>();

		for (long i = a; i < b; i++) {

			List<Long> longs = new ArrayList<Long>();

			String temp = Long.toString(i);

			// Split values
			for (int j = 0; j < temp.length(); j++) {
				longs.add(Long.valueOf(temp.substring(j, j + 1)));
			}

			// Create sum
			long sum = 0;
			for (int j = 1; j <= longs.size(); j++) {
				sum += Math.pow(longs.get(j - 1), j);
			}

			// Test if sum is equal
			if (sum == i) {
				result.add(sum);
			}

		}

		return result;

	}

}