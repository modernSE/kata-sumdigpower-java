package de.cas.mse.exercise;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class SumDigPower {

	public List<Long> sumDigPow(Long a, Long b) {

		List<Long> result = new ArrayList<Long>();

		for (Long i = a; i < b; i++) {

			List<Long> longs = new ArrayList<Long>();

			String temp = Long.toString(i);

			// Split values
			for (Integer j = 0; j < temp.length(); j++) {
				String digitString = temp.substring(j, j + 1);
				Long digitLong = Long.valueOf(digitString);
				longs.add(digitLong);
			}

			// Create sum
			Long sum = 0L;
			for (Integer j = 1; j <= longs.size(); j++) {
				Long digit = longs.get(j - 1);
				long tempSum =  (long) (sum + Math.pow(digit, j));
				sum = Long.valueOf(tempSum);
			}

			// Test if sum is equal
			if (sum.equals(i)) {
				result.add(sum);
			}
		}

        out.println(result);
		return result;
	}

}