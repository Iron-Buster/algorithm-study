package com.fqh.线段树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_2569 {

    // https://leetcode.cn/problems/handling-sum-queries-after-update/description/?envType=problem-list-v2&envId=segment-tree
    // lazyTagSegTree

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        var seg = new SegmentTreeO1Flip(n);
        for (int i = 1; i <= n; i++) {
            seg.a[i] = nums1[i-1];
        }
        seg.build(1, n, 1);

        List<Long> res = new ArrayList<>();
        long sum = 0;
        for (long x : nums2) {
            sum += x;
        }
        for (int i = 0; i < queries.length; i++) {
            int op = queries[i][0];
            if (op == 1) {
                int l = queries[i][1] + 1;
                int r = queries[i][2] + 1;
                seg.update(l, r);
            } else if (op == 2) {
                int p = queries[i][1];
                sum += seg.getSum(1, n) * p;
            } else {
                res.add(sum);
            }
        }
        return res.stream().mapToLong(i -> i).toArray();
    }

    // 01区间翻转线段树模板
    class SegmentTreeO1Flip {
        static final int MAX = (int) (1e5 + 10);

        int n, m;
        long[] a;
        SegmentTreeO1Flip.Node[] tree;

        public SegmentTreeO1Flip(int n) {
            this.n = n;
            this.tree = new SegmentTreeO1Flip.Node[MAX << 2];
            this.a = new long[n + 1];
        }

        class Node {
            long sum, lz; // 总和、lazy标记

            public Node() {
                this.sum = 0;
                this.lz = 0;
            }
        }

        public void pushUp(int p) {
            tree[p].sum = tree[2 * p].sum + tree[2 * p + 1].sum;
        }

        public void pushDown(int s, int t, int mid, int p) {
            if (tree[p].lz == 0) return;
            tree[2 * p].sum = (mid - s + 1) - tree[2 * p].sum; // 翻转左子区间的值
            tree[2 * p].lz ^= 1;                               // 左子节点懒标记翻转

            tree[2 * p + 1].sum = (t - mid) - tree[2 * p + 1].sum; // 翻转右子区间的值
            tree[2 * p + 1].lz ^= 1;                           // 右子节点懒标记翻转

            tree[p].lz = 0;
        }

        public void build(int s, int t, int p) {
            tree[p] = new SegmentTreeO1Flip.Node();
            tree[p].lz = 0;
            if (s == t) {
                tree[p].sum = a[s];
                return;
            }
            int mid = (s + t) / 2;
            build(s, mid, 2 * p);
            build(mid + 1, t, 2 * p + 1);
            pushUp(p);
        }

        // 如果是单点修改 那么l=r
        public void update(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                tree[p].sum = (t - s + 1) - tree[p].sum;        // 翻转的区间和
                tree[p].lz ^= 1;                                // 标记区间需要翻转
                return;
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);
            if (l <= mid) {
                update(l, r, s, mid, 2 * p);
            }
            if (r > mid) {
                update(l, r, mid + 1, t, 2 * p + 1);
            }
            pushUp(p);
        }

        public void update(int l, int r) {
            update(l, r, 1, n, 1);
        }

        // l=r表示当前tree[l]的值
        public long getSum(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return tree[p].sum;
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);
            long sum = 0;
            if (l <= mid) {
                sum += getSum(l, r, s, mid, 2 * p);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, 2 * p + 1);
            }
            return sum;
        }

        public long getSum(int l, int r) {
            return getSum(l, r, 1, n, 1);
        }
    }

    public static void main(String[] args) {

        int[] a = {1, 0, 1};
        int[] b = {0, 0, 0};
        int[][] q = {{1, 1, 1}, {2, 1, 0}, {3, 0, 0}};
        System.out.println(Arrays.toString(new LC_2569().handleQuery(a, b, q)));
    }
}
