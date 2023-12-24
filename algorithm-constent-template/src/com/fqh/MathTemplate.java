package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/13 16:10
 * @Version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数论
 */
public class MathTemplate {

}

/**
 * 快速幂
 */
class FastPow {
    static final int MOD = (int) (1e9 + 7);

    // 快速幂
    static int ksm(int x, int n) {
        x %= MOD;
        int res = 1 % MOD;
        while (n > 0) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n /= 2;
        }
        return res;
    }

    // 取模快速幂
    static int ksmM(int x, int n, int p) {
        x %= p;
        int res = 1 % p;
        while (n > 0) {
            if (n % 2 > 0) {
                res = res * x % p;
            }
            x = x * x % p;
            n /= 2;
        }
        return res;
    }
}

/**
 * GCD LCM 相关
 */
class GCD_LCM {

//    GCD(x,y) = GCD(x,y-x)   x<=y
//    https://codeforces.com/problemset/problem/1458/A
//
//    GCD 套路：枚举倍数（调和级数复杂度）
//    GCD(x,x+y) = GCD(x,y) https://codeforces.com/problemset/problem/1110/C
//    GCD 与质因子 https://codeforces.com/problemset/problem/264/B
//    数组中最小的 LCM(ai,aj) https://codeforces.com/problemset/problem/1154/G
//    分拆与 LCM  https://ac.nowcoder.com/acm/contest/5961/D https://ac.nowcoder.com/discuss/439005
//    TIPS: 一般 LCM 的题目都需要用 LCM=x*y/GCD 转换成研究 GCD 的性质

//    https://atcoder.jp/contests/abc206/tasks/abc206_e
//
//    GCD = 1 的子序列个数 https://codeforces.com/problemset/problem/803/F https://ac.nowcoder.com/acm/problem/112055
//    见后面的 mu

//    a 中任意两数互质 <=> 每个质数至多整除一个 a[i]
//    https://codeforces.com/contest/1770/problem/C
//
//    Frobenius problem / Coin problem / Chicken McNugget Theorem
//    两种硬币面额为 a 和 b，互质，数量无限，所不能凑出的数值的最大值为 a*b-a-b
//    https://artofproblemsolving.com/wiki/index.php/Chicken_McNugget_Theorem
//    https://en.wikipedia.org/wiki/Coin_problem
//    https://www.luogu.com.cn/problem/P3951
//    https://codeforces.com/contest/1526/problem/B

