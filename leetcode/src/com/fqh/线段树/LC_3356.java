package com.fqh.线段树;

public class LC_3356 {


    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        var seg = new SegmentTreeIntervalSumMaxMin(n);
        for (int i = 1; i <= n; i++) {
            seg.a[i] = nums[i-1];
        }
        seg.build(1, n, 1); // 初始化线段树
        if (seg.getMax(1, n) == 0) return 0;
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0] + 1;
            int r = queries[i][1] + 1;
            int val = queries[i][2];
            seg.update(l, r, -val);
            if (Math.max(seg.getMax(1, n), 0) == 0) {
                return i + 1;
            }
        }
        return -1;
    }


    // 线段树 区间和、区间最值模板
    static class SegmentTreeIntervalSumMaxMin {
        static final int MAX = (int) (1e5 + 10);
        int n, m;
        long[] a;
        SegmentTreeIntervalSumMaxMin.Node[] tree;


        public SegmentTreeIntervalSumMaxMin(int n) {
            this.n = n;
            this.tree = new SegmentTreeIntervalSumMaxMin.Node[MAX << 2];
            this.a = new long[n + 1];
        }

        class Node {
            long sum, lz; // 总和、lazy标记
            long mx, mn; // 最大值max、最小值min

            public Node(long sum, long mx, long mn) {
                this.sum = sum;
                this.mx = mx;
                this.mn = mn;
            }

            public Node() {
                this.sum = 0;
                this.lz = 0;
                this.mx = Long.MIN_VALUE;
                this.mn = Long.MAX_VALUE;
            }
        }

        public void pushUp(int p) {
            tree[p].sum = tree[2 * p].sum + tree[2 * p + 1].sum;
            tree[p].mx = Math.max(tree[2 * p].mx, tree[2 * p + 1].mx);
            tree[p].mn = Math.min(tree[2 * p].mn, tree[2 * p + 1].mn);
        }

        public void pushDown(int s, int t, int mid, int p) {
            if (tree[p].lz == 0) return;
            tree[2 * p].sum += (mid - s + 1) * tree[p].lz;
            tree[2 * p].lz += tree[p].lz;
            tree[2 * p].mx += tree[p].lz;
            tree[2 * p].mn += tree[p].lz;

            tree[2 * p + 1].sum += (t - mid) * tree[p].lz;
            tree[2 * p + 1].lz += tree[p].lz;
            tree[2 * p + 1].mx += tree[p].lz;
            tree[2 * p + 1].mn += tree[p].lz;

            tree[p].lz = 0;
        }

        public void build(int s, int t, int p) {
            tree[p] = new SegmentTreeIntervalSumMaxMin.Node();
            tree[p].lz = 0;
            if (s == t) {
                tree[p].sum = a[s];
                tree[p].mx = tree[p].mn = a[s];
                return;
            }
            int mid = (s + t) / 2;
            build(s, mid, 2 * p);
            build(mid + 1, t, 2 * p + 1);
            pushUp(p);
        }

        // 如果是单点修改 那么l=r
        public void update(int l, int r, int c, int s, int t, int p) {
            if (l <= s && t <= r) {
                tree[p].sum += (long) (t - s + 1) * c;
                tree[p].lz += c;
                tree[p].mx += c;
                tree[p].mn += c;
                return;
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);
            if (l <= mid) {
                update(l, r, c, s, mid, 2 * p);
            }
            if (r > mid) {
                update(l, r, c, mid + 1, t, 2 * p + 1);
            }
            pushUp(p);
        }

        public void update(int l, int r, int c) {
            update(l, r, c, 1, n, 1);
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

        public long getMax(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return tree[p].mx;
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);
            long ans = Long.MIN_VALUE;
            if (l <= mid) {
                ans = Math.max(ans, getMax(l, r, s, mid, 2 * p));
            }
            if (r > mid) {
                ans = Math.max(ans, getMax(l, r, mid + 1, t, 2 * p));
            }
            return ans;
        }

        public long getMin(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return tree[p].mn;
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);
            long ans = Long.MAX_VALUE;
            if (l <= mid) {
                ans = Math.min(ans, getMin(l, r, s, mid, 2 * p));
            }
            if (r > mid) {
                ans = Math.min(ans, getMin(l, r, mid + 1, t, 2 * p));
            }
            return ans;
        }

        public long getMax(int l, int r) {
            return getMax(l, r, 1, n, 1);
        }

        public long getMin(int l, int r) {
            return getMin(l, r, 1, n, 1);
        }


        public SegmentTreeIntervalSumMaxMin.Node getSumMaxMin(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return new SegmentTreeIntervalSumMaxMin.Node(tree[p].sum, tree[p].mx, tree[p].mn);
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);

            long mx = Long.MIN_VALUE;
            long mn = Long.MAX_VALUE;
            long sum = 0;
            if (l <= mid) {
                SegmentTreeIntervalSumMaxMin.Node node = getSumMaxMin(l, r, s, mid, 2 * p);
                mx = Math.max(mx, node.mx);
                mn = Math.min(mn, node.mn);
                sum += node.sum;
            }
            if (r > mid) {
                SegmentTreeIntervalSumMaxMin.Node node = getSumMaxMin(l, r, mid + 1, t, 2 * p + 1);
                mx = Math.max(mx, node.mx);
                mn = Math.min(mn, node.mn);
                sum += node.sum;
            }
            return new SegmentTreeIntervalSumMaxMin.Node(sum, mx, mn);
        }

        public SegmentTreeIntervalSumMaxMin.Node getSumMaxMin(int l, int r) {
            return getSumMaxMin(l, r, 1, n, 1);
        }
    }

    public static void main(String[] args) {
//        SegmentTreeIntervalSumMaxMin seg = new SegmentTreeIntervalSumMaxMin(10);
//        seg.update(1, 10, 1);
//        seg.update(1, 1, 30);
//        seg.update(1, 5, 60);
//        long max = seg.getMax(1, 5);
//        System.out.println(max);

        int[] nums = {4,3,2,1};
        int[][] queries = {{1,3,2}, {0,2,1}};
        System.out.println(new LC_3356().minZeroArray(nums, queries));
    }

}
