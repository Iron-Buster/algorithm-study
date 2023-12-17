package com.fqh.滑动窗口.替换k次最长连续1模型;

/**
 * @Author: vq
 * @Date: 2023/12/16 15:45
 * @Version V1.0
 */
public class LC_1004 {

//    1004. 最大连续1的个数 III
//    已解答
//    第 126 场周赛
//            Q3
//1656
//    相关标签
//            相关企业
//    提示
//    给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
    public int longestOnes(int[] nums, int k) {
        int ans = 0, maxCnt = 0;
        var map = new int[100001];
        for (int i = 0, j = 0; i < nums.length; i++) {
            map[nums[i]]++;
            if (nums[i] == 1) {
                maxCnt = Math.max(maxCnt, map[nums[i]]);
            }
            if (i - j + 1 > maxCnt + k) {
                map[nums[j]]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
