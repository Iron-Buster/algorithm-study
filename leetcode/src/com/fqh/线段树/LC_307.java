package com.fqh.线段树;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/6 15:28
 **/
public class LC_307 {

    class NumArray {
        SegmentTree st;
        int[] nums;
        public NumArray(int[] nums) {
            st = new SegmentTree();
            int n = nums.length;
            this.nums = nums;
            for (int i = 0; i < n; i++) {
                st.w[i+1] = nums[i];
            }
            st.build(1, 1, n);
        }

        public void update(int index, int val) {
            st.update(1, index+1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return st.query(1, left+1, right+1);
        }
    }

    /**
     * LazyTag线段树
     */
    static class SegmentTree {
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

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
