package com.fqh.图论.多源最短路;

import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/23 11:52
 **/
public class LC_399 {

//    399. 除法求值
//            中等
//    相关标签
//            相关企业
//    提示
//    给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
//
//    另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
//
//    返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
//
//    注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
//
//    注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
//
//
//
//    示例 1：
//
//    输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//    输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//    解释：
//    条件：a / b = 2.0, b / c = 3.0
//    问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//    结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
//    注意：x 是未定义的 => -1.0

    // a/b=2, a->2b。b->a/2
    // b/c=3, b->3c, a->6c
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[][] dist = new double[26][26];
        for (double[] dis : dist) {
            Arrays.fill(dis, -1);
        }
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            int u = equation.get(0).charAt(0) - 'a';
            int v = equation.get(1).charAt(0) - 'a';
            dist[u][v] = values[i];
            dist[v][u] = 1 / values[i];
        }
        floyd(dist);
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            int u = queries.get(i).get(0).charAt(0) - 'a';
            int v = queries.get(i).get(1).charAt(0) - 'a';
            if (dist[u][v] == -1) {
                ans[i] = -1;
            } else {
                ans[i] = dist[u][v];
            }
        }
        return ans;
    }

    static void floyd(double[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dist[i][k] != -1 && dist[k][j] != -1) {
                        // 不选 k，选 k
                        dist[i][j] = dist[i][k] * dist[k][j];
                    }
                }
            }
        }
    }
}
