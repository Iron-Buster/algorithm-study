package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/14 16:41
 * @Version V1.0
 */

import java.io.*;
import java.util.*;

/**
 * 基础算法
 */
public class CommonTemplate {

    // 上取整
    static int ceil(int a, int b) {
        return (a + b - 1) / b;
    }

    // 顺时针旋转矩阵 90°
    // 返回一个拷贝
    static int[][] rotateCopy(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] b = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[j][n - 1 - i] = a[i][j];
            }
        }
        return b;
    }

    // 从低位到高位
    static List<Integer> toAnyBase(int x, int base) {
        List<Integer> ans = new ArrayList<>();
        while (x > 0) {
            ans.add(x % base);
            x /= base;
        }
        return ans;
    }

    static List<Integer> digits(int x) {
        List<Integer> ans = new ArrayList<>();
        while (x > 0) {
            ans.add(x % 10);
            x /= 10;
        }
        return ans;
    }

    // 合并有序数组，保留重复元素
    // a b 必须是有序的（可以为空）
    static List<Integer> merge(int[] a, int[] b) {
        int i = 0, n = a.length;
        int j = 0, m = b.length;
        List<Integer> res = new ArrayList<>();
        while (true) {
            if (i == n) {
                while (j < m) {
                    res.add(b[j++]);
                }
                return res;
            }
            if (j == m) {
                while (i < n) {
                    res.add(a[i++]);
                }
                return res;
            }
            if (a[i] < b[j]) { // 改成 > 为降序
                res.add(a[i++]);
            } else {
                res.add(b[j++]);
            }
        }
    }

}


//枚举右，维护左
//        - [1. 两数之和](https://leetcode.cn/problems/two-sum/)
//        - https://codeforces.com/problemset/problem/702/B
//        - [219. 存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/)
//        - [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)
//        - [1512. 好数对的数目](https://leetcode.cn/problems/number-of-good-pairs/) 1161
//        - [2815. 数组中的最大数对和](https://leetcode.cn/problems/max-pair-sum-in-an-array/) 1295
//        - [2748. 美丽下标对的数目](https://leetcode.cn/problems/number-of-beautiful-pairs/) 1301
//        - [2342. 数位和相等数对的最大和](https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/) 1309
//        - [1010. 总持续时间可被 60 整除的歌曲](https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/) 1377
//        - [2874. 有序三元组中的最大值 II](https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/) 1583
//        巧妙安排更新顺序，使得 ans，pre_max 只能使用之前的值，从而符合 i<j<k 的要求
//        https://leetcode.com/discuss/interview-question/3685049/25-variations-of-Two-sum-question

//哈希表
//        - [2260. 必须拿起的最小连续卡牌数](https://leetcode.cn/problems/minimum-consecutive-cards-to-pick-up/) 1365
//        - [982. 按位与为零的三元组](https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/) 2085
//

