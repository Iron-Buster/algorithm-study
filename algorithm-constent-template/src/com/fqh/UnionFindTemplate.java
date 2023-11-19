package com.fqh;


/* 并查集
只有路径压缩的并查集复杂度是 O(nlogn) 的，这也是大多数情况下的实现方案
只有启发式合并（按深度合并）的并查集的复杂度也是 O(nlogn) 的，适用于可持久化的场景

具体的时间复杂度证明见《算法导论》
https://zhuanlan.zhihu.com/p/553192435

随机合并下的时间复杂度 https://www.cis.upenn.edu/~sanjeev/papers/soda14_disjoint_set_union.pdf
*/

// 普通并查集
// 可视化 https://visualgo.net/zh/ufds
// https://oi-wiki.org/ds/dsu/
// https://cp-algorithms.com/data_structures/disjoint_set_union.html
// 并查集时间复杂度证明 https://oi-wiki.org/ds/dsu-complexity/
// RMQ 标准算法和线性树上并查集 https://ljt12138.blog.uoj.ac/blog/4874
//
// 另见 graph.go 中的 MST
//
// 模板题 LC547 https://leetcode.cn/problems/number-of-provinces/
// LC1267 https://leetcode.cn/problems/count-servers-that-communicate/
// https://www.luogu.com.cn/problem/P3367
// https://atcoder.jp/contests/arc097/tasks/arc097_b
// 基础题 https://codeforces.com/problemset/problem/1167/C
//       https://codeforces.com/problemset/problem/1411/C
// LC1562 https://leetcode.cn/problems/find-latest-group-of-size-m/
// 转换 https://atcoder.jp/contests/abc304/tasks/abc304_e
// 转换 https://atcoder.jp/contests/abc238/tasks/abc238_e
// merge 后 from 还有用 https://atcoder.jp/contests/abc279/tasks/abc279_f
//
// 处理图上的环
// - https://codeforces.com/contest/1726/problem/D
//
// 数组标记/区间合并相关
// - 经典模型是一维区间覆盖染色，通过倒序+并查集解决
// - 顺带补充下二维的情况（非并查集）：LC2718 https://leetcode.cn/problems/sum-of-matrix-after-queries/
// - [1851. 包含每个查询的最小区间](https://leetcode.cn/problems/minimum-interval-to-include-each-query/)
// - [2382. 删除操作后的最大子段和](https://leetcode.cn/problems/maximum-segment-sum-after-removals/)
// - [2334. 元素值大于变化阈值的子数组](https://leetcode.cn/problems/subarray-with-elements-greater-than-varying-threshold/)
// - [2612. 最少翻转操作数](https://leetcode.cn/problems/minimum-reverse-operations/)
// - https://codeforces.com/problemset/problem/724/D
// - https://codeforces.com/problemset/problem/827/A
// - https://codeforces.com/problemset/problem/1157/E
//
// 树+点权/边权的顺序
// - LC2421 https://leetcode.cn/problems/number-of-good-paths/
// - 贡献法 https://codeforces.com/problemset/problem/915/F
// - 贡献法 https://atcoder.jp/contests/abc214/tasks/abc214_d
//
// LC2503 https://leetcode.cn/problems/maximum-number-of-points-from-grid-queries/
// 接水问题 https://codeforces.com/problemset/problem/371/D
// 三维接雨水 https://www.luogu.com.cn/problem/P5930 LC407 https://leetcode-cn.com/problems/trapping-rain-water-ii/
// 使某些点不在环上需要删除的最少边数 https://ac.nowcoder.com/acm/contest/7780/C
// todo https://codeforces.com/problemset/problem/292/D
// 任意合并+区间合并 https://codeforces.com/problemset/problem/566/D
// 动态加点 https://codeforces.com/contest/1494/problem/D
// 思维转换 https://nanti.jisuanke.com/t/43488
//         https://codeforces.com/problemset/problem/1012/B
//         https://codeforces.com/problemset/problem/1466/F
// 前缀和 后缀和 https://codeforces.com/problemset/problem/292/D
// 维护树或基环树 https://codeforces.com/problemset/problem/859/E
// 求矩阵的 rank 矩阵 https://codeforces.com/problemset/problem/650/C LC1632 https://leetcode-cn.com/problems/rank-transform-of-a-matrix/submissions/
// 分组排序套路 LC1998 https://leetcode-cn.com/problems/gcd-sort-of-an-array/
// 套题 https://blog.csdn.net/weixin_43914593/article/details/104108049 算法竞赛专题解析（3）：并查集
// 转换 https://codeforces.com/problemset/problem/1253/D
// 离散 + 四方向 Kick Start 2019 Round C Wiggle Walk https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050ff2/0000000000150aac#analysis
// 能力守恒+离线 https://codeforces.com/contest/1851/problem/G
// 技巧：去掉无用数据
// - https://codeforces.com/problemset/problem/1157/E
// - https://codeforces.com/problemset/problem/1791/F
// todo https://codeforces.com/contest/884/problem/E


