package com.fqh.competition.wk373;

import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/25 23:36
 * @Version V1.0
 */
public class C {

    // 把nums带着下标排序后，找一个最长的连续段，相邻数字的差 <= limit
    // 这一段对应的下标集合，这些位置之间可以随便排序
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // 1.把nums带着下标排序
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; ++i) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> nums[i] - nums[j]);
        int[] ans = new int[n];
        // 2.分组循环
        // 外层循环：准备工作
        // 内层循环：找最长连续段的末尾位置
        for (int i = 0; i < n; ) {
            int st = i;
            for (i++; i < n && nums[ids[i]] - nums[ids[i - 1]] <= limit; ++i) ;
            Integer[] subIds = Arrays.copyOfRange(ids, st, i);
            Arrays.sort(subIds);
            for (int j = 0; j < subIds.length; ++j) {
                ans[subIds[j]] = nums[ids[st + j]];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,6,18,2,1};
        int limit = 3;
        System.out.println(Arrays.toString(new C().lexicographicallySmallestArray(nums, limit)));
    }
}