class PrefixSum {
//        前缀和
//        - [1732. 找到最高海拔](https://leetcode.cn/problems/find-the-highest-altitude/)
//        - [303. 区域和检索 - 数组不可变](https://leetcode.cn/problems/range-sum-query-immutable/)
//        - [1310. 子数组异或查询](https://leetcode.cn/problems/xor-queries-of-a-subarray/)
//        - [2615. 等值距离和](https://leetcode.cn/problems/sum-of-distances/) 1793
//        - [2602. 使数组元素全部相等的最少操作次数](https://leetcode.cn/problems/minimum-operations-to-make-all-array-elements-equal/) 1903
//
//        前缀和+哈希表（双变量思想）
//        - [930. 和相同的二元子数组](https://leetcode.cn/problems/binary-subarrays-with-sum/) 1592  *同 560
//        - [560. 和为 K 的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/)
//        - [1524. 和为奇数的子数组数目](https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/) 1611
//        - [974. 和可被 K 整除的子数组（数目）](https://leetcode.cn/problems/subarray-sums-divisible-by-k/) 1676
//        - 变形：乘积可以被 k 整除
//        - a[i] = gcd(a[i], k) 之后窗口乘积是 k 的倍数就行，不会乘爆
//        - [523. 连续的子数组和（长度至少为 2 且可被 K 整除）](https://leetcode.cn/problems/continuous-subarray-sum/)
//        - [1590.（移除最短子数组）使数组和能被 P 整除](https://leetcode.cn/problems/make-sum-divisible-by-p/) 2039
//        - [525. 连续数组](https://leetcode.cn/problems/contiguous-array/) *转换
//        - [1124. 表现良好的最长时间段](https://leetcode.cn/problems/longest-well-performing-interval/) 1908 *转换
//        - [2488. 统计中位数为 K 的子数组](https://leetcode.cn/problems/count-subarrays-with-median-k/) 1999 *转换
//        - [2949. 统计美丽子字符串 II](https://leetcode.cn/problems/count-beautiful-substrings-ii/)
//        - [2489. 固定比率的子字符串数](https://leetcode.cn/problems/number-of-substrings-with-fixed-ratio/)（会员题）
//        https://atcoder.jp/contests/abc233/tasks/abc233_d

//    前缀和思想 LC1523 https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/
//        有点数形结合 https://codeforces.com/problemset/problem/1748/C
//
//        前缀和的前缀和（二重前缀和）
//        LC2281 https://leetcode.cn/problems/sum-of-total-strength-of-wizards/
//        https://atcoder.jp/contests/abc058/tasks/arc071_b
//
//        前缀和+异或
//        - [1177. 构建回文串检测](https://leetcode.cn/problems/can-make-palindrome-from-substring/)
//        - [1371. 每个元音包含偶数次的最长子字符串](https://leetcode.cn/problems/find-the-longest-substring-containing-vowels-in-even-counts/)
//        - [1542. 找出最长的超赞子字符串](https://leetcode.cn/problems/find-longest-awesome-substring/)
//        - [1915. 最美子字符串的数目](https://leetcode.cn/problems/number-of-wonderful-substrings/)，[题解](https://leetcode.cn/problems/number-of-wonderful-substrings/solution/qian-zhui-he-chang-jian-ji-qiao-by-endle-t57t/)
//        https://atcoder.jp/contests/abc295/tasks/abc295_d
//        模 3 & 字符集大小为 n https://codeforces.com/problemset/problem/1418/G
//
//        https://leetcode.cn/problems/find-longest-subarray-lcci/
//        https://codeforces.com/problemset/problem/1296/C


    // 前缀和
    static int[] prefixSum(int[] a) {
        int[] sum = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        return sum;
    }

    // 后缀和
    static int[] suffixSum(int[] a) {
        int[] sum = new int[a.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + a[i];
        }
        return sum;
    }

    // 二维前缀和     sum2d
    // LC221 https://leetcode.cn/problems/maximal-square/
    // LC1277 https://leetcode.cn/problems/count-square-submatrices-with-all-ones/
    // LC1504 https://leetcode.cn/problems/count-submatrices-with-all-ones/
    // 自加写法 https://codeforces.com/contest/835/submission/120031673
    // https://codeforces.com/contest/1107/problem/D
    // https://codeforces.com/problemset/problem/1731/D
    // https://codeforces.com/problemset/problem/611/C

    static int[][] matrixSum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] g = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1;
                int y = j + 1;
                g[x][y] = a[i][j] + g[x-1][y] + g[x][y-1] - g[x-1][y-1];
            }
        }
        return g;
    }

    // 类似前缀和的左闭右开
    // r1<=r<r2 && c1<=c<c2
    static int query(int x1, int y1, int x2, int y2, int[][] g) {
        // 求某一段区域和 [i, j] 的模板是 sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];（模板部分）
        x1++; y1++; x2++; y2++;
        return g[x2][y2] - g[x1-1][y2] - g[x2][y1-1] + g[x1-1][y1-1];
    }
}

