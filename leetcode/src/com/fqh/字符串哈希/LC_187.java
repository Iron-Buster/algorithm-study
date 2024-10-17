package com.fqh.字符串哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_187 {

    // https://leetcode.cn/problems/repeated-dna-sequences/description/
    //滑动窗口 + 字符串哈希
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        var hash = new StringHash(n, 0, s);
        var map = new HashMap<Long, Integer>();
        int j = 0;
        var ans = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            if (i - j + 1 == 10) {
                long v = hash.get(j + 1, i + 1);
                map.merge(v, 1, Integer::sum);
                if (map.get(v) == 2) {
                    ans.add(s.substring(j, i + 1));
                }
                j++;
            }
        }
        return ans;
    }

    class StringHash {
        static final int N = 100010;
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
