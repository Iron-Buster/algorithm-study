package com.fqh.滑动窗口.不定长滑动窗口;

import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/18 18:04
 * @Version V1.0
 */
public class LC_3 {

//    3. 无重复字符的最长子串
//            已解答
//    中等
//            相关标签
//    相关企业
//    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    public int lengthOfLongestSubstring(String ss) {
        var s = ss.toCharArray();
        var map = new HashMap<Character, Integer>();
        int ans = 0, j = 0;
        for (int i = 0; i < s.length; i++) {
            map.merge(s[i], 1, Integer::sum);
            while (map.get(s[i]) > 1) {
                map.merge(s[j], -1, Integer::sum);
                if (map.get(s[j]) == 0) map.remove(s[j]);
                j++;
            }
            ans = Math.max(ans, map.size());
        }
        return ans;
    }
}
