package com.fqh.contests.wk138;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/11/25 12:40
 * @Version V1.0
 */
public class A {

//    1051. 高度检查器
//    第 138 场周赛
//            Q1
//1303
//    相关标签
//            相关企业
//    提示
//    学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
//
//    排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
//
//    给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
//
//    返回满足 heights[i] != expected[i] 的 下标数量 。

    public int heightChecker(int[] heights) {
        var a = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != heights[i]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new A().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }
}
