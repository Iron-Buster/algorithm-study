package com.fqh.前缀和.前缀和二分;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/7 17:32
 **/
public class LC_1838 {

    // 枚举最后哪个数成为了最高频元素
    // 排序，然后计算前缀和
    // 对于每个nums[i]，二分找出一个最远端的left，可以满足将 [left, i]这段在k次操作全部增加到nums[i]
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 二分找一个最优的left
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r >> 1;
                int need = nums[i] * (i - mid + 1) - (s[i+1] - s[mid]);
                if (need <= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }

//    1838. 最高频元素的频数
//            已解答
//    第 238 场周赛
//            Q2
//1876
//    相关标签
//            相关企业
//    提示
//    元素的 频数 是该元素在一个数组中出现的次数。
//
//    给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
//
//    执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
}
