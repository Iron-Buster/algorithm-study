package com.fqh.contests.wk420;

import java.util.ArrayList;
import java.util.List;

public class A {

    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            t.append('a');
            for (int j = 'a'; j <= c; j++) {
                t.setCharAt(t.length() - 1, (char) j);
                ans.add(t.toString());
            }
        }
        return ans;
    }
}
