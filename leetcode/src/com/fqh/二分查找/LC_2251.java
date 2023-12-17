package com.fqh.二分查找;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/16 21:05
 * @Version V1.0
 */
public class LC_2251 {


//    2251. 花期内花的数目
//    第 290 场周赛
//            Q4
//2022
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
//
//    请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。

    // 将flowers分成两个数组，开始时间start和结束时间end
    // 第i个人能够看到花的数目 = start中小于等于people[i]的个数 - end中小于people[i]的个数
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        var start = new int[n];
        var end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        var ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int v1 = bisectRight(start, people[i]);
            int v2 = bisectLeft(end, people[i]);
            ans[i] = v1 - v2;
        }
        return ans;
    }

    /**
     * 返回 `target` 在 `a` 中最左边的插入位置。
     * 存在多个相同的值时，返回最左边的位置。
     * @param a         一维数组
     * @param target    搜索的值
     * @return
     */
    public static int bisectLeft(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] < target) {
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
     * @param a         一维数组
     * @param target    搜索的值
     * @return
     */
    public static int bisectRight(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
