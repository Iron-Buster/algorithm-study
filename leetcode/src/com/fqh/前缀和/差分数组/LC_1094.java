package com.fqh.前缀和.差分数组;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 15:29
 **/
public class LC_1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        var diff = new int[1010];
        for (var t : trips) {
            int num = t[0];
            int left = t[1];
            int right = t[2];
            diff[left] += num;
            diff[right] -= num;
        }
        int s = diff[0];
        if (s > capacity) return false;
        for (int i = 1; i < 1001; ++i) {
            s += diff[i];
            if (s > capacity) return false;
        }
        return true;
    }


//    1094. 拼车
//            已解答
//    第 142 场周赛
//            Q2
//1441
//    相关标签
//            相关企业
//    提示
//    车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
//
//    给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
//
//    当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
}
