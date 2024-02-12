package com.fqh.前缀和.状态压缩;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/12 16:27
 **/
public class LC_1371 {
//    1371. 每个元音包含偶数次的最长子字符串
//            已解答
//    第 21 场双周赛
//            Q2
//    2041
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
//
//
//
//    示例 1：
//
//    输入：s = "eleetminicoworoep"
//    输出：13
//    解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。

    public int findTheLongestSubstring(String s) {
        String t = "aeiou";
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0, mask = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = t.indexOf(s.charAt(i));
            if (idx != -1) mask ^= (1 << idx);
            if (map.containsKey(mask)) { // 相同状态 异或等于0 刚好出现偶数次
                ans = Math.max(ans, i - map.get(mask));
            }
            map.putIfAbsent(mask, i);
        }
        return ans;
    }
}
