package com.fqh.并查集;

/**
 * @Author: vq
 * @Date: 2023/12/1 22:07
 * @Version V1.0
 */
public class LC_839 {
//    839. 相似字符串组
//    第 85 场周赛
//            Q4
//2054
//    相关标签
//            相关企业
//    如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
//
//    例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
//
//    总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
//
//    给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
//
//
//
//    示例 1：
//
//    输入：strs = ["tars","rats","arts","star"]
//    输出：2

    /**
     * 并查集
     * 两个字符串中，相同位置不同字符的数量 > 2，这两个字符串不相似
     * 否则将这两个字符串连接到同一连通分量中
     */

    boolean check(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
                if (cnt > 2) return false;
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        var u = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (check(strs[i], strs[j])) {
                    u.merge(i, j);
                }
            }
        }
        return u.getCount();
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
            int p_a = find(a);
            int p_b = find(b);
            if (p_a == p_b) return;
            parent[p_b] = p_a;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
