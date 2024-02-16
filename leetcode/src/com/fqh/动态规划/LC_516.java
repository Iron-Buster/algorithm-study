package com.fqh.动态规划;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/16 22:15
 **/
public class LC_516 {

//    516. 最长回文子序列
//            已解答
//    中等
//            相关标签
//    相关企业
//    给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
//    子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

//    示例 1：
//
//    输入：s = "bbbab"
//    输出：4
//    解释：一个可能的最长回文子序列为 "bbbb" 。

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int l = 0, r = i; r < n; l++, r++) {
                if (s.charAt(l) == s.charAt(r)) {
                    f[l][r] = f[l+1][r-1];
                } else {
                    f[l][r] = Math.min(f[l+1][r], f[l][r-1]) + 1;
                }
            }
        }
        return n - f[0][n-1];
    }
}
