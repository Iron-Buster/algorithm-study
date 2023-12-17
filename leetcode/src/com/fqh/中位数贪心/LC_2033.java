package com.fqh.中位数贪心;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: vq
 * @Date: 2023/12/17 16:05
 * @Version V1.0
 */
public class LC_2033 {

//    2033. 获取单值网格的最小操作数
//    第 262 场周赛
//            Q2
//1672
//    相关标签
//            相关企业
//    提示
//    给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
//
//    单值网格 是全部元素都相等的网格。
//
//    返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。

//    要使任意两元素最终相等，这两元素的差必须是 x 的倍数，
//    否则无法通过加减 x 来相等。
//    我们可以以数组中的某一元素为基准，若所有元素与它的差均为 x 的倍数，则任意两元素之差为 x 的倍数。

    public int minOperations(int[][] grid, int x) {
        var a = new ArrayList<Integer>();
        int base = grid[0][0];
        for (int[] g : grid) {
            for (int num : g) {
                if (Math.abs(base - num) % x != 0) {
                    return -1;
                }
                a.add(num);
            }
        }
        Collections.sort(a);
        int n = a.size();
        int ans = 0;
        for (int v : a) {
            ans += Math.abs(v - a.get(n / 2)) / x;
        }
        return ans;
    }
}