class Prefix_Suffix {
//前后缀分解
//        - [238. 除自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/)
//        - [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/)（[视频讲解](https://www.bilibili.com/video/BV1Qg411q7ia/?t=3m05s)）
//        注：带修改的接雨水 https://codeforces.com/gym/104821/problem/M
//        - https://www.zhihu.com/question/627281278/answer/3280684055
//        - [2906. 构造乘积矩阵](https://leetcode.cn/problems/construct-product-matrix/)
//        - [2256. 最小平均差](https://leetcode.cn/problems/minimum-average-difference/) 1395
//        - [2483. 商店的最少代价](https://leetcode.cn/problems/minimum-penalty-for-a-shop/) 1495
//        - [2909. 元素和最小的山形三元组 II](https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/)
//        - [2874. 有序三元组中的最大值 II](https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/) 1583
//        - [2420. 找到所有好下标](https://leetcode.cn/problems/find-all-good-indices/) 1695
//        - [2167. 移除所有载有违禁货物车厢所需的最少时间](https://leetcode.cn/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/) 2219 *DP
//        - [2484. 统计回文子序列数目](https://leetcode.cn/problems/count-palindromic-subsequences/) 2223
//        - [2565. 最少得分子序列](https://leetcode.cn/problems/subsequence-with-the-minimum-score/) 2432
//        - [2552. 统计上升四元组](https://leetcode.cn/problems/count-increasing-quadruplets/) 2433
}

