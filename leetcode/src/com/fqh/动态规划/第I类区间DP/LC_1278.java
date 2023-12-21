package com.fqh.动态规划.第I类区间DP;

/**
 * @Author: vq
 * @Date: 2023/12/21 21:53
 * @Version V1.0
 */
public class LC_1278 {

    char[] s;
    public int palindromePartition(String ss, int k) {
        int N = ss.length();
        int K = k;
        ss = " " + ss;
        s = ss.toCharArray();
        int[][] f = new int[N + 1][K + 1]; // f[i][k]表示将s[1:i]分成k个回文子串的最小修改字符数
        for (int i = 1; i <= N; i++) {     // 初始化 k=1 的时候 f[i][k]的值
            f[i][1] = calc(1, i);
        }
        for (int i = 1; i <= N; i++) {
            for (k = 2; k <= Math.min(i, K); i++) {
                f[i][k] = 0x3f3f3f;
                for (int j = i; j >= k; j--) {
                    f[i][k] = Math.min(f[i][k], f[j - 1][k - 1] + calc(j, i));
                }
            }
        }
        return f[N][K];
    }


    // 计算将s[j:i]变成回文串的最少修改字符数
    int calc(int j, int i) {
       int cnt = 0;
       for (; j < i; j++, i--) {
           if (s[i] != s[j]) cnt++;
       }
       return cnt;
    }

//    1278. 分割回文串 III
//    已解答
//    第 165 场周赛
//            Q4
//    1979
//    相关标签
//            相关企业
//    提示
//    给你一个由小写字母组成的字符串 s，和一个整数 k。
//
//    请你按下面的要求分割字符串：
//
//    首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
//    接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
//    请返回以这种方式分割字符串所需修改的最少字符数。
}
