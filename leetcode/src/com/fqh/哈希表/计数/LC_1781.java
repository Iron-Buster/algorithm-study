package com.fqh.哈希表.计数;

/**
 * @Author: vq
 * @Date: 2023/11/30 16:54
 * @Version V1.0
 */
public class LC_1781 {


//    1781. 所有子字符串美丽值之和
//    第 47 场双周赛
//            Q3
//    1715
//    相关标签
//            相关企业
//    提示
//    一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
//
//    比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
//    给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
//
//
//
//    示例 1：
//
//    输入：s = "aabcb"
//    输出：5
//    解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。


//    1 <= s.length <= 500

    // 思路：s长度很小，直接暴力枚举子串，然后计算美丽值，最后累加即可。
    public int beautySum(String s) {
        return f(s.toCharArray());
    }

    int f(char[] s) {
        int ans = 0;
        int n = s.length;
        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[26];
            for (int j = i; j < n; ++j) {
                cnt[s[j]-'a']++;
                int mx = 0, mn = 0x3f3f3f;
                for (int v : cnt) {
                    if (v > 0) {
                        mx = Math.max(mx, v);
                        mn = Math.min(mn, v);
                    }
                }
                ans += mx - mn;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1781().beautySum("aabcb"));
    }
}
