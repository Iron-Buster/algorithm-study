package com.fqh.中位数贪心;

import com.fqh.BisectTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/17 14:13
 * @Version V1.0
 */
public class LC_100151 {

//    100151. 使数组成为等数数组的最小代价
//            中等
//    相关企业
//            提示
//    给你一个长度为 n 下标从 0 开始的整数数组 nums 。
//
//    你可以对 nums 执行特殊操作 任意次 （也可以 0 次）。每一次特殊操作中，你需要 按顺序 执行以下步骤：
//
//    从范围 [0, n - 1] 里选择一个下标 i 和一个 正 整数 x 。
//    将 |nums[i] - x| 添加到总代价里。
//    将 nums[i] 变为 x 。
//    如果一个正整数正着读和反着读都相同，那么我们称这个数是 回文数 。比方说，121 ，2552 和 65756 都是回文数，但是 24 ，46 ，235 都不是回文数。
//
//    如果一个数组中的所有元素都等于一个整数 y ，且 y 是一个小于 109 的 回文数 ，那么我们称这个数组是一个 等数数组 。
//
//    请你返回一个整数，表示执行任意次特殊操作后使 nums 成为 等数数组 的 最小 总代价。


    // 中位数贪心
    static List<Integer> pal = new ArrayList<>();
    static int base = 1;
    static boolean ok = false;

    // 按顺序从小到大生成所有回文数（不用字符串转换）
    static void f() {
        if (ok) return;
        while (base <= 10000) {
            for (int i = base; i <= base * 10; i++) {
                int x = i;
                int t = i / 10;
                while (t > 0) {
                    x = x * 10 + t % 10;
                    t /= 10;
                }
                pal.add(x);
            }
            if (base <= 1000) {
                for (int i = base; i <= base * 10; i++) {
                    int x = i, t = i;
                    while (t > 0) {
                        x = x * 10 + t % 10;
                        t /= 10;
                    }
                    pal.add(x);
                }
            }
            base *= 10;
        }
        pal.add((int) (1e9 + 1));
        ok = true;
    }
    static {
        f();
    }

    // 返回nums[i] 变成pal[i]的总代价
    public long cost(int i, int[] a) {
        int target = pal.get(i);
        long sum = 0;
        for (int x : a) {
            sum += Math.abs(x - target);
        }
        return sum;
    }

    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int idx = bisectRight2(pal, nums[(n - 1) / 2]); // 二分找离中位数最近的回文数
        if (pal.get(idx) <= nums[n / 2]) {              // 回文数在中位数范围内
            return cost(idx, nums);                     // 直接变成 pal[i]
        }
        return Math.min(cost(idx - 1, nums), cost(idx, nums)); // 枚举离中位数最近的两个回文数 pal[i-1] 和 pal[i]
    }

    /**
     * 返回 `target` 在 `a` 中最左边的插入位置。
     * 存在多个相同的值时，返回最左边的位置。
     * @param a         list集合
     * @param target    搜索的值
     * @return
     */
    public static int bisectLeft2(List<Integer> a, int target) {
        int left = 0, right = a.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 返回 `target` 在 `a` 中最右边的插入位置。
     * 存在多个相同的值时，返回最右边的位置。
     * @param a         list集合
     * @param target    搜索的值
     * @return
     */
    public static int bisectRight2(List<Integer> a, long target) {
        int left = 0, right = a.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
