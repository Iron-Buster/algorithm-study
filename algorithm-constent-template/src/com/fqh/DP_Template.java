package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/15 10:48
 * @Version V1.0
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 动态规划模板
 */
public class DP_Template {
}

/* 动态规划

入门视频：https://www.bilibili.com/video/BV1Xj411K7oF/

① 前缀/后缀之间的转移，例如从 dp[i-1] 转移到 dp[i]，或者从 dp[j] 转移到 dp[i]
LC70 爬楼梯 https://leetcode.cn/problems/climbing-stairs/
- 变形：有障碍物 https://atcoder.jp/contests/abc129/tasks/abc129_c
- 变形：有花费 LC746 https://leetcode.cn/problems/min-cost-climbing-stairs/
- LC2466 https://leetcode.cn/problems/count-ways-to-build-good-strings/ 1694
- LC2533 https://leetcode.cn/problems/number-of-good-binary-strings/
LC198 打家劫舍 https://leetcode.cn/problems/house-robber/
- 变形：恰好选 floor(n/2) 个 https://atcoder.jp/contests/abc162/tasks/abc162_f
- 变形：矩阵打家劫舍 https://codeforces.com/problemset/problem/1195/C
LC213 环形打家劫舍 https://leetcode.cn/problems/house-robber-ii/
- 相似题目 https://atcoder.jp/contests/abc251/tasks/abc251_e
LC276 https://leetcode.cn/problems/paint-fence/
LC343 https://leetcode.cn/problems/integer-break/
LC368 https://leetcode.cn/problems/largest-divisible-subset/
LC2369 https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/ 1780
- 变形：改成环形数组要怎么做
- 相似题目 https://codeforces.com/problemset/problem/1624/E 2000
LC983 https://leetcode.cn/problems/minimum-cost-for-tickets/ 1786
LC1416 https://leetcode.cn/problems/restore-the-array/ 1920
LC2312 https://leetcode.cn/problems/selling-pieces-of-wood/ 2363
LC2944 https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/
LCR165 https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
另见「最长递增子序列」

② 双序列问题，一般定义 dp[i][j] 表示对子问题 (s1[:i],s2[:j]) 的求解结果
见下面的「最长公共子序列」，包含大量扩展题目

③ 划分型 DP：将序列分成（恰好/至多）k 个连续区间，求解这些区间的某个最优性质
一般定义 dp[i][j] 表示将 a[:j+1] 分成 i+1 个连续区间得到的最优解
此时可以枚举最后一个区间的左端点 L，从 dp[i-1][L-1] 转移到 dp[i][j]，转移时考虑 a[L:j+1] 对最优解的影响
- [410. 分割数组的最大值](https://leetcode.cn/problems/split-array-largest-sum/)
- [813. 最大平均值和的分组](https://leetcode.cn/problems/largest-sum-of-averages/) 1937
- [1278. 分割回文串 III](https://leetcode.cn/problems/palindrome-partitioning-iii/) 1979
- [1335. 工作计划的最低难度](https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/) 2035
- [2478. 完美分割的方案数](https://leetcode.cn/problems/number-of-beautiful-partitions/) 2344
- [2911. 得到 K 个半回文串的最少修改次数](https://leetcode.cn/problems/minimum-changes-to-make-k-semi-palindromes/)
https://www.luogu.com.cn/problem/P2679

④ 划分型 DP：最小化分割出的区间个数 / 总和
- [132. 分割回文串 II](https://leetcode.cn/problems/palindrome-partitioning-ii/)
    至多 k 个 https://codeforces.com/problemset/problem/137/D
- [2707. 字符串中的额外字符](https://leetcode.cn/problems/extra-characters-in-a-string/) 1736
- [2767. 将字符串分割为最少的美丽子字符串](https://leetcode.cn/problems/partition-string-into-minimum-beautiful-substrings/) 1865
- [1105. 填充书架](https://leetcode.cn/problems/filling-bookcase-shelves/) 2014
- [2547. 拆分数组的最小代价](https://leetcode.cn/problems/minimum-cost-to-split-an-array/) 2020
- [2463. 最小移动总距离](https://leetcode.cn/problems/minimum-total-distance-traveled/) 2454
- [2052. 将句子分隔成行的最低成本](https://leetcode.cn/problems/minimum-cost-to-separate-sentence-into-rows/)（会员题）

⑤ 多维 / 额外状态
LC1477 https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/ 1851
LC1223 https://leetcode.cn/problems/dice-roll-simulation/ 2008
LC2919 https://leetcode.cn/problems/minimum-increment-operations-to-make-array-beautiful/ 2031 状态设计的好题
LC2209 https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/ 2106
LC956 https://leetcode.cn/problems/tallest-billboard/ 2381
LC920 https://leetcode.cn/problems/number-of-music-playlists/ 2400
LC1531 看起来是区间 DP，仔细分析后是线性 DP https://leetcode.cn/problems/string-compression-ii/ 2576
LC2464 https://leetcode.cn/problems/minimum-subarrays-in-a-valid-split/ 枚举选哪个
https://codeforces.com/contest/404/problem/D 1900

todo 题单 https://www.luogu.com.cn/training/83815#problems
跳台阶+禁入点 https://atcoder.jp/contests/abc289/tasks/abc289_d
入门计数 DP https://atcoder.jp/contests/abc248/tasks/abc248_c
https://atcoder.jp/contests/abc281/tasks/abc281_d
选或不选 [1800·hot10] https://codeforces.com/contest/1525/problem/D
https://codeforces.com/problemset/problem/176/B
https://codeforces.com/problemset/problem/1324/E
https://codeforces.com/problemset/problem/505/C
https://atcoder.jp/contests/abc267/tasks/abc267_d
贪心+abs https://atcoder.jp/contests/abc163/tasks/abc163_e
由 n 个值互不相同的点组成的高度不小于 h 的 BST 有多少个 https://codeforces.com/problemset/problem/9/D
https://codeforces.com/problemset/problem/38/E
好题：涉及到相邻状态先后关系的 DP（喂兔子） https://codeforces.com/problemset/problem/358/D
https://codeforces.com/problemset/problem/446/A
https://codeforces.com/problemset/problem/603/A
处理区间元素不能在区间外面的技巧 https://codeforces.com/problemset/problem/811/C https://codeforces.com/contest/811/submission/174568255
https://codeforces.com/problemset/problem/1120/C
与 KMP 结合 https://codeforces.com/problemset/problem/1163/D
https://codeforces.com/problemset/problem/1168/C
https://codeforces.com/problemset/problem/1542/D
https://codeforces.com/problemset/problem/1845/E
LC2143 https://leetcode.cn/problems/choose-numbers-from-two-arrays-in-range/

不相交区间 DP
- [2830. 销售利润最大化](https://leetcode.cn/problems/maximize-the-profit-as-the-salesman/) 1851
- [2008. 出租车的最大盈利](https://leetcode.cn/problems/maximum-earnings-from-taxi/) 1872
- [1235. 规划兼职工作](https://leetcode.cn/problems/maximum-profit-in-job-scheduling/) 2023
- [1751. 最多可以参加的会议数目 II](https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/) 2041
https://codeforces.com/problemset/problem/1801/C
LC2054 贪心 https://leetcode.cn/problems/two-best-non-overlapping-events/

排列型/插入型
LC629 https://leetcode.cn/problems/k-inverse-pairs-array/ https://www.luogu.com.cn/problem/P2513
https://www.lanqiao.cn/problems/240/learning/
https://atcoder.jp/contests/abc282/tasks/abc282_g
 */


