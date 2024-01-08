package com.fqh;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/24 11:07
 * @Version V1.0
 */
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 线段树 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public class SegmentTreeTemplate {

    public static void main(String[] args) {
    }
}

/**
 * LazyTag线段树
 */
class SegmentTree {
    int n;
    int[] w = new int[N];
    static int N = 100005;
    static Node[] tree = new Node[N * 4];

    void pushUp(int p) { // 向上更新
        tree[p].sum = tree[p << 1].sum + tree[p << 1 | 1].sum;
    }

    void pushDown(int p) { // 向下更新
        int lc = p << 1;
        int rc = p << 1 | 1;
        if (tree[p].add > 0) {
            tree[lc].sum += tree[p].add * (tree[lc].r - tree[lc].l + 1);
            tree[rc].sum += tree[p].add * (tree[rc].r - tree[rc].l + 1);
            tree[lc].add += tree[p].add;
            tree[rc].add += tree[p].add;
            tree[p].add = 0;
        }
    }

    // 递归建树
    // 父节点编号为p
    // 左孩子编号为2*p，右孩子编号为2*p+1
    void build(int p, int l, int r) {
        tree[p] = new Node(l, r, w[l], 0);
        if (l == r) return; // 是叶子则返回
        int m = l + r >> 1; // 不是叶子则裂开
        build(p << 1, l, m);
        build(p << 1 | 1, m + 1, r);
        pushUp(p);
    }

    // 从根节点进入，递归找到叶子节点[x,x]，把该节点的值增加k。然后从下往上更新其祖先节点上的统计值
    void update(int p, int x, int k) { // 点修改
        if (tree[p].l == x && tree[p].r == x) { // 叶子则修改
            tree[p].sum += k;
            return;
        }
        int m = tree[p].l + tree[p].r >> 1; // 非叶子则裂开
        if (x <= m) {
            update(p << 1, x, k);
        }
        if (x > m) {
            update(p << 1 | 1, x, k);
        }
        pushUp(p);
    }

    int query(int p, int x, int y) { // 区间查询
        if (x <= tree[p].l && tree[p].r <= y) { // 覆盖则直接返回
            return tree[p].sum;
        }
        int m = tree[p].l + tree[p].r >> 1; // 不覆盖则裂开
        pushDown(p);
        int sum = 0;
        if (x <= m) {
            sum += query(p << 1, x, y);
        }
        if (y > m) {
            sum += query(p << 1 | 1, x, y);
        }
        return sum;
    }

    void update(int p, int x, int y, int k) { // 区间修改
        if (x <= tree[p].l && tree[p].r <= y) { // 覆盖直接修改
            tree[p].sum += (tree[p].r - tree[p].l + 1) * k;
            tree[p].add += k;
            return;
        }
        int m = tree[p].l + tree[p].r >> 1; // 不覆盖则裂开
        pushDown(p);
        if (x <= m) {
            update(p << 1, x, y, k);
        }
        if (y > m) {
            update(p << 1 | 1, x, y, k);
        }
        pushUp(p);
    }

    static class Node {
        int l, r, sum, add;

        public Node(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }

        public Node(int l, int r, int sum, int add) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.add = add;
        }
    }
}

// P3372 【模板】线段树 1
class LG_3372 {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        SegmentTree segmentTree = new SegmentTree();
        for (int i = 1; i <= n; i++) {
            segmentTree.w[i] = in.nextInt();
        }
        segmentTree.build(1, 1, n);
        while (m-- > 0) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int op = Integer.parseInt(ss[0]);
            int x = Integer.parseInt(ss[1]);
            int y = Integer.parseInt(ss[2]);
            if (op == 1) {
                int k = Integer.parseInt(ss[3]);
                segmentTree.update(1, x, y, k);
            } else {
                int res = segmentTree.query(1, x, y);
                out.println(res);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}


// https://www.luogu.com.cn/problem/SP1716
//https://www.spoj.com/problems/GSS3/
class SP_1716 {

    public static void solve() throws IOException {
        int n = in.nextInt();
        SegmentTreeIntervalMaxSubSum st = new SegmentTreeIntervalMaxSubSum();
        for (int i = 1; i <= n; i++) {
            st.a[i] = in.nextInt();
        }
        int m = in.nextInt();
        st.build(1, 1, n);
        while (m-- > 0) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int k = Integer.parseInt(ss[0]);
            int x = Integer.parseInt(ss[1]);
            int y = Integer.parseInt(ss[2]);
            if (k == 1) {
                if (x > y) {
                    int t = x;
                    x = y;
                    y = t;
                }
                int ans = st.query(1, x, y).mx;
                out.println(ans);
            } else {
                st.change(1, x, y);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}

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

    static class Tree { // 线段树
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