public class UnionFindTemplate {
}

// 普通并查集
class UnionFind {
    private int[] fa;
    private int groups; // 连通分量个数

    public UnionFind(int n) {
        this.fa = new int[n]; // n+1
        for (int i = 0; i < n; ++i) {
            fa[i] = i;
        }
        this.groups = n;
    }

    // 非递归版本 查询 (路径压缩版)
    public int find(int x) {
        while (x != fa[x]) {
            fa[x] = fa[fa[x]];
            x = fa[x];
        }
        return x;
    }
    // 合并
    public void merge(int from, int to) {
        int x = find(from);
        int y = find(to);
        fa[x] = y;
        groups--;
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }
}

// 点权并查集



// 边权并查集（种类并查集）
// 核心在于：
//    2 ------ 4
//   /        /
//  1 ------ 3
// 如果知道 1->2 的距离和 3->4 的距离，现在告诉你 1->3 的距离
// 由于 1->3->4 和 1->2->4 的距离相等（相当于从 1 到 4 有两条路径）
// 那么就可以推出 2->4 的距离为 (1->3) + (3->4) - (1->2)
//
// https://www.bilibili.com/video/av68342657?p=2
// https://cp-algorithms.com/data_structures/disjoint_set_union.html#toc-tgt-11
// https://cp-algorithms.com/data_structures/disjoint_set_union.html#toc-tgt-12
// https://oi-wiki.org/ds/dsu/#_9
// 模板题 https://codeforces.com/contest/1850/problem/H
//       https://codeforces.com/problemset/problem/1074/D
//       https://codeforces.com/edu/course/2/lesson/7/2/practice/contest/289391/problem/D
// 种类并查集：同义词反义词 https://codeforces.com/problemset/problem/766/D
// 种类并查集：狼人和平民 https://codeforces.com/problemset/problem/1594/D
// 种类并查集：食物链 https://www.luogu.com.cn/problem/P2024
// 种类并查集：不能构成二分图的第一条边 https://codeforces.com/edu/course/2/lesson/7/2/practice/contest/289391/problem/J
// 种类并查集 + 维护集合大小 https://codeforces.com/problemset/problem/1290/C
// todo https://codeforces.com/contest/1615/problem/D
//      https://codeforces.com/contest/1713/problem/E
// 边权：https://codeforces.com/edu/course/2/lesson/7/1/practice/contest/289390/problem/C
// 边权：LC399 除法求值 https://leetcode.cn/problems/evaluate-division/
// https://codeforces.com/problemset/problem/1788/F

class EdgeWeightUnionFind {
    // 注：kinds 为 2 时可以用异或来代替加减法
    private static final int kinds = 2;
    private int[] fa;
    private int groups;
    private int[] dis;  // dis[i] 表示 i 到其所在集合根节点（代表元）的距离
    private int[][] cnt; // // 统计每个集合中各个类型的个数

    public EdgeWeightUnionFind(int n) {
        this.fa = new int[n]; // n+1
        this.dis = new int[n]; // n+1;
        this.cnt = new int[n][kinds];
        for (int i = 0; i < n; ++i) {
            fa[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            cnt[find(i)][dis[i] % kinds]++;
        }
        this.groups = n;
    }

    public int find(int x) {
        if (fa[x] != x) {
            int ffx = find(fa[x]);
            dis[x] += dis[fa[x]];
            fa[x] = ffx;
        }
        return fa[x];
    }

    // 调用前需要保证 same(x, y) 为 true
    public int delta(int x, int y) {
        find(x);
        find(y);
        return ((dis[x] - dis[y]) % kinds + kinds) % kinds;
    }

    // 返回是否与已知条件矛盾
    public boolean merge(int from, int to, int d) {
        int fFrom = find(from);
        int fTo = find(to);
        if (fFrom != fTo) {
            dis[fFrom] = d + dis[to] - dis[from];
            fa[fFrom] = fTo;
            return true;
        }
        return delta(from, to) == d;
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

}
