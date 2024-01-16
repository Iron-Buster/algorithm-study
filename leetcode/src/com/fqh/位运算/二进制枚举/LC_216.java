package com.fqh.位运算.二进制枚举;

import com.fqh.位运算.AND.LC_2275;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/16 15:18
 **/
public class LC_216 {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public boolean check(int s, int n) {
        temp.clear();
        int tot = 0;
        for (int i = 0; i < 9; i++) {
            if ((s >> i & 1) == 1) {
                temp.add(i + 1);
                tot += (i + 1);
            }
        }
        return tot == n;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int s = 0; s < (1<<9); s++) {
            if (Integer.bitCount(s) != k) { // 选的个数不等于k
                continue;
            }
            if (check(s, n)) {
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }

//    216. 组合总和 III
//    已解答
//            中等
//    相关标签
//            相关企业
//    找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//
//    只使用数字1到9
//    每个数字 最多使用一次
//    返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
//
//
//
//    示例 1:
//
//    输入: k = 3, n = 7
//    输出: [[1,2,4]]
//    解释:
//            1 + 2 + 4 = 7
//    没有其他符合的组合了。


    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(new LC_216().combinationSum3(k, n));
    }
}
