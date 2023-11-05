package com.fqh.competition.wk370;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: vq
 * @Date: 2023/11/4 21:18
 * @Version V1.0
 */
public class C {

    List<Integer>[] g;
    int[] values;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        this.g = new List[n];
        this.values = values;
        Arrays.setAll(g, e -> new ArrayList<>());
        g[0].add(-1); // 避免误把根节点当作叶子
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        long ans = Arrays.stream(values).sum();
        return ans - dfs(0, -1);
    }

    long dfs(int x, int fa) {
        if (g[x].size() == 1) { // x是叶子
            return values[x];
        }
        long loss = 0; // 不选values[x]
        for (int y : g[x]) {
            if (y == fa) continue;
            loss += dfs(y, x);  // 计算以y为根的子树是健康时，失去的最小分数
        }
        return Math.min(values[x], loss); // 选/不选 values[x]，取最小值
    }



    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 5}};
        int[] values = {5, 2, 5, 2, 1, 1};
        System.out.println(new C().maximumScoreAfterOperations(edges, values));
    }
}
