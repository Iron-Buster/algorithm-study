package com.fqh.树状数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class LC_3288 {
    // 离散化 + 树状数组维护最值
    public int maxPathLength(int[][] coordinates, int k) {
        int n = coordinates.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{coordinates[i][0], coordinates[i][1], i};
        }
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        // 离散化 y小排名小，y大排名大
        TreeSet<Integer> tset = new TreeSet<>();
        for (int[] c : arr) {
            tset.add(c[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int y : tset) {
            map.put(y, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            int y = arr[i][1];
            int j = arr[i][2];
            int index = map.get(y);
            int p = ft.query2(index - 1);
            left[j] = p + 1;
            ft.change2(index, p + 1);
        }
        ft = new FenwickTree(tset.size() + 1);
        // 重新离散化，y大排名小，y小排名大
        rank = tset.size();
        for (int y : tset) {
            map.put(y, rank--);
        }
        int[] right = new int[n];
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            int y = arr[i][1];
            int j = arr[i][2];
            int index = map.get(y);
            int p = ft.query2(index - 1);
            right[j] = p + 1;
            ft.change2(index, p + 1);
        }
        return left[k] + right[k] - 1;
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
