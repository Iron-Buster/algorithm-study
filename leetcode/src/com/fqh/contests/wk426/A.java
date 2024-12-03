package com.fqh.contests.wk426;

public class A {


    public int smallestNumber(int n) {
        while (true) {
            String s = Integer.toBinaryString(n);
            int cnt = Integer.bitCount(n);
            if (s.length() == cnt) {
                return n;
            }
            n++;
        }
    }
}
