package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {

	public List<Long> sumDigPower(long rangeStart, long rangeEnd) {

		List<Long> numbersThatMatch = new ArrayList<Long>();

		for (long i = rangeStart; i < rangeEnd; i++) {

			
			String temp = Long.toString(i);

			List<Long> longs = extractDigits(temp);

			// Create sum
			long sum = 0;
			for (int j = 1; j <= longs.size(); j++) {
				sum += Math.pow(longs.get(j - 1), j);
			}

			// Test if sum is equal
			if (sum == i) {
				numbersThatMatch.add(sum);
			}

		}

        System.out.println(numbersThatMatch);
		return numbersThatMatch;

	}
        private List<Long> extractDigits(String temp) {
            List<Long> longs = new ArrayList<Long>();

            for (int j = 0; j < temp.length(); j++) {
				longs.add(Long.valueOf(temp.substring(j, j + 1)));
            }
            return longs;
        }
}