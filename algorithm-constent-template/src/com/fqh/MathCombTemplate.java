package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/13 15:48
 * @Version V1.0
 */

/**
 * 组合数学
 */
public class MathCombTemplate {

}
/* 组合数学

概率与期望见 dp.go 中的「概率 DP」
部分计数问题见 dp.go 中的「计数 DP」

https://en.wikipedia.org/wiki/Combination
https://en.wikipedia.org/wiki/Enumerative_combinatorics
https://en.wikipedia.org/wiki/Binomial_theorem

鸽巢原理（抽屉原理） pigeonhole principle
https://en.wikipedia.org/wiki/Pigeonhole_principle
https://codeforces.com/problemset/problem/618/F*/

/*一些组合问题
        没有思路的话可以尝试：
        - 打表 + OEIS
        - 用 DP 推导，然后尝试优化
        - 假设法
        入门 https://atcoder.jp/contests/abc202/tasks/abc202_d
        https://codeforces.com/problemset/problem/1391/C 1500
        https://codeforces.com/problemset/problem/213/B
        https://codeforces.com/problemset/problem/300/C
        https://codeforces.com/problemset/problem/520/E
        https://codeforces.com/problemset/problem/559/C
        https://codeforces.com/problemset/problem/869/C
        https://codeforces.com/problemset/problem/1204/E 推荐
        https://codeforces.com/problemset/problem/1261/D2 推荐
        https://codeforces.com/problemset/problem/1288/C
        https://codeforces.com/problemset/problem/1342/E
        https://codeforces.com/problemset/problem/1359/E
        https://codeforces.com/problemset/problem/1761/D https://www.luogu.com.cn/blog/linyihdfj/solution-cf1761d https://www.cnblogs.com/linyihdfj/p/16893607.html
        https://codeforces.com/problemset/problem/1763/D 推荐 分类讨论
        https://atcoder.jp/contests/abc171/tasks/abc171_f 推荐 巧妙去重
        加强版 https://codeforces.com/contest/1838/problem/E
        - 把子序列改成子串 https://oj.socoding.cn/p/1446 https://leetcode.cn/problems/find-all-good-strings/
        - https://github.com/tdzl2003/leetcode_live/blob/master/socoding/1446.md
        https://atcoder.jp/contests/abc290/tasks/abc290_f
        LC2842 https://leetcode.cn/problems/count-k-subsequences-of-a-string-with-maximum-beauty/
        LC2514 https://leetcode.cn/problems/count-anagrams/
        LC2539 https://leetcode.cn/problems/count-the-number-of-good-subsequences/
 */

class Comb {
    int maxv = 63;
    int[][] comb = new int[maxv][maxv];
    // 求组合数
    void getComb() {
        comb[0][0] = 1;
        for (int i = 1; i < maxv; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
            }
        }
    }
}