package com.fqh;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/11/24 11:59
 * @Version V1.0
 */
public class DigitalDpTemplate {

    public static void main(String[] args) {

    }
}

// 不考虑前导零影响的一种题型
class Version1 {
    char s[];
    int dp[][];

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        var m = s.length;
        dp = new int[m][m];
        for (var i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    int f(int i, int cnt1, boolean isLimit) {
        if (i == s.length) return cnt1;
        if (!isLimit && dp[i][cnt1] >= 0) return dp[i][cnt1];
        var res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) // 枚举要填入的数字 d
            res += f(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
        if (!isLimit) dp[i][cnt1] = res;
        return res;
    }
}

// 考虑前导零影响的一种题型
class Version2 {
    char s[];
    int memo[][];

    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        return n - f(0, 0, true, false);
    }

    int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
        if (!isLimit && isNum && memo[i][mask] != -1)
            return memo[i][mask];
        int res = 0;
        if (!isNum) // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
        for (int d = isNum ? 0 : 1; d <= up; ++d) // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) // d 不在 mask 中
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
        if (!isLimit && isNum)
            memo[i][mask] = res;
        return res;
    }
}
