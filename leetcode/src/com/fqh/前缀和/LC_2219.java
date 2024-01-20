package com.fqh.前缀和;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 15:29
 **/
public class LC_2219 {

//    2219. 数组的最大总分
//            中等
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums ，数组长度为 n 。
//
//    nums 在下标 i （0 <= i < n）处的 总分 等于下面两个分数中的 最大值 ：
//
//    nums 前 i + 1 个元素的总和
//    nums 后 n - i 个元素的总和
//    返回数组 nums 在任一下标处能取得的 最大总分 。
//
//
//
//    示例 1：
//
//    输入：nums = [4,3,-2,5]
//    输出：10
//    解释：
//    下标 0 处的最大总分是 max(4, 4 + 3 + -2 + 5) = max(4, 10) = 10 。
//    下标 1 处的最大总分是 max(4 + 3, 3 + -2 + 5) = max(7, 6) = 7 。
//    下标 2 处的最大总分是 max(4 + 3 + -2, -2 + 5) = max(5, 3) = 5 。
//    下标 3 处的最大总分是 max(4 + 3 + -2 + 5, 5) = max(10, 5) = 10 。
//    nums 可取得的最大总分是 10 。
    public long maximumSumScore(int[] nums) {
        int n = nums.length;
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + nums[i];
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(s[i+1], s[n] - s[i]));
        }
        return ans;
    }
}
