package com.fqh.contests.wk416;

public class D {

    // https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/description/
    // C题跟D题一样，数据范围不同
    public long validSubstringCount(String s, String t) {
        var need = new int[128];
        for (var x : t.toCharArray()) {
            need[x]++;
        }
        int j = 0;
        int cnt = t.length();
        long ans = 0;
        // 枚举右端点，找合法left的最大值
        for (int i = 0; i < s.length(); i++) {
            var x = s.charAt(i);
            if (need[x] > 0) {
                cnt--;
            }
            need[x]--;
            if (cnt == 0) {
                while (j < i && need[s.charAt(j)] < 0) { // 尝试缩小窗口
                    need[s.charAt(j)]++;
                    j++;
                }
                need[s.charAt(j)]++;
                j++;
                cnt++;
            }
            ans += j;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().validSubstringCount("dddddededddeeeddd", "eee"));
    }
}
