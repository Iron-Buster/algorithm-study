package com.fqh.动态规划.第I类区间DP;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 14:21
 **/
public class LC_2478 {

//    2478. 完美分割的方案数
//    第 320 场周赛
//            Q4
//    2344
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s ，每个字符是数字 '1' 到 '9' ，再给你两个整数 k 和 minLength 。
//
//    如果对 s 的分割满足以下条件，那么我们认为它是一个 完美 分割：
//
//    s 被分成 k 段互不相交的子字符串。
//    每个子字符串长度都 至少 为 minLength 。
//    每个子字符串的第一个字符都是一个 质数 数字，最后一个字符都是一个 非质数 数字。质数数字为 '2' ，'3' ，'5' 和 '7' ，剩下的都是非质数数字。
//    请你返回 s 的 完美 分割数目。由于答案可能很大，请返回答案对 109 + 7 取余 后的结果。
//
//    一个 子字符串 是字符串中一段连续字符串序列。
    static final int MOD = (int) (1e9 + 7);
    static boolean check(int x) {
        return x == 2 || x == 3 || x == 5 || x == 7;
    }

    static boolean ok(int j, int i, char[] s, int minLength) {
        return i - j + 1 >= minLength && check(s[j]) && !check(s[i]);
    }

    public int beautifulPartitions(String s, int k, int minLength) {
        int N = s.length();
        int K = k;
        char[] cs = new char[N+1];
        for (int i = 0; i < N; i++) cs[i+1] = s.charAt(i);
        int[][] f = new int[N+1][K+1];
        for (int i = 1; i <= N; i++) {
            f[i][1] = ok(1, i, cs, minLength) ? 1 : 0;
        }
        for (int i = 1; i <= N; i++) {
            for (k = 2; k <= Math.min(i, K); k++) {
                for (int j = i; j >= k; j--) {
                    f[i][k] += f[j-1][k-1] + (ok(j, i, cs, minLength) ? 1 : 0);
                }
            }
        }
        return f[N][K];
    }

    // s = "23542185131", k = 3, minLength = 2
    public static void main(String[] args) {
        String s = "3312958";
        int k = 3;
        int minLength = 1;
        System.out.println(new LC_2478().beautifulPartitions(s, k, minLength));
    }
}
