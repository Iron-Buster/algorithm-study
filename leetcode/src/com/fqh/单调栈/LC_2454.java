package com.fqh.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 17:43
 **/
public class LC_2454 {

//    2454. 下一个更大元素 IV
//    第 90 场双周赛
//            Q4
//    2175
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。
//
//    如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：
//
//    j > i
//    nums[j] > nums[i]
//    恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
//    如果不存在 nums[j] ，那么第二大整数为 -1 。

    public int[] secondGreaterElement(int[] nums) {
        return kthGreaterElement(nums, 2);
    }

    public static int[] kthGreaterElement(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        ArrayDeque<Integer>[] stks = new ArrayDeque[k];
        Arrays.setAll(stks, v -> new ArrayDeque<Integer>());
        ArrayDeque<Integer> tmp = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 从最后一个单调栈开始处理
            for (int j = k - 1; j >= 0; j--) {
                while (!stks[j].isEmpty() && nums[stks[j].peekLast()] < nums[i]) { // 严格大于
                    int top = stks[j].pollLast();
                    if (j == k - 1) {
                        res[top] = nums[i];
                    } else {
                        tmp.addLast(top);
                    }
                }
                if (j + 1 < k) {
                    // 倒序进入下一个单调栈，保证所有单调栈的单调性
                    while (!tmp.isEmpty()) {
                        stks[j + 1].addLast(tmp.pollLast());
                    }
                }
            }
            stks[0].addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC_2454().secondGreaterElement(new int[]{1, 17, 18, 0, 18, 10, 20, 0})));
    }
}
