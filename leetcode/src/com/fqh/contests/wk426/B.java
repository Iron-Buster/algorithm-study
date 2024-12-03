package com.fqh.contests.wk426;

import java.util.Arrays;
import java.util.HashMap;

public class B {

    public int getLargestOutlier(int[] nums) {
        int s = Arrays.stream(nums).sum();
        var map = new HashMap<Integer, Integer>();
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
        }
        int ans = -1001;
        for (int i = mx; i >= -mn; i--) {
            if (!map.containsKey(i)) {
                continue;
            }
            for (int j = mx; j >= -mn; j--) {
                if (!map.containsKey(j) || (i == j && map.get(i) == 1)) {
                    continue;
                }
                if (s - i > j) break;
                int v = s - i - j;
                if (v == j) {
                    ans = Math.max(ans, i);
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 10};

    }
}