    // 最大公约数
    static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    // GCD 前缀数组
    static int[] gcdPrefix(int[] a) {
        int n = a.length;
        int[] gp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            gp[i + 1] = gcd(gp[i], a[i]);
        }
        return gp;
    }

    // GCD 后缀数组
    static int[] gcdSuffix(int[] a) {
        int n = a.length;
        int[] gs = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            gs[i] = gcd(gs[i + 1], a[i]);
        }
        return gs;
    }

    // 最小公倍数
    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // 前 n 个数的 LCM https://oeis.org/A003418 a(n) = lcm(1,...,n) ~ exp(n)
    // 相关题目 https://atcoder.jp/contests/arc110/tasks/arc110_a
    //         https://codeforces.com/problemset/problem/1485/D
    //         https://codeforces.com/problemset/problem/1542/C
    //         https://codeforces.com/problemset/problem/1603/A
    // a(n)/a(n-1) = https://oeis.org/A014963
    //     前缀和 https://oeis.org/A072107 https://ac.nowcoder.com/acm/contest/7607/A
    // LCM(2, 4, 6, ..., 2n) https://oeis.org/A051426
    // Mangoldt Function https://mathworld.wolfram.com/MangoldtFunction.html
    // a(n) 的因子个数 d(lcm(1,...,n)) https://oeis.org/A056793
    //     这同时也是 1~n 的子集的 LCM 的种类数
    // 另一种通分：「排水系统」的另一种解法 https://zxshetzy.blog.luogu.org/ling-yi-zhong-tong-fen
    // https://oeis.org/A000793	Landau's function g(n): largest order of permutation of n elements
    //                          Equivalently, largest LCM of partitions of n

    static long[] lcms = {
            0, 1, 2, 6, 12, 60, 60, 420, 840, 2520, 2520, // 10
            27720, 27720, 360360, 360360, 360360, 720720, 12252240, 12252240, 232792560, 232792560, // 20
            232792560, 232792560, // 22 (int32)
            5354228880L, 5354228880L, 26771144400L, 26771144400L, 80313433200L, 80313433200L, 2329089562800L, 2329089562800L, // 30
            72201776446800L, 144403552893600L, 144403552893600L, 144403552893600L, 144403552893600L, 144403552893600L,
            5342931457063200L, 5342931457063200L, 5342931457063200L, 5342931457063200L, // 40
            219060189739591200L, 219060189739591200L, // 9419588158802421600,
    };


    // 统计数组的所有子区间的 GCD 的不同个数
    // 代码和题目见 bits.go 中的 bitOpTrick

    // 统计数组的所有子序列的 GCD 的不同个数，复杂度 O(Clog^2C)
    // LC1819 https://leetcode-cn.com/problems/number-of-different-subsequences-gcds/
    // 我的题解 https://leetcode.cn/problems/number-of-different-subsequences-gcds/solution/ji-bai-100mei-ju-gcdxun-huan-you-hua-pyt-get7/
    static int countDifferentSubsequenceGCDs(int[] a) {
        int mx = (int) 4e5;
        boolean[] has = new boolean[mx + 1];
        for (int v : a) {
            has[v] = true;
        }
        int ans = 0;
        for (int i = 1; i <= mx; i++) {
            int g = 0;
            for (int j = i; j <= mx && g != i; j += i) { // 枚举 i的倍数j
                if (has[j]) { // 如果 j在nums中
                    g = gcd(g, j);
                }
                if (g == i) {   // 找到一个答案
                    ans++;
                }
            }
        }
        return ans;
    }
}

/**
 * 质数 质因子分解
 */
class Prime {
    /* 质数 质因子分解 */
// n/2^k https://oeis.org/A000265
// A000265 的前缀和 https://oeis.org/A135013
// a(n) = Sum_{k>=1} (round(n/2^k))^2

// 质数表 https://oeis.org/A000040
// primes[i]%10 https://oeis.org/A007652
// 10-primes[i]%10 https://oeis.org/A072003
// p-1 https://oeis.org/A006093
// p+1 https://oeis.org/A008864
// p^2+p+1 https://oeis.org/A060800 = sigma(p^2)
// prime index prime https://oeis.org/A006450

    static int[] primes = { // 预处理 mask 的见下
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
            307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
            401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
            503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
            601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691,
            701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797,
            809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887,
            907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, /* #=168 */
            1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097,
            1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193,
            1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297,
            1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399,
            1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499,
            1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597,
            1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699,
            1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789,
            1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889,
            1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, /* #=303 */
    };

    // 第 10^k 个素数
    // https://oeis.org/A006988
    // 补充：第 1e5, 2e5, 3e5, ..., 1e6 个素数
    // 1299709, 2750159, 4256233, 5800079, 7368787, 8960453, 10570841, 12195257, 13834103, 15485863
    static long[] primes10k = {
            2, 29, 541, 7919, // k=3
            104729, 1299709, 15485863, // k=6
            179424673, 2038074743, 22801763489L, // k=9
            252097800623L, 2760727302517L, 29996224275833L, // k=12
            323780508946331L, 3475385758524527L, 37124508045065437L, // k=15
            394906913903735329L, 4185296581467695669L,
    };

