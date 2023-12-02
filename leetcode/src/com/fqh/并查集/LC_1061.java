package com.fqh.并查集;

/**
 * @Author: vq
 * @Date: 2023/12/2 16:28
 * @Version V1.0
 */
public class LC_1061 {
//    1061. 按字典序排列最小的等效字符串
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。
//
//    其中  s1[i] 和 s2[i]  是一组等价字符。
//
//    举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
//    等价字符遵循任何等价关系的一般规则：
//
//    自反性 ：'a' == 'a'
//    对称性 ：'a' == 'b' 则必定有 'b' == 'a'
//    传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
//    例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串
//
//    利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        var u = new UnionFind(26);
        for (int i = 0; i < n; ++i) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            u.merge(x, y);
        }
        var sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            int p = u.find(baseStr.charAt(i) - 'a');
            sb.append((char) (p + 'a'));
        }
        return sb.toString();
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
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            // 往字典序小的根上合并
            if (pa < pb) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
            }
        }
    }
}
