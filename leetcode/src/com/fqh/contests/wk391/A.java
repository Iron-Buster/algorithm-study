package com.fqh.contests.wk391;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/31 12:42
 **/
public class A {


    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0;
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            s += str.charAt(i) - '0';
        }
        return x % s == 0 ? s : -1;
    }
}
