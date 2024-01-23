package com.fqh.动态规划;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/23 15:48
 **/
public class LC_416 {

//    416. 分割等和子集
//            中等
//    相关标签
//            相关企业
//    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//
//
//    示例 1：
//
//    输入：nums = [1,5,11,5]
//    输出：true
//    解释：数组可以分割成 [1, 5, 5] 和 [11] 。
//    示例 2：
//
//    输入：nums = [1,2,3,5]
//    输出：false
//    解释：数组不能分割成两个元素和相等的子集。

    Boolean[][] f;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int t = sum / 2;
        f = new Boolean[n][t+1];
        return dfs(0, t, nums);
    }

    public boolean dfs(int i, int v, int[] a) {
        if (i >= a.length) return v == 0;
        if (v < 0) return false;
        if (f[i][v] != null) return f[i][v];
        boolean ans = false;
        // 不选
        ans |= dfs(i + 1, v, a);
        // 选
        ans |= dfs(i + 1, v - a[i], a);
        return f[i][v] = ans;
    }
}
