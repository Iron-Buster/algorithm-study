package com.fqh.动态规划.LIS;

import java.util.ArrayList;
import java.util.List;

public class LC_300 {

    // https://leetcode.cn/problems/longest-increasing-subsequence/description/

    // O(n^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    // O（NlogN）
    public int lengthOfLIS2(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int x : nums) {
            int j = lowerBound(g, x);
            if (j == g.size()) {
                g.add(x); // >=x 的 g[j] 不存在
            } else {
                g.set(j, x);
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
