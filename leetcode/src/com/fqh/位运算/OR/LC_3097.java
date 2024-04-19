package com.fqh.位运算.OR;

import java.util.ArrayList;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/19 23:01
 **/
public class LC_3097 {

//    https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/description/

    public int minimumSubarrayLength2(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x >= k) return 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | x) == nums[j]) { // nums[j] | x 不会变大了
                    break;
                }
                nums[j] |= x;
                if (nums[j] >= k) {
                    ans = Math.min(ans, i - j + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int res = f(nums, k);
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public static int f(int[] nums, int V) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        ArrayList<int[]> ors = new ArrayList<>(); // 按位或的值 + 对应子数组的右端点的最小值
        for (int i = n - 1; i >= 0; i--) {
            ors.add(new int[]{0, i});
            if (nums[i] >= V) return 1;
            int k = 0;
            for (int[] or : ors) {
                or[0] |= nums[i];
                if (or[0] >= V) ans = Math.min(ans, or[1] - i + 1);  // 最短
                if (ors.get(k)[0] == or[0]) {
                    ors.get(k)[1] = or[1];  // 合并相同值，下标取最小的
                } else {
                    ors.set(++k, or);
                }
            }
            ors.subList(k + 1, ors.size()).clear();
            // 本题只用到了 ors[0]，如果题目改成任意给定数值，可以在 ors 中查找
//            ans[i] = ors.get(0)[1] - i + 1;
        }
        return ans;
    }
}
