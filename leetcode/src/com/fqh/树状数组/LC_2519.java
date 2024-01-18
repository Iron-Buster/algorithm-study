package com.fqh.树状数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/18 23:19
 **/
public class LC_2519 {


//    2519. 统计 K-Big 索引的数量
//    困难
//            相关标签
//    相关企业
//            提示
//    给定一个 下标从0开始 的整数数组 nums 和一个正整数 k 。
//
//    如果满足以下条件，我们称下标 i 为 k-big ：
//
//    存在至少 k 个不同的索引 idx1 ，满足 idx1 < i 且 nums[idx1] < nums[i] 。
//    存在至少 k 个不同的索引 idx2 ，满足 idx2 > i 且 nums[idx2] < nums[i] 。
//    返回 k-big 索引的数量。

    // 从前往后，从后往前跑一遍树状数组。
    // left[i]记录左侧小于nums[i]的元素个数
    // right[i]记录右侧小于nums[i]的元素个数
    public int kBigIndices(int[] nums, int k) {
        FenwickTree ft = new FenwickTree(100005);
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = ft.query(nums[i] - 1);
            ft.change(nums[i], 1);
        }
        Arrays.fill(ft.s, 0); // 清空树状数组，从后往前遍历
        for (int i = n - 1; i >= 0; i--) {
            right[i] = ft.query(nums[i] - 1);
            ft.change(nums[i], 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] >= k && right[i] >= k) {
                ans++;
            }
        }
        return ans;
    }

    class FenwickTree {
        int n;
        int[] s = new int[100005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) {    // 向后修
            while (x <= n) {
                s[x] += k;
                x += lowbit(x);
            }
        }
        public int query(int x) { // 向前查（前缀和）
            int t = 0;
            while (x > 0) {
                t += s[x];
                x -= lowbit(x);
            }
            return t;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 5, 2, 3};
        int k = 2;
        System.out.println(new LC_2519().kBigIndices(a, k));
    }
}
