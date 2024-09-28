package com.fqh.线段树;

import java.util.Arrays;

public class LC_2286 {

    // https://leetcode.cn/problems/booking-concert-tickets-in-groups/description/

    public static void main(String[] args) {
        BookMyShow b = new BookMyShow(5, 9);
        System.out.println(Arrays.toString(b.gather(10, 1)));
        System.out.println(b.scatter(3, 3));
        System.out.println(Arrays.toString(b.gather(9, 1)));
        System.out.println(Arrays.toString(b.gather(10, 2)));
        System.out.println(Arrays.toString(b.gather(2, 0)));

    }


    static class BookMyShow {
        int n, m;
        SegmentTreeIntervalSumMaxMin seg;

        public BookMyShow(int n, int m) {
            seg = new SegmentTreeIntervalSumMaxMin(n);
            this.n = n;
            this.m = m;
        }

        public int[] gather(int k, int maxRow) {
            int r = findFirst(1, maxRow + 1, 1, n, 1, m - k);
//            System.out.println("r: " + r);
            if (r < 0) {
                return new int[]{};
            }
            long sum = seg.getSum(r, r);
            seg.update(r, r, k); // 单点修改
            return new int[]{r - 1, (int) sum};
        }

        public boolean scatter(int k, int maxRow) {
            // 区间[0,maxRow]的总和是否大于k
            long sum = seg.getSum(1, maxRow + 1);
            if (sum > (long) m * (maxRow + 1) - k) {
                return false;
            }
            int i = findFirst(1, maxRow + 1, 1, n, 1, m - 1);
            while (k > 0) {
                int left = (int) Math.min(m - seg.getSum(i, i), k);
                seg.update(i, i, left); // 单点修改
                k -= left;
                i++;
            }
            return true;
        }

        // 找到第一个能够装满k升水的下标
        public int findFirst(int l, int r, int s, int t, int p, int val) {
            if (seg.tree[p].mn > val) {
                return -1;
            }
            if (s == t) {
                return s;
            }
            int mid = (s + t) / 2;
            if (seg.tree[p * 2].mn <= val) {
                return findFirst(l, r, s, mid, p * 2, val);
            }
            if (r > mid) {
                return findFirst(l, r, mid + 1, t, p * 2 + 1, val);
            }
            return -1;
        }
    }

    // 线段树 区间和、区间最值模板
    static class SegmentTreeIntervalSumMaxMin {
        static final int MAX = (int) (1e5 + 10);


        int n, m;
        long[] a;
        Node[] tree;


        public SegmentTreeIntervalSumMaxMin(int n) {
            this.n = n;
            this.tree = new Node[MAX << 2];
            this.a = new long[n + 1];
            build(1, n, 1);
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
            tree[p] = new Node();
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


        public Node getSumMaxMin(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return new Node(tree[p].sum, tree[p].mx, tree[p].mn);
            }
            int mid = (s + t) / 2;
            pushDown(s, t, mid, p);

            long mx = Long.MIN_VALUE;
            long mn = Long.MAX_VALUE;
            long sum = 0;
            if (l <= mid) {
                Node node = getSumMaxMin(l, r, s, mid, 2 * p);
                mx = Math.max(mx, node.mx);
                mn = Math.min(mn, node.mn);
                sum += node.sum;
            }
            if (r > mid) {
                Node node = getSumMaxMin(l, r, mid + 1, t, 2 * p + 1);
                mx = Math.max(mx, node.mx);
                mn = Math.min(mn, node.mn);
                sum += node.sum;
            }
            return new Node(sum, mx, mn);
        }

        public Node getSumMaxMin(int l, int r) {
            return getSumMaxMin(l, r, 1, n, 1);
        }
    }

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
}
