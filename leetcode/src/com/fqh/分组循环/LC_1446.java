package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/11/27 11:33
 * @Version V1.0
 */
public class LC_1446 {

//    1446. 连续字符
//                已解答
//        第 26 场双周赛
//                Q1
//    1165
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
//
//    请你返回字符串 s 的 能量。
//
//
//
//    示例 1：
//
//    输入：s = "leetcode"
//    输出：2
//    解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。

    public int maxPower(String s) {
        return f(s.toCharArray());
    }

    int f(char[] s) {
        int n = s.length;
        int mx = 0, i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[i-1]; i++);
            mx = Math.max(mx, i - st);
        }
        return mx;
    }
}
