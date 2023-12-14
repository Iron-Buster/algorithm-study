package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/12/14 18:10
 * @Version V1.0
 */
public class LC_1957 {

//    1957. 删除字符使字符串变好
//    第 58 场双周赛
//            Q1
//1358
//    相关标签
//            相关企业
//    提示
//    一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
//
//    给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
//
//    请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
//
//
//
//    示例 1：
//
//    输入：s = "leeetcode"
//    输出："leetcode"
//    解释：
//    从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
//    没有连续三个相同字符，所以返回 "leetcode" 。


    public String makeFancyString(String s) {
        return f(s.toCharArray());
    }

    String f(char[] s) {
        int n = s.length;
        var sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[i - 1]; i++) ;
            int cnt = i - st;
            if (cnt > 1) {
                sb.append(s[i - 1]).append(s[i - 1]);
            } else {
                sb.append(s[i - 1]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new LC_1957().makeFancyString("aaabaaaa");
        System.out.println(s);
    }
}
