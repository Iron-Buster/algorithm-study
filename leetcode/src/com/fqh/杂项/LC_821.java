package com.fqh.杂项;

import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/2 17:11
 **/
public class LC_821 {
//    821. 字符的最短距离
//            已解答
//    第 81 场周赛
//            Q1
//1266
//    相关标签
//            相关企业
//    给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
//
//    返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
//
//    两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
    public int[] shortestToChar(String ss, char c) {
        char[] s = ss.toCharArray();
        var tset = new TreeSet<Integer>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == c) tset.add(i);
        }
        var ans = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            Integer floor = tset.floor(i);
            Integer ceiling = tset.ceiling(i);
            if (floor != null && ceiling != null) {
                ans[i] = Math.min(Math.abs(i-floor), Math.abs(i-ceiling));
            } else if (floor != null) {
                ans[i] = Math.abs(i-floor);
            } else {
                ans[i] = Math.abs(i-ceiling);
            }
        }
        return ans;
    }
}
