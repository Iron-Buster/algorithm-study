package com.fqh.contests.wk414;

public class A {
    // https://leetcode.cn/contest/weekly-contest-414/problems/convert-date-to-binary/

    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuilder ans = new StringBuilder();
        for (String s : split) {
            ans.append(Integer.toBinaryString(Integer.parseInt(s))).append("-");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
