package nju.ics.lixiaofan.algorithm;

import java.util.*;

/**
 * Created by Leslie on 2016/8/14.
 * Design a data structure that supports all following operations in average O(1) time.

 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 */
public class InsertDeleteGetRandomO1WithDuplicates {
    private Map<Integer, Set<Integer>> val2Idx;
    private List<Integer> vals;
    private Random random;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1WithDuplicates() {
        val2Idx = new HashMap<>();
        vals = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean nonexist;
        if(!val2Idx.containsKey(val)){
            nonexist = true;
            val2Idx.put(val, new HashSet<>());
        }
        else
            nonexist = false;
        val2Idx.get(val).add(vals.size());
        vals.add(val);

        return nonexist;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!val2Idx.containsKey(val))
            return false;
        Set<Integer> set = val2Idx.get(val);
        int idx = set.iterator().next();
            set.remove(idx);
        if(set.isEmpty())
            val2Idx.remove(val);

        int lastIdx = vals.size() - 1;
        if(idx < lastIdx){
            set = val2Idx.get(vals.get(lastIdx));
            set.remove(lastIdx);
            set.add(idx);

            vals.set(idx, vals.get(lastIdx));
        }
        vals.remove(lastIdx);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}
