package com.fqh.前缀和.差分数组;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 14:52
 **/
public class LC_848 {

    static final int MOD = 260000;
    public String shiftingLetters(String ss, int[] shifts) {
        int n = shifts.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = shifts[i] > 26 ? shifts[i] % 26 : shifts[i];
            diff[0] += v;
            diff[i+1] -= v;
        }
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i-1];
        }
        char[] s = ss.toCharArray();
        for (int i = 0; i < n; i++) {
            int temp = 'a' + (s[i] - 'a' + diff[i] + MOD) % 26;
            s[i] = (char) temp;
        }
        return String.valueOf(s);
    }

//    848. 字母移位
//    第 88 场周赛
//            Q1
//1353
//    相关标签
//            相关企业
//    有一个由小写字母组成的字符串 s，和一个长度相同的整数数组 shifts。
//
//    我们将字母表中的下一个字母称为原字母的 移位 shift() （由于字母表是环绕的， 'z' 将会变成 'a'）。
//
//    例如，shift('a') = 'b', shift('t') = 'u', 以及 shift('z') = 'a'。
//    对于每个 shifts[i] = x ， 我们会将 s 中的前 i + 1 个字母移位 x 次。
//
//    返回 将所有这些移位都应用到 s 后最终得到的字符串 。
//
//
//
//    示例 1：
//
//    输入：s = "abc", shifts = [3,5,9]
//    输出："rpl"
//    解释：
//    我们以 "abc" 开始。
//    将 S 中的第 1 个字母移位 3 次后，我们得到 "dbc"。
//    再将 S 中的前 2 个字母移位 5 次后，我们得到 "igc"。
//    最后将 S 中的这 3 个字母移位 9 次后，我们得到答案 "rpl"。

    public static void main(String[] args) {
        int[] sh = {3, 5, 9};
        System.out.println(new LC_848().shiftingLetters("abc", sh));
    }
}
