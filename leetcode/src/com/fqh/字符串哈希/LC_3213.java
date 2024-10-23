package com.fqh.字符串哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class LC_3213 {


    // https://leetcode.cn/problems/construct-string-with-minimum-cost/description/


    public static void main(String[] args) {
        String target = "abcdef";
        String[] words = {"abdef","abc","d","def","ef"};
        int[] costs = {100,1,1,10,5};
        System.out.println(new LC_3213().minimumCost(target, words, costs));
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        var hash = new StringHash(n, 0, target);
        // 长度->哈希值->minCost
        var map = new TreeMap<Integer, HashMap<Long, Integer>>();
        for (int i = 0; i < words.length; i++) {
            int m = words[i].length();
            // 同StringHash.calc()
            long h = 0;
            for (char c : words[i].toCharArray()) {
                h = h * 131 + c;
            }
            map.computeIfAbsent(m, v -> new HashMap<>());
            map.get(m).merge(h, costs[i], Integer::min);
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        // 枚举target的长度
        for (int i = 1; i <= n; i++) {
            for (var entry : map.entrySet()) {
                int len = entry.getKey();
                if (len > i) break;
                // target[i-len]到target[i]的哈希值
                long hval = hash.get(i - len + 1, i);
                int cost = entry.getValue().getOrDefault(hval, Integer.MAX_VALUE / 2);
                dp[i] = Math.min(dp[i], dp[i-len] + cost);
            }

        }
        return dp[n] == Integer.MAX_VALUE / 2 ? -1 : dp[n];
    }

    class StringHash {
        static final int N = 50010;
        static final int P = 131;
        int n, m;
        // p[i]=P^i, h[i]=s[1~i]的hash值
        long[] p = new long[N];
        long[] h = new long[N];
        char[] s = new char[N];

        // 预处理 hash函数的前缀和
        void init() {
            p[0] = 1;
            h[0] = 0;
            for(int i = 1; i <= n; i ++){
                p[i] = p[i-1]*P;
                h[i] = h[i-1]*P+s[i];
            }
        }

        // 计算s[l~r]的 hash值
        long get(int l, int r) {
            return h[r]-h[l-1]*p[r-l+1];
        }

        // 计算串的哈希值
        long calc(char[] s, int n) {
            h[0] = 0;
            for (int i = 1; i <= n; i++) {
                h[i] = h[i-1]*P+s[i];
            }
            return h[n];
        }

        // 判断两子串是否相同
        boolean substr(int l1,int r1,int l2,int r2){
            return get(l1, r1) == get(l2, r2);
        }

        public StringHash(int n, int m, String str) {
            this.n = n;
            this.m = m;
            for (int i = 0; i < n; i++) {
                s[i+1] = str.charAt(i);
            }
            init();
        }
    }

}
