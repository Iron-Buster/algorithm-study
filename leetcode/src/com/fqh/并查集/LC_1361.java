package com.fqh.并查集;

/**
 * @Author: vq
 * @Date: 2023/12/9 13:23
 * @Version V1.0
 */
public class LC_1361 {
//    1361. 验证二叉树
//            已解答
//    第 177 场周赛
//            Q2
//    1465
//    相关标签
//            相关企业
//    提示
//    二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
//
//    只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
//
//    如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
//
//    注意：节点没有值，本问题中仅仅使用节点编号。

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        var rd = new int[n];
        var uf = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            int l = leftChild[i];
            int r = rightChild[i];
            if (l != -1) {
                rd[l]++;
                if (!uf.union(i, l)) return false;
            }
            if (r != -1) {
                rd[r]++;
                if (!uf.union(i, r)) return false;
            }
        }
        // 判断一下节点的入度是否有大于1的非法节点
        for (int i = 0; i < n; ++i) {
            if (rd[i] > 1) return false;
        }
        return uf.getCount() == 1;
    }

    /**
     * 并查集
     */
    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return false;
            parent[bRoot] = aRoot;
            count--;
            return true;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] lc = {1, -1, 3, -1};
        int[] rc = {2, -1, -1, -1};
        System.out.println(new LC_1361().validateBinaryTreeNodes(n, lc, rc));
    }
}
