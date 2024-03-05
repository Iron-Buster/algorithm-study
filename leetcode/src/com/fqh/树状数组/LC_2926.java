package com.fqh.树状数组;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/5 23:04
 **/
public class LC_2926 {

//    2926. 平衡子序列的最大和
//    第 370 场周赛
//            Q4
//    2448
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums 。
//
//    nums 一个长度为 k 的 子序列 指的是选出 k 个 下标 i0 < i1 < ... < ik-1 ，如果这个子序列满足以下条件，我们说它是 平衡的 ：
//
//    对于范围 [1, k - 1] 内的所有 j ，nums[ij] - nums[ij-1] >= ij - ij-1 都成立。
//    nums 长度为 1 的 子序列 是平衡的。
//
//    请你返回一个整数，表示 nums 平衡 子序列里面的 最大元素和 。

    // Ai - Bj >= i - j
    // Ai - i >= Bj - j
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        var tset = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) {
            tset.add(nums[i] - i);
        }
        var map = new HashMap<Integer, Integer>(tset.size());
        int rank = 1;
        for (int x : tset) map.put(x, rank++);
        var ft = new FenwickTree(tset.size() + 1);
        for (int i = 0; i < n; i++) {
            int idx = map.get(nums[i] - i);
            long v = Math.max(ft.query2(idx), 0); // 注意是 >=，>的话为query(idx-1)
            ft.change2(idx, v + nums[i]);
        }
        return ft.query2(tset.size());
    }

    class FenwickTree {
        int n;
        long[] s = new long[100005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
            // 如果s是维护前缀最值，那么需要初始化s = -INF
            for (int i = 0; i <= n; i++) {
                s[i] = Long.MIN_VALUE / 2;
            }
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

        public void change2(int x, long k) {    // 向后修 维护前缀最值
            while (x <= n) {
                s[x] = Math.max(s[x], k);
                x += lowbit(x);
            }
        }

        public long query2(int x) { // 向前查（前缀和） 查询前缀最值
            long t = Long.MIN_VALUE;
            while (x > 0) {
                t = Math.max(t, s[x]);
                x -= lowbit(x);
            }
            return t;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 5, 6};
        System.out.println(new LC_2926().maxBalancedSubsequenceSum(a));
    }
}
