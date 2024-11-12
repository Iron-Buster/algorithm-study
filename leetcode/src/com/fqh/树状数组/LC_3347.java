package com.fqh.树状数组;


import java.util.HashMap;
import java.util.TreeSet;

public class LC_3347 {

    // https://leetcode.cn/problems/maximum-frequency-of-an-element-after-performing-operations-ii/description/


    public int maxFrequency(int[] nums, int k, int ops) {
        var counter = new HashMap<Long, Integer>();
        var tset = new TreeSet<Long>();
        for (long x : nums) {
            tset.add(x);
            tset.add(x - k);
            tset.add(x + k);
            counter.merge(x, 1, Integer::sum);
        }
        int rank = 1;
        var map = new HashMap<Long, Integer>();
        for (long x : tset) map.put(x, rank++);

        FenwickTree ft = new FenwickTree(tset.size() + 1);
        // 利用树状数组做差分
        for (long x : nums) {
            int l = map.get(x - k);
            int r = map.get(x + k);
            ft.change(l, 1);
            ft.change(r + 1, -1);
        }
        int ans = 1;
        for (long x : tset) {
            int index = map.get(x);
            int v = ft.query(index);
            ans = Math.max(ans, Math.min(counter.getOrDefault(x, 0) + ops, v));
        }
        return ans;
    }

    class FenwickTree {
        int n;
        int[] s = new int[300005]; // 区间和

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


}
