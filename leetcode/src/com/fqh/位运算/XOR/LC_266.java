package com.fqh.位运算.XOR;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/21 15:45
 **/
public class LC_266 {

//    266. 回文排列
//            已解答
//    简单
//            相关标签
//    相关企业
//            提示
//    给你一个字符串 s ，如果该字符串的某个排列是 回文 ，则返回 true ；否则，返回 false 。
//
//    示例 1：
//
//    输入：s = "code"
//    输出：false
//    示例 2：
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c-'a'] ^= 1;
        }
        int cnt2 = 0; // 出现次数为奇数的个数
        for (int c : map) {
            cnt2 += c&1;
        }
        return cnt2 == 0 || cnt2 == 1;
    }
}
