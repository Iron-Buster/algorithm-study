package com.fqh.并查集;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/7 17:53
 **/
public class LC_1202 {

    // 并查集 + 优先队列
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        var uf = new UnionFind(n);
        for (var pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            uf.merge(x, y);
        }
        var map = new HashMap<Integer, PriorityQueue<Character>>();
        for (int i = 0; i < n; i++) {
            int fa = uf.find(i);
            map.computeIfAbsent(fa, v -> new PriorityQueue<>((a, b) -> a - b));
            map.get(fa).offer(s.charAt(i));
        }
        var ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int fa = uf.find(i);
            ans.append(map.get(fa).poll());
        }
        return ans.toString();
    }

    class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            fa[rootB] = rootA;
        }
    }


//    1202. 交换字符串中的元素
//    第 155 场周赛
//            Q3
//1855
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
//
//    你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
//
//    返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
//
//
//
//    示例 1:
//
//    输入：s = "dcab", pairs = [[0,3],[1,2]]
//    输出："bacd"
//    解释：
//    交换 s[0] 和 s[3], s = "bcad"
//    交换 s[1] 和 s[2], s = "bacd"
}
