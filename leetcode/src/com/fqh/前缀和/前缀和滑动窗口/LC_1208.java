package com.fqh.前缀和.前缀和滑动窗口;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 15:44
 **/
public class LC_1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        // 滑动窗口求a中sum不超过 maxCost的最大子数组长度
        int ans = 0, sum = 0, j = 0;
        for (int i = 0; i < n; i++) {
            sum += g[i];
            if (sum > maxCost) {
                sum -= g[j++];
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

//    1208. 尽可能使字符串相等
//    第 156 场周赛
//            Q2
//1497
//    相关标签
//            相关企业
//    提示
//    给你两个长度相同的字符串，s 和 t。
//
//    将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
//
//    用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
//
//    如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
//
//    如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。

    public static void main(String[] args) {
        System.out.println(new LC_1208().equalSubstring("abcd", "cdef", 3));
    }
}
