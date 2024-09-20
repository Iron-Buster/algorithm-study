package com.fqh.动态规划.字典树优化;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_3291 {

    // https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-i/description/
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        for (String w : words) {
            insert(w);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            List<Integer> pres = search(target, i);
            for (int len : pres) { // 枚举可行的前缀长度
                dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    void insert(String s) {
        int n = s.length();
        Node cur = root;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.son[idx] == null) {
                cur.son[idx] = new Node();
            }
            cur = cur.son[idx];
        }
    }

    List<Integer> search(String t, int pos) {
        Node cur = root;
        List<Integer> pres = new ArrayList<>();
        for (int i = pos; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            if (cur.son[idx] == null) break;
            cur = cur.son[idx];
            pres.add(i - pos + 1);
        }
        return pres;
    }

    Node root = new Node();
    class Node {
        Node[] son;

        public Node() {
            this.son = new Node[26];
        }
    }
}
