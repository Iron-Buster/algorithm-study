package com.fqh.位运算.AND;

import java.util.ArrayList;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/19 23:43
 **/
public class LC_1521 {



//    https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/description/

    public int closestToTarget(int[] arr, int target) {
        int res = f(arr, target);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int f(int[] nums, int target) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        ArrayList<int[]> ors = new ArrayList<>(); // 按位与的值 + 对应子数组的右端点的最小值
        for (int i = n - 1; i >= 0; i--) {
            ors.add(new int[]{nums[i], i});
            int k = 0;
            ans = Math.min(ans, Math.abs(nums[i] - target));
            for (int[] or : ors) {
                or[0] &= nums[i];
                if (ors.get(k)[0] == or[0]) {
                    ors.get(k)[1] = or[1];  // 合并相同值，下标取最小的
                } else {
                    ors.set(++k, or);
                }
                ans = Math.min(ans, Math.abs(or[0] - target));

            }
            ors.subList(k + 1, ors.size()).clear();
            // 本题只用到了 ors[0]，如果题目改成任意给定数值，可以在 ors 中查找
        }
        return ans;
    }
}
