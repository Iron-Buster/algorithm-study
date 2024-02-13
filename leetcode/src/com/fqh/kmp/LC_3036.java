package com.fqh.kmp;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/13 21:56
 **/
public class LC_3036 {

//    3036. 匹配模式数组的子数组数目 II
//    已解答
//            困难
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数 -1 ，0 和 1 。
//
//    大小为 m + 1 的
//            子数组
//    nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组 pattern ：
//
//    如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k]
//    如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k]
//    如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k]
//    请你返回匹配 pattern 的 nums 子数组的 数目 。

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();
        for (int x : pattern) {
            if (x == -1) sb2.append(2);
            else sb2.append(x);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                sb1.append(1);
            } else if (nums[i + 1] < nums[i]) {
                sb1.append(2);
            } else {
                sb1.append(0);
            }
        }
        return kmp(sb1.toString(), sb2.toString());
    }

    public int kmp(String ss, String pp) {
        int n = ss.length(), m = pp.length();
        ss = " " + ss;
        pp = " " + pp;
        int ans = 0;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) {
                j = next[j];
                ans++;
            }
        }
        return ans;
    }
}
