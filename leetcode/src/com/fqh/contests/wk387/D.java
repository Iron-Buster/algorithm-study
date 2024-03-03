package com.fqh.contests.wk387;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:14
 **/
public class D {

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        var tset = new TreeSet<Integer>();
        for (int x : nums) tset.add(x);
        var map = new HashMap<Integer, Integer>();
        int rank = 1;
        for (int x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft1 = new FenwickTree(n + 1);
        FenwickTree ft2 = new FenwickTree(n + 1);
        ft1.change(map.get(nums[0]), 1);
        ft2.change(map.get(nums[1]), 1);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);
        int right = map.size();
        for (int i = 2; i < n; i++) {
            int idx = map.get(nums[i]);
            int q1 = ft1.query(right) - ft1.query(idx); // 大于nums[i]的个数
            int q2 = ft2.query(right) - ft2.query(idx); // 大于nums[i]的个数
            if (q1 > q2) {
                a.add(nums[i]);
                ft1.change(idx, 1);
            } else if (q1 < q2) {
                b.add(nums[i]);
                ft2.change(idx, 1);
            } else {
                if (a.size() <= b.size()) {
                    a.add(nums[i]);
                    ft1.change(idx, 1);
                } else {
                    b.add(nums[i]);
                    ft2.change(idx, 1);
                }
            }
        }
        a.addAll(b);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = a.get(i);
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
}
