package com.fqh.kmp;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/14 13:09
 **/
public class LC_28 {


//    28. 找出字符串中第一个匹配项的下标
//            已解答
//    简单
//            相关标签
//    相关企业
//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
//
//
//
//    示例 1：
//
//    输入：haystack = "sadbutsad", needle = "sad"
//    输出：0
//    解释："sad" 在下标 0 和 6 处匹配。
//    第一个匹配项的下标是 0 ，所以返回 0 。

    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    public int kmp(String ss, String pp) {
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
                j = next[j];
                return i - m;
            }
        }
        return -1;
    }
}
