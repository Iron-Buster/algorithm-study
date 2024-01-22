package com.fqh.数学;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 09:55
 **/
public class LC_670 {

//    670. 最大交换 https://leetcode.cn/problems/maximum-swap/description/?envType=daily-question&envId=2024-01-22
//            已解答
//    中等
//            相关标签
//    相关企业
//    给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
//    示例 1 :
//
//    输入: 2736
//    输出: 7236
//    解释: 交换数字2和数字7。
//    示例 2 :
//
//    输入: 9973
//    输出: 9973
//    解释: 不需要交换。
//    注意:
//
//    给定数字的范围是 [0, 108]

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
