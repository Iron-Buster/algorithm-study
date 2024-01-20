package com.fqh.二分答案;

import com.fqh.contests.bw85.B;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 16:26
 **/
public class LC_774 {

//    774. 最小化去加油站的最大距离
//    第 69 场周赛
//            Q4
//    2084
//    相关标签
//            相关企业
//    提示
//    整数数组 stations 表示 水平数轴 上各个加油站的位置。给你一个整数 k 。
//
//    请你在数轴上增设 k 个加油站，新增加油站可以位于 水平数轴 上的任意位置，而不必放在整数位置上。
//
//    设 penalty() 是：增设 k 个新加油站后，相邻 两个加油站间的最大距离。
//
//    请你返回 penalty() 可能的最小值。与实际答案误差在 10-6 范围内的答案将被视作正确答案。
//
//
//    示例 1：
//
//    输入：stations = [1,2,3,4,5,6,7,8,9,10], k = 9
//    输出：0.50000
//    示例 2：
//
//    输入：stations = [23,24,36,39,46,56,57,65,84,98], k = 1
//    输出：14.00000

    public boolean check(double x, int[] s, int k) {
        int cnt = 0;
        for (int i = 1; i < s.length; i++) {
            double d = s[i] - s[i-1];
            cnt += (int) (d / x);
        }
       return cnt <= k;
    }
    // 二分答案
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0;
        double r = 1000000001;
        while (l + 1e-6 < r) {
            double mid = (l + r) / 2.0;
            if (check(mid, stations, k)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] stations = {1,2,3,4,5,6,7,8,9,10};
        int k = 9;
        System.out.println(new LC_774().minmaxGasDist(stations, k));
    }
}
