package com.fqh.contests.wk138;

import java.util.TreeMap;

/**
 * @Author: vq
 * @Date: 2023/11/25 13:44
 * @Version V1.0
 */
public class C {

//    1053. 交换一次的先前排列
//            已解答
//    第 138 场周赛
//            Q3
//1633
//    相关标签
//            相关企业
//    提示
//    给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
//
//    如果无法这么操作，就请返回原数组。



    // 1.从后往前找第一个逆序元素
    // 2.在这个逆序元素后面找一个比它小的最大值 进行交换

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int idx1 = -1;
        int x = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                idx1 = i;
                x = arr[i];
                break;
            }
        }
        if (idx1 == -1) return arr;
        var tmap = new TreeMap<Integer, Integer>();
        for (int i = idx1 + 1; i < n; ++i) {
            if (!tmap.containsKey(arr[i])) {
                tmap.put(arr[i], i);
            }
        }
        int idx2 = tmap.lowerEntry(x).getValue();
        arr[idx1] ^= arr[idx2];
        arr[idx2] ^= arr[idx1];
        arr[idx1] ^= arr[idx2];
        return arr;
    }

}
