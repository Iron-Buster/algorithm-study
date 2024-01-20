package com.fqh.前缀和.差分数组;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 12:13
 **/
public class LC_370 {

//    370. 区间加法
//            中等
//    相关标签
//            相关企业
//    提示
//    假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
//
//    其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
//
//    请你返回 k 次操作后的数组。
//
//    示例:
//
//    输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//    输出: [-2,0,3,5,3]
//    解释:
//
//    初始状态:
//            [0,0,0,0,0]
//
//    进行了操作 [1,3,2] 后的状态:
//            [0,2,2,2,0]
//
//    进行了操作 [2,4,3] 后的状态:
//            [0,2,5,5,3]
//
//    进行了操作 [0,2,-2] 后的状态:
//            [-2,0,3,5,3]

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length+1];
        for (int[] up : updates) {
            int l = up[0], r = up[1], v = up[2];
            diff[l] += v;
            diff[r+1] -= v;
        }
        for (int i = 1; i <= length; i++) {
            diff[i] += diff[i-1];
        }
        return Arrays.copyOfRange(diff, 0, length);
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.toString(new LC_370().getModifiedArray(length, updates)));
    }
}
