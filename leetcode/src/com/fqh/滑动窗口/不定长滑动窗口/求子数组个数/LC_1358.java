package com.fqh.滑动窗口.不定长滑动窗口.求子数组个数;

import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/20 18:31
 * @Version V1.0
 */
public class LC_1358 {

    // 枚举右端点
    public int numberOfSubstrings(String ss) {
        var map = new HashMap<Character, Integer>();
        char[] s = ss.toCharArray();
        int ans = 0, j = 0;
        for (int i = 0; i < s.length; i++) {
            map.merge(s[i], 1, Integer::sum);
            while (j < i && map.size() > 2) {
                map.merge(s[j], -1, Integer::sum);
                if (map.get(s[j]) == 0) map.remove(s[j]);
                j++;
            }
            ans += j;
        }
        return ans;
    }

//    1358. 包含所有三种字符的子字符串数目
//    第 20 场双周赛
//            Q3
//1646
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
//
//    请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
//
//
//
//    示例 1：
//
//    输入：s = "abcabc"
//    输出：10
//    解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。

    public static void main(String[] args) {
        System.out.println(new LC_1358().numberOfSubstrings("abcabc"));
    }
}
