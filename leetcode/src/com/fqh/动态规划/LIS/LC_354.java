package com.fqh.动态规划.LIS;

import java.util.*;

public class LC_354 {

    // https://leetcode.cn/problems/russian-doll-envelopes/description/
    // 将w从小到大排序，h从大到小排序（这样遇到w相同的能保证只选1个）。
    // 这题数据范围1e5，需要套用LC300的二分优化版本的LIS。

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        return lengthOfLIS2(envelopes);
    }

    // O（NlogN）
    public int lengthOfLIS2(int[][] nums) {
        List<Integer> g = new ArrayList<>();
        for (int[] x : nums) {
            int j = lowerBound(g, x[1]);
            if (j == g.size()) {
                g.add(x[1]); // >=x 的 g[j] 不存在
            } else {
                g.set(j, x[1]);
            }
        }
        return g.size();
    }

    int lowerBound(List<Integer> g, int target) {
        int l = 0;
        int r = g.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (g.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


    // 树状数组解法
    public int maxEnvelopes2(int[][] envelopes) {
        int n = envelopes.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{envelopes[i][0], envelopes[i][1], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        TreeSet<Integer> tset = new TreeSet<>();
        for (int[] e : envelopes) {
            tset.add(e[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int y : tset) {
            map.put(y, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int y = arr[i][1];
            int j = arr[i][2];
            int index = map.get(y);
            int p = ft.query2(index - 1);
            res[j] = p + 1;
            ft.change2(index, p + 1);
        }
        System.out.println(Arrays.toString(res));
        return Arrays.stream(res).max().getAsInt();
    }

    class FenwickTree {
        int n;
        int[] s = new int[100005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
            //如果s是维护前缀最值，那么需要初始化s = -INF
            for (int i = 0; i <= n; i++) {
                s[i] = Integer.MIN_VALUE;
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

        public void change2(int x, int k) {    // 向后修 维护前缀最值
            while (x <= n) {
                s[x] = Math.max(s[x], k);
                x += lowbit(x);
            }
        }

        public int query2(int x) { // 向前查（前缀和） 查询前缀最值
            int t = 0;
            while (x > 0) {
                t = Math.max(t, s[x]);
                x -= lowbit(x);
            }
            return t;
        }
    }
}
