package com.fqh;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/6 12:26
 * @Version V1.0
 */
public class LC_1239 {

    public int maxLength(List<String> arr) {
        // 预处理没用的字符串
        var ss = new ArrayList<String>();
        for (var s : arr) {
            int mask = 0;
            boolean ok = true;
            for (char ch : s.toCharArray()) {
                int x = ch - 'a';
                if (((mask >> x) & 1) == 1) {
                    ok = false;
                    break;
                }
                mask |= (1 << x);
            }
            if (ok) ss.add(s);
        }
        return dfs(0, 0, ss);
    }

    int dfs(int i, int mask, List<String> arr) {
        if (i >= arr.size()) return 0;
        // 不选第i个
        int a = dfs(i + 1, mask, arr);
        // 判断能不能选第i个
        String cur = arr.get(i);
        int s = 0;
        for (char ch : cur.toCharArray()) {
            int x = ch - 'a';
            s |= (1 << x);
        }
        int b = 0;
        if ((mask & s) == 0) {  // 两个集合没有交集，选第i个
            mask |= s;
            b = dfs(i + 1, mask, arr) + cur.length();
        } else {                // 只能不选
            b = dfs(i + 1, mask, arr);
        }
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        List<String> list = List.of("cha", "r", "act", "ers");
        System.out.println(new LC_1239().maxLength(list));
    }
}
