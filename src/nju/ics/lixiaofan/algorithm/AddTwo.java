package nju.ics.lixiaofan.algorithm;

import java.util.Hashtable;

public class AddTwo {
	public static int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (hashtable.containsKey(target - numbers[i])) {
				ret[0] = hashtable.get(target - numbers[i]);
				ret[1] = i + 1;
				return ret;
			} else if (!hashtable.containsKey(numbers[i]))
				hashtable.put(numbers[i], i + 1);
		}
		return null;
	}
}
