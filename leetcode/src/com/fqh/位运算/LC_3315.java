package com.fqh.位运算;

import java.util.Arrays;
import java.util.List;

public class LC_3315 {

    // https://leetcode.cn/problems/construct-the-minimum-bitwise-array-ii/description/
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            int t = nums.get(i);
            if (t <= 2) continue;
            int v = 0;
            for (int j = 0; j < 31; j++) {
                if ((t >> j & 1) == 1) {
                    v = j;
                } else {
                    break;
                }
            }
            ans[i] = t - (1<<v);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 0100
        // 0101
        System.out.println(Integer.toBinaryString(5));
    }
}