class SlidingWindow {
//#### 定长滑动窗口
//        - [1456. 定长子串中元音的最大数目](https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) 1263
//        - [2269. 找到一个数字的 K 美丽值](https://leetcode.cn/problems/find-the-k-beauty-of-a-number/) 1280
//        - [1984. 学生分数的最小差值](https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/) 1306
//        - [643. 子数组最大平均数 I](https://leetcode.cn/problems/maximum-average-subarray-i/)
//        - [1343. 大小为 K 且平均值大于等于阈值的子数组数目](https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/) 1317
//        - [2090. 半径为 k 的子数组平均值](https://leetcode.cn/problems/k-radius-subarray-averages/) 1358
//        - [2379. 得到 K 个黑块的最少涂色次数](https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/) 1360
//        - [1052. 爱生气的书店老板](https://leetcode.cn/problems/grumpy-bookstore-owner/) 1418
//        - [2841. 几乎唯一子数组的最大和](https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/) 1546
//        - [2461. 长度为 K 子数组中的最大和](https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/) 1553
//        - [1423. 可获得的最大点数](https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/) 1574
//        - [2134. 最少交换次数来组合所有的 1 II](https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii/) 1748
//        - [2653. 滑动子数组的美丽值](https://leetcode.cn/problems/sliding-subarray-beauty/) 1786
//        - [567. 字符串的排列](https://leetcode.cn/problems/permutation-in-string/)
//        - [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)
//        - [2156. 查找给定哈希值的子串](https://leetcode.cn/problems/find-substring-with-given-hash-value/) 2063
//        - [346. 数据流中的移动平均值](https://leetcode.cn/problems/moving-average-from-data-stream/)（会员题）
//        - [1100. 长度为 K 的无重复字符子串](https://leetcode.cn/problems/find-k-length-substrings-with-no-repeated-characters/)（会员题）
//        - [1852. 每个子数组的数字种类数](https://leetcode.cn/problems/distinct-numbers-in-each-subarray/)（会员题）
//        https://codeforces.com/problemset/problem/69/E 1800
//
//        #### 不定长滑动窗口（求最长/最大）
//        - [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)
//        - [1493. 删掉一个元素以后全为 1 的最长子数组](https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/) 1423
//        - [904. 水果成篮](https://leetcode.cn/problems/fruit-into-baskets/) 1516
//        - [1695. 删除子数组的最大得分](https://leetcode.cn/problems/maximum-erasure-value/) 1529
//        - [2841. 几乎唯一子数组的最大和](https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/) 1546
//        - [2024. 考试的最大困扰度](https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/) 1643
//        - [1004. 最大连续1的个数 III](https://leetcode.cn/problems/max-consecutive-ones-iii/) 1656
//        - [1438. 绝对差不超过限制的最长连续子数组](https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) 1672  *需要 SortedList
//        - [2401. 最长优雅子数组](https://leetcode.cn/problems/longest-nice-subarray/) 1750  *位运算
//        - [1658. 将 x 减到 0 的最小操作数](https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/) 1817
//        - [1838. 最高频元素的频数](https://leetcode.cn/problems/frequency-of-the-most-frequent-element/) 1876
//        - [2831. 找出最长等值子数组](https://leetcode.cn/problems/find-the-longest-equal-subarray/) 1976
//        - [2106. 摘水果](https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/) 2062
//        - [1610. 可见点的最大数目](https://leetcode.cn/problems/maximum-number-of-visible-points/) 2147
//        - [159. 至多包含两个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/)（会员题）
//        - [340. 至多包含 K 个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/)（会员题）
//
//        #### 不定长滑动窗口（求最短/最小）
//        - [209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum/)
//        - [1234. 替换子串得到平衡字符串](https://leetcode.cn/problems/replace-the-substring-for-balanced-string/) 1878
//        - [1574. 删除最短的子数组使剩余数组有序](https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/) 1932
//        - [76. 最小覆盖子串](https://leetcode.cn/problems/minimum-window-substring/)
//        https://codeforces.com/problemset/problem/701/C
//
//        #### 不定长滑动窗口（求子数组个数）
//        - [2799. 统计完全子数组的数目](https://leetcode.cn/problems/count-complete-subarrays-in-an-array/) 1398
//        - [713. 乘积小于 K 的子数组](https://leetcode.cn/problems/subarray-product-less-than-k/)
//        - [1358. 包含所有三种字符的子字符串数目](https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/) 1646
//        - [2302. 统计得分小于 K 的子数组数目](https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/) 1808
//        - [2537. 统计好子数组的数目](https://leetcode.cn/problems/count-the-number-of-good-subarrays/) 1892
//        - [2762. 不间断子数组](https://leetcode.cn/problems/continuous-subarrays/) 1940
//        - [2743. 计算没有重复字符的子字符串数量](https://leetcode.cn/problems/count-substrings-without-repeating-character/)（会员题）
//        和至少为 k 的子数组个数 https://atcoder.jp/contests/abc130/tasks/abc130_d
//
//        #### 多指针滑动窗口
//        - [930. 和相同的二元子数组](https://leetcode.cn/problems/binary-subarrays-with-sum/) 1592
//        - [1248. 统计「优美子数组」](https://leetcode.cn/problems/count-number-of-nice-subarrays/) 1624
//        - [2563. 统计公平数对的数目](https://leetcode.cn/problems/count-the-number-of-fair-pairs/) 1721
//        - [1712. 将数组分成三个子数组的方案数](https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/) 2079
//        - [2444. 统计定界子数组的数目](https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/) 2093
//        - [992. K 个不同整数的子数组](https://leetcode.cn/problems/subarrays-with-k-different-integers/) 2210
//
//        入门题 https://codeforces.com/problemset/problem/602/B
//        入门题 https://codeforces.com/problemset/problem/279/B
//        https://atcoder.jp/contests/abc229/tasks/abc229_d
//        LC424 替换后的最长重复字符 有些特殊的滑窗 https://leetcode.cn/problems/longest-repeating-character-replacement/
//        LC2271 毯子覆盖的最多白色砖块数 需要多思考一点点 https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/
//        - https://atcoder.jp/contests/abc098/tasks/arc098_b
//        较为复杂 https://atcoder.jp/contests/abc294/tasks/abc294_e
//        - https://ac.nowcoder.com/acm/contest/62033/D
//        https://codeforces.com/problemset/problem/1208/B
//        https://codeforces.com/problemset/problem/1765/D
//        多指针 https://codeforces.com/problemset/problem/895/B
//        https://codeforces.com/contest/1833/problem/F
//        计算有多少子数组，其中有至少 k 个相同的数 https://codeforces.com/problemset/problem/190/D
//        mex https://atcoder.jp/contests/abc194/tasks/abc194_e
//        https://codeforces.com/problemset/problem/165/C
}

