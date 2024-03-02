package com.fqh.hot100;

import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 17:43
 **/
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (int x : nums) {
            if (set.contains(x)) return x;
            set.add(x);
        }
        return 0;
    }
}
