package com.fqh.competition.bw119;

/**
 * @Author: vq
 * @Date: 2023/12/9 15:41
 * @Version V1.0
 */
public class B {

    public int removeAlmostEqualCharacters(String word) {
        var s = word.toCharArray();
        int ans = 0;
        for (int i = 1; i < s.length; i++) {
            if (Math.abs(s[i] - s[i - 1]) <= 1) {
                i += 1;
                ans++;
            } else {
                i += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
