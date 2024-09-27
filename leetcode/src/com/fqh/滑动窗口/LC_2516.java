package com.fqh.滑动窗口;

public class LC_2516 {

    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[3];
        for (char c : cs) cnt[c-'a']++;
        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) return -1;
        int mx = 0;
        int j = 0;
        for (int i = 0; i < cs.length; i++) {
            int c = cs[i] - 'a';
            cnt[c]--;
            while (cnt[c] < k) {
                cnt[cs[j]-'a']++;
                j++;
            }
            mx = Math.max(mx, i - j + 1);
        }
        return cs.length - mx;
    }



    public static void main(String[] args) {
        String s = "cbcbbabb";
        System.out.println(new LC_2516().takeCharacters(s, 1));
    }
}
