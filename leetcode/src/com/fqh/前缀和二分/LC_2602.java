package com.fqh.前缀和二分;

import com.fqh.BisectTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/16 15:25
 * @Version V1.0
 */
public class LC_2602 {

//    2602. 使数组元素全部相等的最少操作次数
//            已解答
//    第 338 场周赛
//            Q3
//1903
//    相关标签
//            相关企业
//    提示
//    给你一个正整数数组 nums 。
//
//    同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任意 次：
//
//    将数组里一个元素 增大 或者 减小 1 。
//    请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。
//
//    注意，每次查询后，数组变回最开始的值。
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        var preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        var ans = new ArrayList<Long>();
        for (int x : queries) {
            int i = bisectRight(nums, x);
            long left = (long) x * i - preSum[i];
            long right = preSum[n] - preSum[i] - (long) x * (n - i);
            ans.add(left + right);
        }
        return ans;
    }

    /**
     * 返回 `target` 在 `a` 中最右边的插入位置。
     * 存在多个相同的值时，返回最右边的位置。
     * @param a         一维数组
     * @param target    搜索的值
     * @return
     */
    public static int bisectRight(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
