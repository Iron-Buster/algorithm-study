package com.fqh.单调栈.单调栈求贡献;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 15:38
 **/
public class LC_1063 {
//        1063. 有效子数组的数目
//            困难
//    相关标签
//            相关企业
//    提示
//    给定一个整数数组 nums ，返回满足下面条件的 非空、连续 子数组的数目：
//
//    子数组 是数组的 连续 部分。
//    子数组最左边的元素不大于子数组中的其他元素 。
//
//
//    示例 1：
//
//    输入：nums = [1,4,2,5,3]
//    输出：11
//    解释：有 11 个有效子数组，分别是：[1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3] 。
//    示例 2：
//
//    输入：nums = [3,2,1]
//    输出：3
//    解释：有 3 个有效子数组，分别是：[3],[2],[1] 。
//    示例 3：
//
//    输入：nums = [2,2,2]
//    输出：6
//    解释：有 6 个有效子数组，分别为是：[2],[2],[2],[2,2],[2,2],[2,2,2]
    public int validSubarrays(int[] nums) {
        // 枚举nums[i]，单调栈求出nums[i]作为最小值能够到达的最远下标
        int n = nums.length;
        int ans = 0;
        var stk = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                ans += i - stk.pop();
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            ans += n - stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,4,2,5,3};
        System.out.println(new LC_1063().validSubarrays(a));
    }
}
