package com.fqh.contests.wk420;

public class C {

    public int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            while (nums[i] < nums[i-1]) {
                int mx = primeDivisors(nums[i-1]);
                if (mx == 1) return -1; // 无法减小nums[i-1]
                nums[i-1] /= mx;
                ans++;
                if (nums[i-1] < 1) return -1;
            }
        }
        return ans;
    }

    // 分解质因数
    static int primeDivisors(int x) {
        if (x <= 1) return 1;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return x / i;
        }
        return 1;
    }
}