//双序列双指针
//        LC88 https://leetcode.cn/problems/merge-sorted-array/
//        LC360（背向双指针）https://leetcode.cn/problems/sort-transformed-array/
//        LC986 区间列表的交集 https://leetcode.cn/problems/interval-list-intersections/
//
//        相向双指针
//        LC2824 https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/
//        LC923 https://leetcode.cn/problems/3sum-with-multiplicity/
//        https://www.facebook.com/codingcompetitions/hacker-cup/2023/practice-round/problems/C
//
//        同时用到同向双指针和相向双指针的题
//        https://atcoder.jp/contests/abc155/tasks/abc155_d
//        - 相似题目 https://leetcode.cn/problems/kth-smallest-product-of-two-sorted-arrays/
//
//        a[i] + b[j] = target 的方案数
//        a[i] + b[j] < target 的方案数    相向双指针 https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/
//        a[i] + b[j] > target 的方案数    同上
//        a[i] - b[j] = target 的方案数
//        a[i] - b[j] < target 的方案数    滑窗
//        a[i] - b[j] > target 的方案数    同上
//        子数组元素和 = < > target 的方案数：用前缀和，转换成上面 a[i] - b[j] 的形式
//        子序列元素和 = < > target 的方案数：0-1 背包恰好/至多/至少，见 https://www.bilibili.com/video/BV16Y411v7Y6/ 末尾的总结


class GroupLoop {

//## 分组循环
//
//        https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/solution/jiao-ni-yi-ci-xing-ba-dai-ma-xie-dui-on-zuspx/
//
//        **适用场景**：按照题目要求，数组会被分割成若干组，每一组的判断/处理逻辑是相同的。
//
//        **核心思想**：
//
//        - 外层循环负责遍历组之前的准备工作（记录开始位置），和遍历组之后的统计工作（更新答案最大值）。
//        - 内层循环负责遍历组，找出这一组最远在哪结束。
//
//        这个写法的好处是，各个逻辑块分工明确，也不需要特判最后一组（易错点）。以我的经验，这个写法是所有写法中最不容易出 bug 的，推荐大家记住。
//
//        - [1446. 连续字符](https://leetcode.cn/problems/consecutive-characters/) AC
//        - [1869. 哪种连续子字符串更长](https://leetcode.cn/problems/longer-contiguous-segments-of-ones-than-zeros/) AC
//        - [1957. 删除字符使字符串变好](https://leetcode.cn/problems/delete-characters-to-make-fancy-string/)    AC
//        - [228. 汇总区间](https://leetcode.cn/problems/summary-ranges/) AC
//        - [2038. 如果相邻两个颜色均相同则删除当前颜色](https://leetcode.cn/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/) AC
//        - [1759. 统计同质子字符串的数目](https://leetcode.cn/problems/count-number-of-homogenous-substrings/) AC
//        - [2110. 股票平滑下跌阶段的数目](https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/) AC
//        - [1578. 使绳子变成彩色的最短时间](https://leetcode.cn/problems/minimum-time-to-make-rope-colorful/)
//        - [1839. 所有元音按顺序排布的最长子字符串](https://leetcode.cn/problems/longest-substring-of-all-vowels-in-order/) AC
//        - [2760. 最长奇偶子数组](https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/) AC
//        - [2765. 最长交替子序列](https://leetcode.cn/problems/longest-alternating-subarray/) AC
//        - [795. 区间子数组个数](https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/) AC
//        LC1887 https://leetcode.cn/problems/reduction-operations-to-make-the-array-elements-equal/
//        LC1180（会员）https://leetcode.cn/problems/count-substrings-with-only-one-distinct-letter/
//        LC2257 https://leetcode.cn/problems/count-unguarded-cells-in-the-grid/
//        - https://atcoder.jp/contests/abc317/tasks/abc317_e
//        LC2495（会员）逆向思维 https://leetcode.cn/problems/number-of-subarrays-having-even-product/
//        https://codeforces.com/problemset/problem/1380/C 1400
//        https://codeforces.com/problemset/problem/525/C 1600
//        https://codeforces.com/problemset/problem/1748/C 1600
}

