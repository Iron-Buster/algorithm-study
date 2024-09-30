package com.fqh.位运算;

public class LC_3307 {

    // https://leetcode.cn/contest/weekly-contest-417/problems/find-the-k-th-character-in-string-game-ii/

    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        return f(k, operations, n - 1);
    }

    char f(long k, int[] operations, int i) {
        if (i < 0) return 'a';
        int op = operations[i];
        long m = 1L << i;
        if (i > 60 || k <= m) {
            // k在左半边
            return f(k, operations, i - 1);
        }
        // k在右半边
        char ans = f(k - m, operations, i - 1);
        return (char) ('a' + (ans - 'a' + op) % 26);
    }
}
