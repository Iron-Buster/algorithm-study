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
    boolean[][] f = new boolean[17][1<<17];
    List<Integer> states = new ArrayList<>(); // 存储合法的状态
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int avg = sum / k; // 组数
        for (int s = 0; s < (1<<n); s++) { // 枚举集合s
            int v = 0;
            for (int j = 0; j < n; j++) {
                if ((s >> j & 1) == 1) {
                    v += nums[j];
                }
            }
            // 如果当前选法可以满足这一组的和为avg，则为合法状态
            if (v == avg) states.add(s);
        }
        f[0][0] = true;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < (1<<n); j++) {
                for (int state : states) {
                    if ((j & state) == 1) continue; // 有数字被重复选取
                    f[i][j | state] = f[i-1][j] | f[i][j | state];
                }
            }
        }
        return f[k][(1<<n)-1];
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
