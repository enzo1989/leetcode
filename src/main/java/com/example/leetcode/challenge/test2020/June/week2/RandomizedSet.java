package com.example.leetcode.challenge.test2020.June.week2;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class RandomizedSet {
    public static void main(String[] args) {
        int val = 2;
        RandomizedSet obj = new RandomizedSet(1);
        boolean param_1 = obj.insertV1(val);
        boolean param_2 = obj.removeV1(val);
        int param_3 = obj.getRandomV1();
        System.out.println(param_3);
    }
    Random rand;
    List<Integer> set;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val))
            return false;
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val))
            return false;
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer number = itr.next();
            if (number == val) {
                itr.remove();
                break;
            }
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int last = set.size();
        if(last == 0)
            return -1;
        int target = set.get(rand.nextInt(last));
        return target;
    }


    /**
     * faster solution
     */
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet(int i) {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insertV1(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean removeV1(int val) {
        if(map.containsKey(val)) {
            int index = map.remove(val);
            int lastElement = list.get(list.size() - 1);
            if(lastElement != val) {
                list.set(index, lastElement);
                map.put(lastElement, index);
            }
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandomV1() {
        return list.get(random.nextInt(list.size()));
    }
}
