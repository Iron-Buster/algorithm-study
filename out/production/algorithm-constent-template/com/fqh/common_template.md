枚举右，维护左

- [1. 两数之和](https://leetcode.cn/problems/two-sum/)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v)) {
                return new int[]{map.get(v), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
```

- [CF.702B]https://codeforces.com/problemset/problem/702/B

```java
import java.util.HashMap;

class CF_702B {
    //  给你 n 个整数 a1,a2,...,an 。求 ai+aj 是 2 的幂的索引 i,j ( i<j )对的个数。(即存在某个整数 x 以便 ai+aj=2x ）。
    public long solve(long[] a) {
        var map = new HashMap<Long, Integer>();
        long ans = 0;
        for (int i = 0; i < a.length; ++i) {
            long x = a[i];
            for (int j = 0; j < 32; ++j) { // 枚举2的幂
                ans += map.getOrDefault((1 << j) - x, 0);
            }
            map.merge(x, 1, Integer::sum);
        }
        return ans;
    }
}
```

- [219. 存在重复元素 II](https://leetcode.cn/problems/contains-duplicate-ii/)
- [121. 买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)
- [1512. 好数对的数目](https://leetcode.cn/problems/number-of-good-pairs/) 1161

```java
import java.util.HashMap;

//给你一个整数数组 nums 。
//如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
//返回好数对的数目。
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        var map = new int[101];
        for (int x : nums) {
            ans += map[x];
            map[x]++;
        }
        return ans;
    }
}
```

- [2815. 数组中的最大数对和](https://leetcode.cn/problems/max-pair-sum-in-an-array/) 1295
- [2748. 美丽下标对的数目](https://leetcode.cn/problems/number-of-beautiful-pairs/) 1301

```java
//给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length,
// 如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质(gcd(x,y) == 1) ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
//返回 nums 中 美丽下标对 的总数目。
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        var cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y < 10; y++)
                if (cnt[y] > 0 && gcd(x % 10, y) == 1)
                    ans += cnt[y];
            while (x >= 10) x /= 10; // 这里需要 O(log x) 的时间
            cnt[x]++; // 统计最高位的出现次数
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
```

- [2342. 数位和相等数对的最大和](https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/) 1309

```java
import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        int ans = -1;
        for (int x : nums) {
            int s = 0;
            int num = x;
            for (; num > 0; num /= 10) {
                s += num % 10;
            }
            if (map.containsKey(s)) {
                ans = Math.max(ans, map.get(s) + x);
                if (map.get(s) < x) {
                    map.put(s, x);
                }
            } else {
                map.put(s, x);
            }
        }
        return ans;
    }
}
```

- [1010. 总持续时间可被 60 整除的歌曲](https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/)
  1377

```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        var map = new int[60];
        int ans = 0;
        for (int x : time) {
            ans += map[(60 - x % 60) % 60];
            map[x % 60]++;
        }
        return ans;
    }
}
```

- [2874. 有序三元组中的最大值 II](https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/) 1583

```java
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n == 3) {
            long v = (long) (nums[0] - nums[1]) * nums[2];
            return v < 0 ? 0 : v;
        }
        long ans = Long.MIN_VALUE;
        var prefix = new long[n];
        var suffix = new long[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) prefix[i] = nums[i];
            else prefix[i] = Math.max(prefix[i - 1], nums[i - 1]);
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) suffix[i] = nums[i];
            else suffix[i] = Math.max(suffix[i + 1], nums[i + 1]);
        }
        for (int j = 1; j < n - 1; ++j) {
            long a = prefix[j];
            long c = suffix[j];
            ans = Math.max(ans, (a - nums[j]) * c);
        }
        return ans < 0 ? 0 : ans;
    }
}
```

巧妙安排更新顺序，使得 ans，pre_max 只能使用之前的值，从而符合 i<j<k 的要求
https://leetcode.com/discuss/interview-question/3685049/25-variations-of-Two-sum-question

前后缀分解

- [238. 除自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self/)

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; ++i) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; ++i) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }
}
```

- [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/)（[视频讲解](https://www.bilibili.com/video/BV1Qg411q7ia/?t=3m05s)）
- [2906. 构造乘积矩阵](https://leetcode.cn/problems/construct-product-matrix/)
```java
class Solution {
    static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        int suf = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                ans[i][j] = suf;
                suf = suf * grid[i][j] % MOD;
            }
        }
        int pre = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ans[i][j] = ans[i][j] * pre % MOD;
                pre = pre * grid[i][j] % MOD;
            }
        }
        return ans;
    }
}
```
- [2256. 最小平均差](https://leetcode.cn/problems/minimum-average-difference/) 1395
- [2483. 商店的最少代价](https://leetcode.cn/problems/minimum-penalty-for-a-shop/) 1495
- [2909. 元素和最小的山形三元组 II](https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/)
- [2874. 有序三元组中的最大值 II](https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/) 1583
- [2420. 找到所有好下标](https://leetcode.cn/problems/find-all-good-indices/) 1695
- [2167. 移除所有载有违禁货物车厢所需的最少时间](https://leetcode.cn/problems/minimum-time-to-remove-all-cars-containing-illegal-goods/)
  2219 *DP
- [2484. 统计回文子序列数目](https://leetcode.cn/problems/count-palindromic-subsequences/) 2223
- [2565. 最少得分子序列](https://leetcode.cn/problems/subsequence-with-the-minimum-score/) 2432
- [2552. 统计上升四元组](https://leetcode.cn/problems/count-increasing-quadruplets/) 2433



