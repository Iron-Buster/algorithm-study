package com.fqh.分组循环;

import java.util.HashSet;

/**
 * @Author: vq
 * @Date: 2023/11/28 17:53
 * @Version V1.0
 */
public class LC_1839 {

//    1839. 所有元音按顺序排布的最长子字符串
//    第 238 场周赛
//            Q3
//    1580
//    相关标签
//            相关企业
//    提示
//    当一个字符串满足如下条件时，我们称它是 美丽的 ：
//
//    所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
//    这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
//    比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
//
//    给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
//
//    子字符串 是字符串中一个连续的字符序列。
//
//
//
//    示例 1：
//
//    输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
//    输出：13
//    解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。

    public int longestBeautifulSubstring(String word) {
        return f(word.toCharArray());
    }

    int f(char[] s) {
        int n = s.length;
        int mx = 0, i = 0;
        while (i < n) {
            int st = i;
            var set = new HashSet<Character>();
            if (!check(s[i])) {
                i++;
                continue;
            }
            set.add(s[i]);
            for (i++; i < n && check(s[i]) && s[i] >= s[i-1]; i++) {
                set.add(s[i]);
            }
            if (set.size() == 5) {
                mx = Math.max(mx, i - st);
            }
        }
        return mx;
    }

    boolean check(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }
}
