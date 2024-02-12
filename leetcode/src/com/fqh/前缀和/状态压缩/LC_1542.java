package com.fqh.前缀和.状态压缩;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/12 16:29
 **/
public class LC_1542 {

//    1542. 找出最长的超赞子字符串
//    第 32 场双周赛
//            Q4
//    2222
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
//
//            「超赞子字符串」需满足满足下述两个条件：
//
//    该字符串是 s 的一个非空子字符串
//    进行任意次数的字符交换后，该字符串可以变成一个回文字符串
//
//
//    示例 1：
//
//    输入：s = "3242415"
//    输出：5
//    解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
    public int longestAwesome(String s) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0, mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= (1<<(s.charAt(i)-'0'));
            for (int j = 0; j <= 9; j++) {
                ans = Math.max(ans, i - map.getOrDefault(mask^(1<<j), Integer.MAX_VALUE));
            }
            if (map.containsKey(mask)) {
                ans = Math.max(ans, i - map.get(mask));
            }
            map.putIfAbsent(mask, i);
        }
        return ans;
    }
}
