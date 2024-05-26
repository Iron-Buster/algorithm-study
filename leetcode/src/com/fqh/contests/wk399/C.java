package com.fqh.contests.wk399;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/26 11:49
 **/
public class C {

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int x : nums2) map.merge(x, 1, Integer::sum);
        long ans = 0;
        for (int num : nums1) {
            if (num % k != 0) continue;
            int target = num / k;
            for (int fac = 1; fac <= Math.sqrt(target); fac++) {
                if (target % fac == 0) {
                    ans += map.getOrDefault(fac, 0);
                    int fac2 = target / fac;
                    if (fac2 != fac) ans += map.getOrDefault(fac2, 0);
                }
            }
        }
        return ans;
    }
}
