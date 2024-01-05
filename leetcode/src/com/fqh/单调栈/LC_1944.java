package com.fqh.单调栈;

import java.util.ArrayDeque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/5 09:31
 **/
public class LC_1944 {

    // 单调栈
    public int[] canSeePersonsCount(int[] h) {
        int n = h.length;
        var stk = new ArrayDeque<Integer>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && h[stk.peek()] <= h[i]) { // 弹出小于等于当前高度的元素
                stk.pop();
                ans[i]++; // 当前位置比前面的位置高，能够看见前面高度小的人数
            }
            ans[i] += stk.isEmpty() ? 0 : 1; // 当前位置还能看见远端最高的那个人
            stk.push(i);
        }
        return ans;
    }

//    1944. 队列中可以看到的人数
//    第 57 场双周赛
//            Q4
//2105
//    相关标签
//            相关企业
//    提示
//    有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
//
//    一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
//
//    请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
}
