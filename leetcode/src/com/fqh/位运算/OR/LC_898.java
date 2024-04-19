package com.fqh.位运算.OR;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/19 23:37
 **/
public class LC_898 {

//    https://leetcode.cn/problems/bitwise-ors-of-subarrays/description/

    public int subarrayBitwiseORs(int[] arr) {
        return f(arr);
    }

    // SubArrayOrTemplate
    public static int f(int[] nums) {
        int n = nums.length;
        ArrayList<int[]> ors = new ArrayList<>(); // 按位或的值 + 对应子数组的右端点的最小值
        var set = new HashSet<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            ors.add(new int[]{0, i});
            int k = 0;
            for (int[] or : ors) {
                or[0] |= nums[i];
                if (ors.get(k)[0] == or[0]) {
                    ors.get(k)[1] = or[1];  // 合并相同值，下标取最小的
                } else {
                    ors.set(++k, or);
                }
            }
            ors.subList(k + 1, ors.size()).clear();
            // 本题只用到了 ors[0]，如果题目改成任意给定数值，可以在 ors 中查找
            for (var or : ors) set.add(or[0]);
        }
        return set.size();
    }
}
