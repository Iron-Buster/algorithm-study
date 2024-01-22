package com.fqh.动态规划.状压DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/16 21:37
 **/
public class LC_698 {

    int n;
    int avg;
    int[] a;
    Boolean[] f;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        avg = sum / k;
        a = nums;
        Arrays.sort(a);
        f = new Boolean[1<<n];
        return dfs(0,0);
    }

    public boolean dfs(int s, int t) {
        if (s == (1<<n)-1) return true;
        if (f[s] != null) return f[s];
        for (int i = 0; i < n; i++) {
            if ((s >> i & 1) == 1) continue;
            if (t + a[i] > avg) break;
            if (dfs(s|(1<<i), (t + a[i]) % avg)) {
                return f[s] = true;
            }
        }
        return f[s] = false;
    }

//    698. 划分为k个相等的子集
//            中等
//    相关标签
//            相关企业
//    提示
//    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

//    示例 1：
//
//    输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//    输出： True
//    说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
//    示例 2:
//
//    输入: nums = [1,2,3,4], k = 3
//    输出: false
}
