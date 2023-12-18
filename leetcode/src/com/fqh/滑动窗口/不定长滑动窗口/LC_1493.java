package com.fqh.滑动窗口.不定长滑动窗口;

/**
 * @Author: vq
 * @Date: 2023/12/18 17:53
 * @Version V1.0
 */
public class LC_1493 {

//    1493. 删掉一个元素以后全为 1 的最长子数组
//    第 29 场双周赛
//            Q3
//1423
//    相关标签
//            相关企业
//    提示
//    给你一个二进制数组 nums ，你需要从中删掉一个元素。
//
//    请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
//
//    如果不存在这样的子数组，请返回 0 。

    // 只能删除一个0，然后求这个区间1的个数最多（可以使用滑动窗口求解）
    // 用一个变量统计窗口内0的个数，当cnt0 > 1时，缩小窗口
    // 当前最长的只包含 1 的非空子数组的长度 = i - j + 1 - cnt0
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int cnt0 = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt0 += nums[i] == 0 ? 1 : 0;
            while (cnt0 > 1) {
                cnt0 -= nums[j] == 0 ? 1 : 0;
                j++;
            }
            ans = Math.max(ans, i - j + 1 - cnt0);
        }
        return ans == nums.length ? ans - 1 : ans;
    }
}