    // 判断一个数是否为质数
    static boolean isPrime(int n) {
        if (n < 2 || n >= 4 && n % 2 == 0) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 预处理: [2,mx] 范围内的质数
    // 埃筛 埃氏筛 埃拉托斯特尼筛法 Sieve of Eratosthenes
    // 该算法也说明了：前 n 个数的平均质因子数量是 O(loglogn) 级别的
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    // https://oeis.org/A055399 Number of stages of sieve of Eratosthenes needed to identify n as prime or composite
    // https://oeis.org/A230773 Minimum number of steps in an alternate definition of the Sieve of Eratosthenes needed to identify n as prime or composite
    // 质数个数 π(n) https://oeis.org/A000720
    //         π(10^n) https://oeis.org/A006880
    //         4, 25, 168, 1229, 9592, 78498, 664579, 5761455, 50847534, /* 1e9 */
    //         455052511, 4118054813, 37607912018, 346065536839, 3204941750802, 29844570422669, 279238341033925, 2623557157654233, 24739954287740860, 234057667276344607,
    // 思想应用 https://codeforces.com/contest/1646/problem/E
    static void sieve() {
        int mx = (int) 1e6;
        List<Integer> primes = new ArrayList<>();
        // 或者，只是单纯想标记一下
        boolean[] vis = new boolean[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (!vis[i]) {
                primes.add(i);
                vis[i] = true;
                for (int j = i * i; j <= mx; j += i) {
                    vis[j] = true;
                }
            }
        }
    }

    // 线筛 线性筛 欧拉筛
    // 每个合数都从其 LPF 标记到（在遍历到 i = 合数/LPF 的时候，标记这些合数）
    // 参考 https://oi-wiki.org/math/sieve/ 以及进阶指南 p.136-137
    // mx = 3e7 时比埃氏筛大约快 100ms https://codeforces.com/problemset/submission/986/206447142
    //                              https://codeforces.com/problemset/submission/986/206445786
    // https://www.luogu.com.cn/problem/P3383
    static void sieveEuler() {
        int mx = (int) 1e6;
        List<Integer> primes = new ArrayList<>();
        int[] pid = new int[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (pid[i] == 0) {
                pid[i] = primes.size() + 1;
                primes.add(i);
            }
            for (int p : primes) {
                if (p * i > mx) {
                    break;
                }
                pid[p * i] = -1;
                if (i % p == 0) { // 后面的「质数*i」标记出的合数，其 LPF 不是该质数，应及时退出，从而避免重复标记
                    break;
                }
            }
        }
    }

    // 质因数分解（质数及其幂次）prime factorization
    // LC2507 https://leetcode.cn/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
    // LC2584 https://leetcode.cn/problems/split-the-array-to-make-coprime-products/
    static List<Integer> primeDivisors(int x) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i * i <= x; i++) {
            if (x % i > 0) {
                continue;
            }
            // e := 1
            x /= i;
            for (x /= i; x % i == 0; x /= i) {
                // e++
            }
            primes.add(i);
        }
        if (x > 1) {
            // e := 1
            primes.add(x);
        }
        return primes;
    }

    // 枚举一个数的全部因子
    static List<Integer> divisors(int n) {
        List<Integer> ds = new ArrayList<>();
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                ds.add(d);
                if (d * d < n) {
                    ds.add(n / d);
                }
            }
        }
        //sort.Slice(ds, func(i, j int) bool { return ds[i] < ds[j] })
        return ds;
    }

    // 预处理质因子
    // 例如 pf[12] = [2,3]
    // for i>=2, pf[i][0] == i means i is prime
    static void primeFactorsAll() {
        int mx = (int) 1e6;
        List<Integer>[] pf = new List[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (pf[i] == null) {
                pf[i] = new ArrayList<>();
                for (int j = i; j <= mx; j += i) {
                    pf[j].add(i);
                }
            }
        }
    }

    // 欧拉定理
    // 如果 gcd(a,n) = 1，则 a^φ(n) ≡ 1(mod n)
    // 推论：如果 gcd(a,n) = 1，则 a^x ≡ 1(mod n) 的最小正整数解是 φ(n) 的因子（证明见《算法竞赛进阶指南》）
    // LC1015 https://leetcode.cn/problems/smallest-integer-divisible-by-k/ http://poj.org/problem?id=3696
    // https://atcoder.jp/contests/abc222/tasks/abc222_g
    // https://oj.socoding.cn/p/1981

    // 扩展欧拉定理（降幂公式）
    // https://oi-wiki.org/math/fermat/#_5
    // https://zhuanlan.zhihu.com/p/42632291
    // https://blog.csdn.net/synapse7/article/details/19610361
    // a^b ≡ a^(b mod φ(m)) (mod m), gcd(a,m)=1
    // a^b ≡ a^(b mod φ(m) + φ(m)) (mod m), gcd(a,m)!=1 且 b>φ(m)
    // 模板题 https://www.luogu.com.cn/problem/P5091
    // 例题 https://codeforces.com/problemset/problem/615/D
    // https://atcoder.jp/contests/abc228/tasks/abc228_e
    // https://cses.fi/problemset/task/1712
}

