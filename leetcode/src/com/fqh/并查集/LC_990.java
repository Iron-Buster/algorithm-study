package com.fqh.并查集;

/**
 * @Author: vq
 * @Date: 2023/12/1 22:18
 * @Version V1.0
 */
public class LC_990 {

//    990. 等式方程的可满足性
//                已解答
//        第 123 场周赛
//                Q2
//    1638
//    相关标签
//            相关企业
//    给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
//
//    只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
//
//
//
//    示例 1：
//
//    输入：["a==b","b!=a"]
//    输出：false
//    解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。



    /**

     先将a == b的字符串连通
     然后再遍历 a != b的时候判断 ab是否已经连通，是则返回false
     */
    public boolean equationsPossible(String[] equations) {
        var u = new UnionFind(200);
        for (var s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            if (s.charAt(1) == '=') {
                u.merge(x, y);
            }
        }
        for (var s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            if (s.charAt(1) == '!' && u.find(x) == u.find(y)) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
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
        }
    }
}
