package com.fqh.分组循环;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/17 13:56
 * @Version V1.0
 */
public class LC_100161 {


//    100161. 划分数组并满足最大差限制
//            中等
//    相关企业
//            提示
//    给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
//
//    将这个数组划分为一个或多个长度为 3 的子数组，并满足以下条件：
//
//    nums 中的 每个 元素都必须 恰好 存在于某个子数组中。
//    子数组中 任意 两个元素的差必须小于或等于 k 。
//    返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。

    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n / 3][3];
        int idx = 0;
        for (int i = 2; i < n; i += 3) {
            int mx = Math.max(nums[i], Math.max(nums[i - 1], nums[i - 2]));
            int mn = Math.min(nums[i], Math.min(nums[i - 1], nums[i - 2]));
            if (mx - mn > k) return new int[0][0];
            ans[idx++] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }
        return ans;
    }
}
