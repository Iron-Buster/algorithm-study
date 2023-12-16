package com.fqh.前缀和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/16 15:11
 * @Version V1.0
 */
public class LC_2615 {

//    2615. 等值距离和
//            已解答
//    第 340 场周赛
//            Q2
//1793
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。
//
//    返回数组 arr 。


    public long[] distance(int[] nums) {
        int n = nums.length;
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], v -> new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        var ans = new long[n];
        for (List<Integer> list : map.values()) {
            int len = list.size();
            var preSum = new long[len + 1];
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + list.get(i);
            }
            for (int i = 0; i < len; i++) {
                int idx = list.get(i);
                long left = (long) i * idx - preSum[i];                        // 左边与idx等值的距离和
                long right = preSum[len] - preSum[i] - (long) (len - i) * idx; // 右边与idx等值的距离和
                ans[idx] = left + right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 2};
        System.out.println(Arrays.toString(new LC_2615().distance(nums)));
    }
}
