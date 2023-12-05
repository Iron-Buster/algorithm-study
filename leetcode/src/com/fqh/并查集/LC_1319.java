package com.fqh.并查集;

/**
 * @Author: vq
 * @Date: 2023/12/5 18:20
 * @Version V1.0
 */
public class LC_1319 {

//    1319. 连通网络的操作次数
//    第 171 场周赛
//            Q3
//    1633
//    相关标签
//            相关企业
//    提示
//    用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
//
//    网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
//
//    给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。
//    请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。

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

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[bRoot] = aRoot;
            count--;
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public int getCount() {
            return count;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        var u = new UnionFind(n);
        int cnt = 0; // 可操作的线的数量
        for (int[] conn : connections) {
            int x = conn[0], y = conn[1];
            if (u.isConnected(x, y)) {
                cnt++;
                continue;
            }
            u.union(x, y);
        }
        if (u.getCount() - 1 > cnt) return -1; // 不可能连通
        return u.getCount() - 1;
    }
}
