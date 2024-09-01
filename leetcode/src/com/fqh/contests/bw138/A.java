package com.fqh.contests.bw138;

public class A {

    public int generateKey(int num1, int num2, int num3) {
        String a = String.valueOf(num1);
        String b = String.valueOf(num2);
        String c = String.valueOf(num3);
        while (a.length() < 4) {
            a = "0" + a;
        }
        while (b.length() < 4) {
            b = "0" + b;
        }
        while (c.length() < 4) {
            c = "0" + c;
        }
        String ans = "";
        for (int i = 0; i < 4; i++) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(i) - '0';
            int z = c.charAt(i) - '0';
            ans = ans + Math.min(x, Math.min(y, z));
        }
        return Integer.parseInt(ans);
    }
}
