package com.fqh.滑动窗口.不定长滑动窗口.求子数组个数;

/**
 * @Author: vq
 * @Date: 2023/12/21 11:02
 * @Version V1.0
 */
public class LC_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, j = 0;
        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            mul *= nums[i];
            while (j <= i && mul >= k) {
                mul /= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }


//    713. 乘积小于 K 的子数组
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
//
//
//    示例 1：
//
//    输入：nums = [10,5,2,6], k = 100
//    输出：8
//    解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
//    需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组
}
