package com.fqh.滑动窗口.组合单调队列;

import java.util.ArrayDeque;

/**
 * @Author: vq
 * @Date: 2023/12/18 18:37
 * @Version V1.0
 */
public class LC_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        var q = new ArrayDeque<Integer>();
        var ans = new int[n];
        for (int i = 0; i < nums.length; i++) {
            while (q.size() > 0 && nums[q.peekLast()] <= nums[i]) {
                q.pollLast(); // 移除队列中比新元素小的队尾元素
            }
            q.addLast(i);
            if (i >= k-1) {
                while (q.size() > 0 && q.peekFirst() < i-k+1) {
                    q.pollFirst();  // 移除下标不在窗口范围内的队头元素
                }
                ans[i-k+1] = nums[q.peekFirst()];
            }
        }
        return ans;
    }

//    239. 滑动窗口最大值
//            已解答
//    困难
//            相关标签
//    相关企业
//            提示
//    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//    返回 滑动窗口中的最大值
}
