package com.fqh.contests.wk388;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 09:38
 **/
public class C {

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        var ans = new String[n];
        for (int i = 0; i < n; i++) {
            String a = arr[i];
            var list = new ArrayList<String>();
            for (int j = 0; j < a.length(); j++) {
                for (int k = j + 1; k <= a.length(); k++) {
                    String sb = a.substring(j, k);
                    boolean ok = true;
                    for (int i1 = 0; i1 < arr.length; i1++) {
                        if (i1 == i) continue;
                        if (arr[i1].contains(sb)) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) list.add(sb);
                }
            }
            list.sort((o1, o2) -> {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                return o1.compareTo(o2);
            });
            if (!list.isEmpty()) ans[i] = list.get(0);
            else ans[i] = "";
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = {"gfnt", "xn", "mdz", "yfmr", "fi", "wwncn", "hkdy"};
        System.out.println(Arrays.toString(new C().shortestSubstrings(arr)));
    }
}
