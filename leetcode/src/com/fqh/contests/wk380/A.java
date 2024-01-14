package com.fqh.contests.wk380;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 23:38
 **/
public class A {

    public int maxFrequencyElements(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int mx = 0;
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
            mx = Math.max(mx, map.get(x));
        }
        int ans = 0;
        for (int x : nums) {
            if (map.get(x) == mx) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
