package com.fqh.contests.bw131;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/25 23:29
 **/
public class A {

    public int duplicateNumbersXOR(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int x : nums) map.merge(x, 1, Integer::sum);
        int ans = 0;
        for (int x : map.keySet()) {
            if (map.get(x) >= 2) ans ^= x;
        }
        return ans;
    }
}
