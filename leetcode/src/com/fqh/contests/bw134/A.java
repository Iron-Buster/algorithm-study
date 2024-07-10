package com.fqh.contests.bw134;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/7/10 22:31
 **/
public class A {

    //https://leetcode.cn/problems/alternating-groups-i/description/
    public int numberOfAlternatingGroups(int[] colors) {
        int k = 3;
        int n = colors.length;
        int[] a = new int[n + k - 1];
        for (int i = 0; i < n; i++) a[i] = colors[i];
        for (int i = n; i < a.length; i++) a[i] = colors[i-n];
        int ans = 0, j = 0;
        for (int i = 0; i < a.length; i++) {
            if (i - j + 1 > k) j++;
            if (i > 0 && a[i] == a[i-1]) { // 相邻的颜色冲突
                j = i;
            }
            if (i - j + 1 == k) {
                ans++;
            }
        }
        return ans;
    }
}
