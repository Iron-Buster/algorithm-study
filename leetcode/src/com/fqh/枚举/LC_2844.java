package com.fqh.枚举;

//https://leetcode.cn/problems/minimum-operations-to-make-a-special-number/description/
public class LC_2844 {
    
    public int minimumOperations(String num) {
        // A number is divisible by 25 if its last two digits are 75, 50, 25, or 00.
        int res1 = num.length() - (num.contains("0") ? 1 : 0); // 01这种case
        int res2 = Math.min(
                Math.min(f(num, 7, 5), f(num, 5, 0)),
                Math.min(f(num, 2, 5), f(num, 0, 0)));
        return Math.min(res1, res2);
    }

    public int f(String num, int x, int y) {
        int ans = 0x3f3f3f;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' == x) {
                for (int j = i + 1; j < num.length(); j++) {
                    if (num.charAt(j) - '0' == y) {
                        int d1 = num.length() - j - 1;
                        int d2 = j - i - 1;
                        ans = Math.min(ans, d1 + d2);
                    }
                }
            }
        }
        return ans;
    }
}
