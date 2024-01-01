package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 15:47
 **/
public class LC_1793 {
    // 对于每一个nums[i]
    // 用单调栈求出nums[i]能够作为最小值的最长区间 [L,R]
    // 然后枚举每一个nums[i]作为 min(nums[i:j])的答案，取一个最大的
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            if (l + 1 > k || r - 1 < k) continue; // 非法区间
            ans = Math.max(ans, nums[i] * (r - l - 1));
        }
        return ans;
    }


//    1793. 好子数组的最大分数
//    第 232 场周赛
//            Q4
//1946
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
//
//    一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
//
//    请你返回 好 子数组的最大可能 分数 。
//
//
//
//    示例 1：
//
//    输入：nums = [1,4,3,7,4,5], k = 3
//    输出：15
//    解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
    public static void main(String[] args) {
        int[] a = {1, 4, 3, 7, 4, 5};
        int k = 3;
        System.out.println(new LC_1793().maximumScore(a, k));
    }
}
