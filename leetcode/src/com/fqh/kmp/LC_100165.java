package com.fqh.kmp;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/14 13:10
 **/
public class LC_100165 {

//    100165. 找出数组中的美丽下标 I
//    已解答
//            中等
//    相关企业
//            提示
//    给你一个下标从 0 开始的字符串 s 、字符串 a 、字符串 b 和一个整数 k 。
//
//    如果下标 i 满足以下条件，则认为它是一个 美丽下标：
//
//            0 <= i <= s.length - a.length
//    s[i..(i + a.length - 1)] == a
//    存在下标 j 使得：
//            0 <= j <= s.length - b.length
//    s[j..(j + b.length - 1)] == b
//|j - i| <= k
//    以数组形式按 从小到大排序 返回美丽下标。

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        TreeSet<Integer> rr = new TreeSet<>();
        TreeSet<Integer> ll = new TreeSet<>();
        kmp(s, a, rr);
        kmp(s, b, ll);
        List<Integer> ans = new ArrayList<>();
        for (Integer idx : rr) {
            Integer ceiling = ll.ceiling(idx - k);
            if (ceiling != null && Math.abs(ceiling - idx) <= k) {
                ans.add(idx);
            }
        }
        return ans;
    }


    public void kmp(String ss, String pp, TreeSet<Integer> tset) {
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) {
                tset.add(i - m);
                j = next[j];
            }
        }
    }
}
