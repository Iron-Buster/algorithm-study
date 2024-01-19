package com.fqh.并查集;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 14:17
 **/
public class LC_1101 {

//    1101. 彼此熟识的最早时间
//    第 3 场双周赛
//            Q3
//1558
//    相关标签
//            相关企业
//    提示
//    在一个社交圈子当中，有 n 个人。每个人都有一个从 0 到 n - 1 的唯一编号。我们有一份日志列表 logs，
//    其中 logs[i] = [timestampi, xi, yi] 表示 xi 和 yi 将在同一时间 timestampi 成为朋友。
//
//    友谊是 相互 的。也就是说，如果 a 和 b 是朋友，那么 b 和 a 也是朋友。同样，如果 a 和 b 是朋友，或者 a 是 b 朋友的朋友 ，那么 a 和 b 是熟识友。
//
//    返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。
//
//
//
//    示例 1：
//
//    输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
//    输出：20190301

//    logs =[[9,3,0],[0,2,1],[8,0,1],[1,3,2],[2,2,0],[3,3,1]]
//    输出：2

//    排序 + 并查集
    public int earliestAcq(int[][] logs, int n) {
        var uf = new UnionFind(n);
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int[] log : logs) {
            int t = log[0], x = log[1], y = log[2];
            uf.merge(x, y);
            if (uf.count == 1) {
                return t;
            }
        }
        return -1;
    }

    class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
            count = n;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            parent[rootB] = rootA;
            count--;
        }
    }

    public static void main(String[] args) {
    }
}
