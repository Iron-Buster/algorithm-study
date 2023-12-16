package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/14 15:59
 * @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索
 */
public class SearchTemplate {
}

/* 回溯

子集/组合（也可以用二进制枚举做）
- [78. 子集](https://leetcode.cn/problems/subsets/)
- [77. 组合](https://leetcode.cn/problems/combinations/)
- [1286. 字母组合迭代器](https://leetcode.cn/problems/iterator-for-combination/) 1591
- [2397. 被列覆盖的最多行数](https://leetcode.cn/problems/maximum-rows-covered-by-columns/) 1719
- [2212. 射箭比赛中的最大得分](https://leetcode.cn/problems/maximum-points-in-an-archery-competition/) 1869
- [1601. 最多可达成的换楼请求数目](https://leetcode.cn/problems/maximum-number-of-achievable-transfer-requests/) 2119
- [320. 列举单词的全部缩写](https://leetcode.cn/problems/generalized-abbreviation/)（会员题）
https://codeforces.com/problemset/problem/550/B 1400

分割
- [93. 复原 IP 地址](https://leetcode.cn/problems/restore-ip-addresses/)
- [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning/)
- [2698. 求一个整数的惩罚数](https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/) 1679

排列（部分题目可以用状压 DP 继续优化）
- [46. 全排列](https://leetcode.cn/problems/permutations/)
- [2850. 将石头分散到网格图的最少移动次数](https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/) 2001
- [1307. 口算难题](https://leetcode.cn/problems/verbal-arithmetic-puzzle/) 2250
- [267. 回文排列 II](https://leetcode.cn/problems/palindrome-permutation-ii/)（会员题）
网格 https://atcoder.jp/contests/abc326/tasks/abc326_d

爆搜+剪枝
- [79. 单词搜索](https://leetcode.cn/problems/word-search/)
- [212. 单词搜索 II](https://leetcode.cn/problems/word-search-ii/)

https://www.luogu.com.cn/problem/P1379
https://codeforces.com/problemset/problem/429/C
爆搜 https://atcoder.jp/contests/abc233/tasks/abc233_c
https://atcoder.jp/contests/abc319/tasks/abc319_c
https://atcoder.jp/contests/abc197/tasks/abc197_c

https://oeis.org/A038206 Can express a(n) with the digits of a(n)^2 in order, only adding plus signs
- LC2698 https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/
https://oeis.org/A104113 Numbers which when chopped into one, two or more parts, added and squared result in the same number

不允许重复的排列：见 nextPermutation
*/


// 任意子集：从集合 1~n 中不重复地选取任意个元素
// 位运算写法见下面的 loopCollection
// 模板题 https://ac.nowcoder.com/acm/contest/6913/A
class ChooseAny {

    static int cnt = 0;
    static boolean[] used;
    static List<Integer> chosen;
    static void chooseAny(int n) {
        chosen = new ArrayList<>();
        used = new boolean[n + 1];
        f1(1, n);
        f2(1, n);
    }
    static void f1(int p, int n) {
        if (p == n + 1) {
            // do chosen ... or just cnt++
            cnt++;
            return;
        }
        // 剪枝: 能否继续...

        // 不选p
        f1(p + 1, n);

        // 选p
        // 剪枝：能否选 p（是否与 chosen 中的元素冲突等）...
        chosen.add(p);
        f1(p + 1, n);  // 如果可以重复，这里写 f(p)
        chosen.remove(chosen.size() - 1);
    }
    static void f2(int p, int n) {
        if (p == n + 1) {
            // do chosen... or just cnt++
            cnt++;
            return;
        }

        // 剪枝: 能否继续...

        // 不选p
        f2(p + 1, n);

        // 选p
        // 剪枝：能否选 p（是否与 used 中的元素冲突等）...
        used[p] = true;
        f2(p + 1, n);  // 如果可以重复，这里写 f(p)
        used[p] = false;

    }
}

// 部分子集：从集合 1~n 中不重复地选取至多 m 个元素 (0<=m<=n)
class ChooseAtMost {
    static int cnt = 0;
    static List<Integer> chosen;

    static void chooseAtMost(int n, int m) {
        chosen = new ArrayList<>();
        f(1, n, m);
    }

    static void f(int p, int n, int m) {
        if (chosen.size() > m || chosen.size() + n - p + 1 < m) {
            return;
        }
        if (p == n + 1) {
            // do chosen...
            return;
        }
        // 不选p
        f(p + 1, n, m);
        // 选p
        chosen.add(p);
        f(p + 1, n, m);
        chosen.remove(chosen.size() - 1);
    }
}

// 排列（不能重复）
// 即有 n 个位置，从左往右地枚举每个位置上可能出现的值（值必须在 a 中且不能重复）
// 对比上面的子集搜索，那是对每个位置枚举是否选择（两个分支），而这里每个位置有 n 个分支
// https://www.luogu.com.cn/problem/P1118
// LC1307 https://leetcode-cn.com/problems/verbal-arithmetic-puzzle/
class SearchPermutations  {
    static int used;
    static int n;
    static int[] a;
    static boolean searchPermutations(int[] nums) {
        a = nums;
        n = a.length;
        return f(0, 0);
    }

    static boolean f(int p, int sum) {
        // if sum > ... {} // 剪枝
        if (p == n) {
            // do sum..
            return sum == 0;
        }
        // 对每个位置，枚举可能出现的值，跳过已经枚举的值
        for (int i = 0; i < n; i++) {
            if ((used >> i & 1) > 0) {
                continue;
            }
            used |= (1 << i);
            // copy sum and do v...
            int s = sum;
            s += a[i];
            if (f(p + 1, s)) {
                // used[i] = false
                return true;
            }
            used ^= 1 << i;
        }
        return false;
    }
}

/* 枚举
枚举所有 2^n 子集
枚举子集的所有子集
枚举大小为 k 的子集
枚举格点周围（曼哈顿距离、切比雪夫距离）
*/
class LoopSet {

    static int n;
    static int[] a;

    // 枚举 {0,1,...,n-1} 的全部子集
    static void loopSet(int[] nums) {
        a = nums;
        n = a.length;
        for (int sub = 0; sub < (1 << n); sub++) {
            f(sub);
        }
    }

    static int f(int sub) {
        for (int i = 0; i < n; i++) {
            if ((sub >> i & 1) == 1) {
                // do(v)
                int temp = a[i];
            }
        }
        return 0;
    }
}


// 获取螺旋遍历的所有坐标         螺旋矩阵 Spiral Matrix
// LC54 https://leetcode.cn/problems/spiral-matrix/
// LC59 https://leetcode.cn/problems/spiral-matrix-ii/
// LC885 https://leetcode.cn/problems/spiral-matrix-iii/
// LC2326 https://leetcode.cn/problems/spiral-matrix-iv/
// https://ac.nowcoder.com/acm/contest/6489/C
class LoopSpiralMatrix {

}