/**
 * 树形DP
 */
// 没有上司的舞会
class LG_P1352 {

    static final int MAXN = 200010;
    static int[] w = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    // f[u][1] 表示以u为根节点的子树并且包括u的总快乐指数
    // f[u][0] 表示以u为根节点的子树并且不包括u的总快乐指数
    static int[][] f = new int[10010][2];
    static boolean[] fa = new boolean[10010];

//    状态计算
//    记点u的子节点是s,
//    1.选u，f[u][1] += f[s][0]
//    2.不选u，f[u][0] += max(f[s][1], f[s][0])

//    从根节点u开始dfs一遍
//    从根到叶深搜，从叶到根返回时，做DP，累加f值

    static void dfs(int u) { // 深搜节点 + 后序DP
        f[u][1] = w[u]; // 选u的快乐指数
        for (int son : g[u]) {
            dfs(son);  // 取u的子节点
            f[u][0] += Math.max(f[son][0], f[son][1]);
            f[u][1] += f[son][0];
        }
    }

    static void solve() throws Exception {
        n = in.nextInt();
        g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
            g[i] = new ArrayList<>();
            fa[i] = false;
        }
        for (int i = 1; i <= n - 1; i++) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int x = Integer.parseInt(ss[0]);
            int y = Integer.parseInt(ss[1]);
            g[y].add(x);
            fa[x] = true;
        }
        int root = 1;
        while (fa[root]) root++;
        dfs(root);
        out.println(Math.max(f[root][0], f[root][1]));
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
