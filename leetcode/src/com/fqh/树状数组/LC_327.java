package com.fqh.树状数组;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/21 16:47
 **/
public class LC_327 {

//    327. 区间和的个数
//            困难
//    相关标签
//            相关企业
//    给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
//
//    区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
//
//
//
//    示例 1：
//    输入：nums = [-2,5,-1], lower = -2, upper = 2
//    输出：3
//    解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。

    // 离散化 + 树状数组
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] s = new long[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + nums[i];
        }
        TreeSet<Long> tset = new TreeSet<>();
        for (long v : s) {
            tset.add(v);
            tset.add(v - lower);
            tset.add(v - upper);
        }
        Map<Long, Integer> map = new HashMap<>();
        int rank = 1;
        for (long v : tset) map.put(v, rank++);
        FenwickTree FT = new FenwickTree(tset.size() + 1);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int index = map.get(s[i]);
            int l = map.get(s[i] - upper);
            int r = map.get(s[i] - lower);
            ans += FT.query(r) - FT.query(l-1);
            FT.change(index, 1);
        }
        return ans;
    }

    class FenwickTree {
        int n;
        int[] s = new int[300005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public FenwickTree() {
            this.n = 300005;
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
}
