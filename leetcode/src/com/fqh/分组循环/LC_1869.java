package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/11/27 11:38
 * @Version V1.0
 */
public class LC_1869 {

//    1869. 哪种连续子字符串更长
//        第 242 场周赛
//                Q1
//    1205
//    相关标签
//            相关企业
//    提示
//    给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
//
//    例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
//    注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
//
//
//
//    示例 1：
//
//    输入：s = "1101"
//    输出：true
//    解释：
//    由 1 组成的最长连续子字符串的长度是 2："1101"
//    由 0 组成的最长连续子字符串的长度是 1："1101"
//    由 1 组成的子字符串更长，故返回 true 。

    public boolean checkZeroOnes(String s) {
        char[] cs = s.toCharArray();
        return f(cs, 1) > f(cs, 0);
    }

    int f(char[] s, int v) {
        int n = s.length;
        int mx = 0, i = 0;
        while (i < n) {
            if (s[i] - '0' != v) {
                i++;
                continue;
            }
            int st = i;
            for (i++; i < n && s[i] - '0' == v; i++);
            mx = Math.max(mx, i - st);
        }
        return mx;
    }
}
