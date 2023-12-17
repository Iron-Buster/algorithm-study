package com.fqh.rating.R1800_1899;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * @Author: vq
 * @Date: 2023/12/17 16:49
 * @Version V1.0
 */
public class LC_2059 {

//    2059. 转化数字的最小运算数
//    第 265 场周赛
//            Q3
//1850
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
//
//    整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
//
//    如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
//
//    x + nums[i]
//    x - nums[i]
//    x ^ nums[i]（按位异或 XOR）
//    注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
//
//    返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // 转换成BFS求start到goal的最短路，
    // 对于cur当前点有三条边，
    //          cur + nums[i]
    //          cur - nums[i]
    //          cur ^ nums[i]
    // 对于 0 <= x <= 1000，如果next在这个范围内，不考虑操作
    public int minimumOperations(int[] nums, int start, int goal) {
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{start, 0});
        var vis = new HashSet<Integer>();
        vis.add(start);
        while (q.size() > 0) {
            int[] p = q.poll();
            int cur = p[0], step = p[1];
            for (int x : nums) {
                int next1 = cur + x;
                int next2 = cur - x;
                int next3 = cur ^ x;
                if (next1 == goal || next2 == goal || next3 == goal) {
                    return step + 1;
                }
                if (!vis.contains(next1) && next1 >= 0 && next1 <= 1000) {
                    q.offer(new int[]{next1, step + 1});
                    vis.add(next1);
                }
                if (vis.add(next2) && next2 >= 0 && next2 <= 1000) {
                    q.offer(new int[]{next2, step + 1});
                }
                if (!vis.contains(next3) && next3 >= 0 && next3 <= 1000) {
                    q.offer(new int[]{next3, step + 1});
                    vis.add(next3);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 7};
        int start = 0;
        int goal = -4;
        System.out.println(new LC_2059().minimumOperations(a, start, goal));
    }
}
