package com.fqh.动态规划.单调队列优化;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/7 17:39
 **/
public class LC_1425 {

//    1425. 带限制的子序列和
//    第 186 场周赛
//            Q4
//    2032
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：
//    子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
//
//    数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
//
//
//
//    示例 1：
//
//    输入：nums = [10,2,-10,5,20], k = 2
//    输出：37
//    解释：子序列为 [10, 2, 5, 20] 。

    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] w = new int[n+1];
        int[] f = new int[n+1];
        int[] q = new int[n+1];
        for (int i = 0; i < n; i++) w[i+1] = nums[i];
        int h = 1, t = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            while (h <= t && f[q[t]] <= f[i-1]) t--;
            q[++t] = i - 1;
            if (q[h] < i - k) h++;
            f[i] = f[q[h]] + w[i];
            if (i > n - k) ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
