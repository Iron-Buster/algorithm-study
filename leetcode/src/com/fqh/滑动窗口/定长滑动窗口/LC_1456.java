package com.fqh.滑动窗口.定长滑动窗口;

/**
 * @Author: vq
 * @Date: 2023/12/17 20:25
 * @Version V1.0
 */
public class LC_1456 {

//    1456. 定长子串中元音的最大数目
//    第 190 场周赛
//            Q2
//1263
//    相关标签
//            相关企业
//    提示
//    给你字符串 s 和整数 k 。
//
//    请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
//
//    英文中的 元音字母 为（a, e, i, o, u）。

    public boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String ss, int k) {
        int ans = 0;
        var s = ss.toCharArray();
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < s.length; i++) {
            cnt += check(s[i]) ? 1 : 0;
            if (i - j + 1 > k) {
                cnt -= check(s[j++]) ? 1 : 0;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1456().maxVowels("abciiidef", 3));
    }
}
