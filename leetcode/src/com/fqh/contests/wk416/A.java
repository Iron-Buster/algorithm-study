package com.fqh.contests.wk416;

import java.util.HashSet;

public class A {


    // https://leetcode.cn/problems/report-spam-message/description/
    public boolean reportSpam(String[] message, String[] bannedWords) {
        int cnt = 0;
        var set = new HashSet<String>();
        for (String b : bannedWords) {
            set.add(b);
        }
        for (String s : message) {
            cnt += set.contains(s) ? 1 : 0;
            if (cnt >= 2) return true;
        }
        return false;
    }
}
