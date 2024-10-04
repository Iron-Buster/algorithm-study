package com.fqh.动态规划.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_354 {

    // https://leetcode.cn/problems/russian-doll-envelopes/description/
    // 将w从小到大排序，h从大到小排序（这样遇到w相同的能保证只选1个）。
    // 这题数据范围1e5，需要套用LC300的二分优化版本的LIS。

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        return lengthOfLIS2(envelopes);
    }

    // O（NlogN）
    public int lengthOfLIS2(int[][] nums) {
        List<Integer> g = new ArrayList<>();
        for (int[] x : nums) {
            int j = lowerBound(g, x[1]);
            if (j == g.size()) {
                g.add(x[1]); // >=x 的 g[j] 不存在
            } else {
                g.set(j, x[1]);
            }
        }
        return g.size();
    }

    int lowerBound(List<Integer> g, int target) {
        int l = 0;
        int r = g.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (g.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
