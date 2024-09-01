package com.fqh.contests.bw138;

public class B {

    // B
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i += k) {
            String a = s.substring(i, i + k);
            int sum = 0;
            for (char c : a.toCharArray()) {
                sum += c - 'a';
            }
            ans.append((char) ('a' + (sum % 26)));
        }
        return ans.toString();
    }
}
