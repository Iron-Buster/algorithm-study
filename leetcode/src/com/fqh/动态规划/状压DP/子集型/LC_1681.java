package com.fqh.动态规划.状压DP.子集型;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 22:04
 **/
public class LC_1681 {

//    1681. 最小不兼容性
//            已解答
//    第 218 场周赛
//            Q4
//2390
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个整数 k 。你需要将这个数组划分到 k 个相同大小的子集中，使得同一个子集里面没有两个相同的元素。
//
//    一个子集的 不兼容性 是该子集里面最大值和最小值的差。
//
//    请你返回将数组分成 k 个子集后，各子集 不兼容性 的 和 的 最小值 ，如果无法分成分成 k 个子集，返回 -1 。
//
//    子集的定义是数组中一些数字的集合，对数字顺序没有要求。
//
//    示例 1：
//
//    输入：nums = [1,2,1,4], k = 2
//    输出：4
//    解释：最优的分配是 [1,2] 和 [1,4] 。
//    不兼容性和为 (2-1) + (4-1) = 4 。
//    注意到 [1,1] 和 [2,4] 可以得到更小的和，但是第一个集合有 2 个相同的元素，所以不可行。

    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return -1;
        int g = n / k;
        int[] f = new int[1<<n];
        int[] score = new int[1<<n];
        Arrays.fill(score, -1);
        // 预处理每个状态的不兼容性
        for (int s = 0; s < 1<<n; s++) {
            int mx = -1, mn = 20;
            if (Integer.bitCount(s) != g) continue;
            var set = new HashSet<Integer>();
            for (int j = 0; j < n; j++) {
                if ((s >> j & 1) == 1) {
                    if (set.contains(nums[j])) break; // 子集中不能有相同数字
                    mx = Math.max(mx, nums[j]);
                    mn = Math.min(mn, nums[j]);
                    set.add(nums[j]);
                }
            }
            if (set.size() == g) { // 合法的子集
                score[s] = mx - mn;
            }
        }
        for (int s = 0; s < 1<<n; s++) {
            f[s] = score[s] == -1 ? Integer.MAX_VALUE : score[s];
        }
        for (int s = 0; s < 1<<n; s++) {
            if (f[s] == Integer.MAX_VALUE) continue;
            var set = new HashSet<Integer>();
            int mask = 0; // s中未被选择的数字集合mask
            for (int j = 0; j < n; j++) {
                if ((s >> j & 1) == 0 && !set.contains(nums[j])) {
                    set.add(nums[j]);
                    mask |= (1<<j);
                }
            }
            if (set.size() < g) continue;
            for (int sub = mask; sub > 0; sub=(sub-1)&mask) {
                if (score[sub] != -1) {
                    f[s|sub] = Math.min(f[s|sub], f[s] + score[sub]);
                }
            }
        }
        return f[(1<<n)-1] == Integer.MAX_VALUE ? -1 : f[(1<<n)-1];
    }
}
