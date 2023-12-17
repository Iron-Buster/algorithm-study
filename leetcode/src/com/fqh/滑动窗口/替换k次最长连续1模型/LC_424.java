package com.fqh.滑动窗口.替换k次最长连续1模型;

/**
 * @Author: vq
 * @Date: 2023/12/16 15:48
 * @Version V1.0
 */
public class LC_424 {

//    424. 替换后的最长重复字符
//            已解答
//    中等
//            相关标签
//    相关企业
//    给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
//
//    在执行上述操作后，返回 包含相同字母的最长子字符串的长度。

//    输入：s = "ABAB", k = 2
//    输出：4
//    解释：用两个'A'替换为两个'B',反之亦然。
//    示例 2：
//
//    输入：s = "AABABBA", k = 1
//    输出：4
//    解释：
//    将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//    子串 "BBBB" 有最长重复字母, 答案为 4。
//    可能存在其他的方法来得到同样的结果。

    public int characterReplacement(String ss, int k) {
        int ans = 0, maxCnt = 0;
        var s = ss.toCharArray();
        var map = new int[100];
        for (int i = 0, j = 0; i < s.length; i++) {
            map[s[i]]++;
            maxCnt = Math.max(maxCnt, map[s[i]]);
            if (i - j + 1 > maxCnt + k) {
                map[s[j]]--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
