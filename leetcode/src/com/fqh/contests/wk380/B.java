package com.fqh.contests.wk380;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 23:38
 **/
public class B {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        TreeSet<Integer> rr = new TreeSet<>();
        TreeSet<Integer> ll = new TreeSet<>();
        kmp(s, a, rr);
        kmp(s, b, ll);
        List<Integer> ans = new ArrayList<>();
        for (Integer idx : rr) {
            Integer floor = ll.floor(idx);
            Integer ceiling = ll.ceiling(idx);
            if ((floor != null && Math.abs(floor - idx) <= k) ||
                    (ceiling != null && Math.abs(ceiling - idx) <= k)) {
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
    public static void main(String[] args) {
        String s = "abcd";
        String a = "a";
        String b = "a";
        int k = 4;
        System.out.println(new B().beautifulIndices(s, a, b, k));
    }
}