class GreedyAlgorithm {

//中位数贪心（右边数字为难度分）
//        - [462. 最小操作次数使数组元素相等 II](https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/)
//        - [2033. 获取单值网格的最小操作数](https://leetcode.cn/problems/minimum-operations-to-make-a-uni-value-grid/) 1672
//        - [2448. 使数组相等的最小开销](https://leetcode.cn/problems/minimum-cost-to-make-array-equal/) 2005
//        - [2607. 使子数组元素和相等](https://leetcode.cn/problems/make-k-subarray-sums-equal/) 2071
//        - [1703. 得到连续 K 个 1 的最少相邻交换次数](https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/) 2467
//        https://codeforces.com/problemset/problem/710/B 1400
}


//《灵茶八题》
//        完整题目列表 & 题解
//        https://www.luogu.com.cn/blog/endlesscheng/post-ling-cha-ba-ti-ti-mu-lie-biao
//        + 表示元素和
//        ^ 表示异或和
//        所有子数组的 + 的 +
//        所有子数组的 ^ 的 ^
//        所有子数组的 ^ 的 +
//        所有子数组的 + 的 ^
//        所有子序列的 + 的 +
//        所有子序列的 ^ 的 ^
//        所有子序列的 ^ 的 +
//        所有子序列的 + 的 ^
//        所有子数组的 ^2 的 + 的 + https://www.nowcoder.com/feed/main/detail/857f180290cd402ea2461b85e94b3db9
//        - 这里 ^2 表示任意两个数的异或


class OfflineQuery {
    /*
## 练习：离线（按难度分排序）

> 由于所有的询问数据都给出了，我们可以通过修改询问的顺序，达到降低时间复杂度的效果。相应的，在线算法就是按照输入的顺序处理，来一个处理一个。

- [2343. 裁剪数字后查询第 K 小的数字](https://leetcode.cn/problems/query-kth-smallest-trimmed-number/) 1652
- [2070. 每一个查询的最大美丽值](https://leetcode.cn/problems/most-beautiful-item-for-each-query/) 1724
- [2503. 矩阵查询可获得的最大分数](https://leetcode.cn/problems/maximum-number-of-points-from-grid-queries/) 2196
- [1851. 包含每个查询的最小区间](https://leetcode.cn/problems/minimum-interval-to-include-each-query/) 2286
- [1697. 检查边长度限制的路径是否存在](https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/) 2300
- [2747. 统计没有收到请求的服务器数目](https://leetcode.cn/problems/count-zero-request-servers/)
- [1938. 查询最大基因差](https://leetcode.cn/problems/maximum-genetic-difference-query/) 2503
- [2736. 最大和查询](https://leetcode.cn/problems/maximum-sum-queries/) 2533
*/
}

/**
 * 灵茶8题
 */
class LingChaBaTi {

    //子数组 +w+
    //https://www.luogu.com.cn/problem/U360300
    static class A {
        public static void solve() throws IOException {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += a[i] * (i + 1) * (n - i);
            }
            out.println(ans);
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
}


/**
 * 离散化：用于处理值域较大的数组
 */
class Discretization {

    public static Map<Integer, Integer> f(int[] a) {
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : a) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        return map;
    }
}