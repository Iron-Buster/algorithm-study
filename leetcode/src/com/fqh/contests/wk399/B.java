package com.fqh.contests.wk399;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/26 11:46
 **/
public class B {


    public String compressedString(String word) {
        var s = word.toCharArray();
        var res = new StringBuilder();
        int len = 1;
        for (int i = 1; i < s.length; i++) {
            if (len >= 9) { res.append(len).append(s[i-1]); len = 1; continue; }
            if (s[i] == s[i-1]) len++;
            else { res.append(len).append(s[i-1]); len = 1; }
        }
        if (len > 0)  res.append(len).append(s[s.length-1]);
        return res.toString();
    }
}
