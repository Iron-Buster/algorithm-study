package com.fqh.contests.bw131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/26 01:13
 **/
public class D {


    // 线段树 区间最大字段和
    class SegmentTreeIntervalMaxSubSum {
        static final int N = 50005;
        int[] a = new int[N];
        Tree[] tree = new Tree[4 * N];

        void pushUp(Tree u, Tree l, Tree r) {
            u.sum = l.sum + r.sum;
            u.lmx = Math.max(l.lmx, l.sum + r.lmx);
            u.rmx = Math.max(r.rmx, r.sum + l.rmx);
            u.mx = Math.max(Math.max(l.mx, r.mx), l.rmx + r.lmx);
        }

        void build(int u, int l, int r) { // 建树
            tree[u] = new Tree(l, r, a[r], a[r], a[r], a[r]);
            if (l == r) return;
            int m = l + r >> 1;
            int ls = u << 1;
            int rs = u << 1 | 1;
            build(ls, l, m);
            build(rs, m + 1, r);
            pushUp(tree[u], tree[ls], tree[rs]);
        }


        void change(int u, int x, int v) { // 点修
            if (tree[u].l == tree[u].r) {
                tree[u] = new Tree(x, x, v, v, v, v);
                return;
            }
            int mid = tree[u].l + tree[u].r >> 1;
            int ls = u << 1;
            int rs = u << 1 | 1;
            if (x <= mid) {
                change(ls, x, v);
            } else {
                change(rs, x, v);
            }
            pushUp(tree[u], tree[ls], tree[rs]);
        }

        Tree query(int u, int l, int r) { // 区查
            if (l <= tree[u].l &&  tree[u].r <= r) {
                return tree[u];
            }
            int mid = tree[u].l + tree[u].r >> 1;
            int ls = u << 1;
            int rs = u << 1 | 1;
            if (r <= mid) {
                return query(ls, l, r);
            }
            if (l > mid) {
                return query(rs, l, r);
            }
            // 开一个临时节点，存储拼凑结果（动态开点线段树）
            Tree T = new Tree();
            pushUp(T, query(ls, l, mid), query(rs, mid + 1, r));
            return T;
        }

        class Tree { // 线段树
            int l, r;
            // 区间和，最大左子段和，最大右子段和，最大子段和
            int sum, lmx, rmx, mx;

            public Tree(int l, int r, int sum, int lmx, int rmx, int mx) {
                this.l = l;
                this.r = r;
                this.sum = sum;
                this.lmx = lmx;
                this.rmx = rmx;
                this.mx = mx;
            }

            public Tree() {}
        }
    }


    public List<Boolean> getResults(int[][] queries) {
        var st = new SegmentTreeIntervalMaxSubSum();
        for (int i = 1; i <= 50000; i++) {
            st.a[i] = 1;
        }
        st.build(1, 1, 50000);
        var ans = new ArrayList<Boolean>();
        for (int[] q : queries) {
            int op = q[0];
            if (op == 1) {
                int x = q[1];
                st.change(1, x, 0);
            } else {
                int x = q[1], sz = q[2];
                int mx = st.query(1, 1, x).mx;
                // System.out.println("mx, sz " + mx + " " + sz);
                ans.add(mx >= sz);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        [[1,2],[2,3,3],[2,3,1],[2,2,2]]
//[[1,7],[2,7,6],[1,2],[2,7,5],[2,7,6]]
    }
}
