package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 18:22
 **/
public class LC_2832 {

//    2832. 每个元素为最大值的最大范围
//            中等
//    相关标签
//            相关企业
//    提示
//    现给定一个由 不同 整数构成的 0 索引数组 nums 。
//
//    我们用以下方式定义与 nums 长度相同的 0 索引数组 ans ：
//
//    ans[i] 是子数组 nums[l..r] 的 最大 长度，该子数组中的最大元素等于 nums[i] 。
//    返回数组 ans 。
//
//    注意，子数组 是数组的连续部分。

    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            ans[i] = r - l - 1;
        }
        return ans;
    }

}
