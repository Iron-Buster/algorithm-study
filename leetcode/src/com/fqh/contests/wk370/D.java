package com.fqh.contests.wk370;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/11/4 21:18
 * @Version V1.0
 */
public class D {

    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i] = nums[i] - i;
        }
        Arrays.sort(b);
        BIT t = new BIT(n + 1);
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            // j 为 nums[i]-i 离散化后的值（从 1 开始）
            int j = Arrays.binarySearch(b, nums[i] - i) + 1;
            long f = Math.max(t.preMax(j), 0) + nums[i];
            ans = Math.max(ans, f);
            t.update(j, f);
        }
        return ans;

    }

    // 树状数组模板（维护前缀最大值）
    class BIT {
        private long[] tree;

        public BIT(int n) {
            tree = new long[n];
            Arrays.fill(tree, Long.MIN_VALUE);
        }

        public void update(int i, long val) {
            while (i < tree.length) {
                tree[i] = Math.max(tree[i], val);
                i += i & -1;
            }
        }

        public long preMax(int i) {
            long res = Long.MIN_VALUE;
            while (i > 0) {
                res = Math.max(res, tree[i]);
                i &= i - 1;
            }
            return res;
        }
    }
    public static void main(String[] args) {

    }
}