/**
 * 同余 逆元
 */
class CongruenceInverse {
    /* 涉及到 0 与逆元的题目（mod 为质数）
		使用场景：计算过程中会有 mod^k * x % mod，但是后面又要除掉 mod^k，得到 x
		        如果直接取模，会得到 0，没法保留 x 的信息
		解决方案：把取模结果用二元组 (k, x) 表示（这里 k>=0，x 与 mod 互质）
		        如果 k>0 那么取模结果是 0
		        如果 k=0 那么取模结果是 x
		乘法运算 (k1, x1) * (k2, x2) = (k1+k2, x1*x2%mod)
		除法运算 (k1, x1) / (k2, x2) = (k1-k2, x1*inv(x2)%mod)  这里 k1>=k2
		加法运算见下面的 add1
		https://codeforces.com/contest/1848/problem/E
		https://codeforces.com/problemset/problem/543/D
		https://ac.nowcoder.com/acm/contest/39759/D

		注：如果 mod 是合数，例如 mod=p*q，可以用三元组 (k1,k2,x) 表示 p^k1 * q^k2 * x % mod，其中 x 与 mod 互质
		如果 k1>0 && k2>0，那么取模结果是 0
		如果 k1==0 || k2==0，那么取模结果是 x*pow(p,k1)%mod*pow(q,k2)%mod
		乘法运算 (k1,k2,x) * (k1',k2',x') = (k1+k1',k2+k2',x*x'%mod)
		除法运算 (k1,k2,x) / (k1',k2',x') = (k1-k1',k2-k2',x*inv(x')%mod)  这里 k1>=k1' && k2>=k2'
		LC2906 https://leetcode.cn/problems/construct-product-matrix/
     */

    // 费马小定理求质数逆元
    // ax ≡ 1 (mod p)
    // x^-1 ≡ a^(p-2) (mod p)
    // 滑窗 https://codeforces.com/contest/1833/problem/F
    static int invP(int a, int p) {
        if (a <= 0) {
            return -1;
        }
        return FastPow.ksmM(a, p - 2, p);
    }

    // 线性求逆元·其一
    // 求 1^-1, 2^-1, ..., (p−1)^-1 mod p
    // http://blog.miskcoo.com/2014/09/linear-find-all-invert
    // https://www.zhihu.com/question/59033693
    // 模板题 https://www.luogu.com.cn/problem/P3811
    static void f() {
        int mod = 998244353;
        int mx = (int) 1e6;
        int[] inv = new int[mx + 1];
        inv[1] = 1;
        for (int i = 2; i <= mx; i++) {
            inv[i] = (mod - mod / i) * inv[mod % i] % mod;
        }
    }

    // 组合数/二项式系数
    // 不取模，仅适用于小范围的 n 和 k
    // https://atcoder.jp/contests/abc202/tasks/abc202_d
    static void initComb() {
        int mx = 60;
        int[][] C = new int[mx + 1][mx + 1];
        for (int i = 0; i <= mx; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }
}

