package com.fqh.滑动窗口.不定长滑动窗口.求子数组个数;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 21:53
 **/
public class LC_2743 {

//    2743. 计算没有重复字符的子字符串数量
//    输入：s = "abcd"
//    输出：10
//    解释：由于每个字符只出现一次，每个子串都是特殊子串。
//    长度为 1 的子串有 4 个，长度为 2 的有 3 个，长度为 3 的有 2 个，
//    长度为 4 的有 1 个。所以一共有 4 + 3 + 2 + 1 = 10 个特殊子串。
    public int numberOfSpecialSubstrings(String s) {
        int ans = 0, j = 0;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            var x = s.charAt(i) - 'a';
            map[x]++;
            while (map[x] > 1) {
                var left = s.charAt(j) - 'a';
                map[left] = Math.max(0, map[left] - 1);
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LC_2743().numberOfSpecialSubstrings("bddqc"));
    }
}
