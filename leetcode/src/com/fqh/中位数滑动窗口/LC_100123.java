package com.fqh.中位数滑动窗口;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/17 15:09
 * @Version V1.0
 */
public class LC_100123 {

//    100123. 执行操作使频率分数最大
//            困难
//    相关企业
//            提示
//    给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
//
//    你可以对数组执行 至多 k 次操作：
//
//    从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。
//    最终数组的频率分数定义为数组中众数的 频率 。
//
//    请你返回你可以得到的 最大 频率分数。
//
//    众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。
//
//
//
//    示例 1：
//
//    输入：nums = [1,2,6,4], k = 3
//    输出：3
//    解释：我们可以对数组执行以下操作：
//            - 选择 i = 0 ，将 nums[0] 增加 1 。得到数组 [2,2,6,4] 。
//            - 选择 i = 3 ，将 nums[3] 减少 1 ，得到数组 [2,2,6,3] 。
//            - 选择 i = 3 ，将 nums[3] 减少 1 ，得到数组 [2,2,6,2] 。
//    元素 2 是最终数组中的众数，出现了 3 次，所以频率分数为 3 。
//            3 是所有可行方案里的最大频率分数。
    // 中位数滑动窗口

    // 计算将区间[l, r]变位中位数nums[i]的操作次数
    public long calc(long[] sum, int[] nums, int r, int l, int i) {
        long left = (long) nums[i] * (i - l) - (sum[i] - sum[l]);        // 左边操作次数
        long right = sum[r + 1] - sum[i + 1] - (long) nums[i] * (r - i); // 右边操作次数
        return left + right;
    }

    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0, j = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1;
//            while (calc(sum, nums, i, j, (j + i) / 2) > k) {
//                j++;
//            }
//            ans = Math.max(ans, i - j + 1);

            while (l < r) {
                int m = (l + r + 1) >> 1;
                int mid = (m + i) / 2;
                long left = (long) nums[mid] * (mid - i + 1) - (sum[mid + 1] - sum[i]);
                long right = sum[m + 1] - sum[mid + 1] - (long) nums[mid] * (m - mid);
                if (left + right > k) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            ans = Math.max(ans, l - i + 1);
        }
        return ans;
    }
}