	/* 常用结论 & 题型

	第一类：【有互质约束的计数问题】
	[n == 1] = sum_{d|n} mu(d)
	把 n 替换成 gcd(i,j) 得到 [gcd(i,j) == 1] = sum_{d|gcd(i,j)} mu(d)
	可以整合到其它和式中，解决一类【有互质约束的计数问题】
	例如 sum_i sum_j [gcd(i,j) == 1]
	  = sum_i sum_j sum_{d|gcd(i,j)} mu(d)
	改成先枚举 d，那么 i 和 j 必须是 d 的倍数，才能使 d|gcd(i,j) 成立
	我们可以直接计算这样的 i 和 j 的个数（为什么算法变快了，这是根本原因）
	上式 = sum_d mu(d) * floor(MAX_I/d) * floor(MAX_J/d)，用二维整除分块解决
	题目：
	https://www.luogu.com.cn/problem/P2522 https://www.luogu.com.cn/blog/_post/139077
	https://www.luogu.com.cn/problem/P3455

	第二类：【GCD 求和问题】
	n = sum_{d|n} phi(d)
	把 n 替换成 gcd(i,j) 得到 gcd(i,j) = sum_{d|gcd(i,j)} phi(d)
	可以整合到其它和式中，解决一类【GCD 求和问题】
	例如 sum_i sum_j gcd(i,j)
	  = sum_i sum_j sum_{d|gcd(i,j)} phi(d)
	改成先枚举 d，那么 i 和 j 必须是 d 的倍数，才能使 d|gcd(i,j) 成立
	我们可以直接计算这样的 i 和 j 的个数（为什么算法变快了，这是根本原因）
	上式 = sum_d phi(d) * floor(MAX_I/d) * floor(MAX_J/d)，用二维整除分块解决
	题目：
	https://www.luogu.com.cn/problem/P2398
	https://atcoder.jp/contests/abc162/tasks/abc162_e 1662
	sum_i gcd(i,n) https://www.luogu.com.cn/problem/P2303
	sum_i sum_j gcd(a[i],a[j]) https://codeforces.com/contest/1900/problem/D
	- 改成枚举 a[i] 的因子 ~U^(1/3) https://codeforces.com/blog/entry/122677?#comment-1088190

	n = sum_d d * [n == d]
	gcd(i,j) = sum_d d * [gcd(i,j) == d]
	这样就可以把【GCD 求和】转换成【互质约束计数】了
	*/


/**
 * 容斥原理
 */
class InclusionExclusion {


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 倍数求和>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public static int multiSum(int upper, int num) {
        /**
         [1,upper]内num的倍数的和.
         即num为首项,(upper//num)*num为末项的等差数列和.
         */
        int first = num;
        int last = (upper / num) * num;
        int count = 1 + (last - first) / num;
        return (first + last) * count / 2;
    }

    public static int multiCount(int upper, int num) {
        /** [1,upper]内num的倍数的个数 */
        return upper / num;
    }

//# 闭区间 [0,r] 内模mod与k同余的数的个数
    public static int  modCount(int right, int k, int mod) {
        /** 区间 [0,right] 内模mod与k同余的数的个数 */
//        assert 0 <= k < mod
        return (right - k + mod) / mod;
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    class Solution {
        //https://leetcode.cn/problems/sum-multiples/
        // 6391. 倍数求和
        //给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
        //返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。


        // 设能被3整除的数字集合为A
        // 设能被5整除的数字集合为B
        // 设能被7整除的数字集合为C
        // 根据容斥原理：
        // |A∪B∪C|=|A|+|B|+|C|-|A∩B|-|B∩C|-|A∩C|+|A∩B∩C|
        // |AUB| = |A| + |B| - |A∩B|
        // 其中左边是所有集合的∪，右边是集合的各种搭配，每个搭配都是若干集合的交集
        // 且每一项前面的正负号取决于集合的个数——奇数个数为+，偶数个数为-
        public int sumOfMultiples(int n) {
            /** 请你计算在 [1,n] 范围内能被 3、5、7 整除的所有整数之和。*/
            return multiSum(n, 3)
                    + multiSum(n, 5)
                    + multiSum(n, 7)
                    - multiSum(n, 15)
                    - multiSum(n, 21)
                    - multiSum(n, 35)
                    + multiSum(n, 105);
        }
    }
}