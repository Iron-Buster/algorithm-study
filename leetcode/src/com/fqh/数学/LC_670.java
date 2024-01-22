package com.fqh.数学;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 09:55
 **/
public class LC_670 {

    public int maximumSwap(int num) {
        return f(num);
    }
    public int f(int num) {
        String ss = String.valueOf(num);
        char[] s = ss.toCharArray();
        int[] rmx = new int[s.length];
        rmx[s.length-1] = s[s.length-1]-'0';
        for (int i = s.length - 2; i >= 0; i--) {
            rmx[i] = Math.max(rmx[i+1], s[i]-'0');
        }
        char t = ' ';
        char t2 = ' ';
        int idx = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i]-'0' != rmx[i]) {
                idx = i;
                t = s[i];
                t2 = (char) (rmx[i]+'0');
                s[i] = (char) (rmx[i]+'0');
                break;
            }
        }
        if (idx == -1) return num;
        int last = -1;
        for (int i = idx+1; i < s.length; i++) {
            if (s[i] == t2) {
                last = i;
            }
        }
        s[last] = t;
        return Integer.parseInt(String.valueOf(s));
    }

    public static void main(String[] args) {
        //1993 ??? -> 9913
        // 9193
        System.out.println(new LC_670().maximumSwap(1993));

    }
}
