package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/12/17 18:04
 * @Version V1.0
 */
public class LC_485 {

//    485. 最大连续 1 的个数
//    给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

    public int findMaxConsecutiveOnes(int[] nums) {
        return f(nums);
    }

    public int f(int[] a) {
        int n = a.length;
        int i = 0, ans = 0;
        while (i < n) {
            int st = i;
            if (a[st] != 1) {
                i++;
                continue;
            }
            for (i++; i < n && a[i] == a[i - 1]; i++);
            ans = Math.max(ans, i - st);
        }
        return ans;
    }
}
