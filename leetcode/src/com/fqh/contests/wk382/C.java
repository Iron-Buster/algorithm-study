package com.fqh.contests.wk382;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/28 10:25
 **/
public class C {

    public long flowerGame(int n, int m) {
        if (n == 1 && m == 1) return 0; // 无法获胜
        if (n == m) return 0;
        long res1 = 0; // 顺时针取奇数
        long res2 = 0; // 逆时针取偶数数量
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) res1++;
        }
        for (int i = 1; i <= m; i++) {
            if (i % 2 == 0) res2++;
        }
        long ans1 = res1 * res2;

        res1 = 0; // 顺时针取偶数
        res2 = 0; // 逆时针取奇数数量
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) res1++;
        }
        for (int i = 1; i <= m; i++) {
            if (i % 2 == 1) res2++;
        }
        long ans2 = res1 * res2;
        return ans1 + ans2;
    }
    public static void main(String[] args) {
        System.out.println(new C().flowerGame(1, 5));
    }
}
