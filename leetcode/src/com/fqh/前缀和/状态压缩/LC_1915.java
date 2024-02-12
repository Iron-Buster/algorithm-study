package com.fqh.前缀和.状态压缩;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/12 16:28
 **/
public class LC_1915 {

//    1915. 最美子字符串的数目
//            已解答
//    第 247 场周赛
//            Q3
//    2235
//    相关标签
//            相关企业
//    提示
//    如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。
//
//    例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。
//    给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。请你返回 word 中 最美非空子字符串 的数目。如果同样的子字符串在 word 中出现多次，那么应当对 每次出现 分别计数。
//
//    子字符串 是字符串中的一个连续字符序列。
    public long wonderfulSubstrings(String word) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int mask = 0;
        long ans = 0;
        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            mask ^= (1<<x);
            for (int j = 'a'; j <= 'j'; j++) {
                int y = j - 'a';
                ans += map.getOrDefault(mask^(1<<y), 0);
            }
            if (map.containsKey(mask)) {
                ans += map.get(mask);
            }
            map.merge(mask, 1, Integer::sum);
        }
        return ans;
    }
}
