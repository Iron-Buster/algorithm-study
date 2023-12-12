package com.fqh.二分答案;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/12 15:42
 * @Version V1.0
 */
public class LC_1665 {

//    1665. 完成所有任务的最少初始能量
//            尝试过
//    第 216 场周赛
//            Q4
//1901
//    相关标签
//            相关企业
//    提示
//    给你一个任务数组 tasks ，其中 tasks[i] = [actuali, minimumi] ：
//
//    actuali 是完成第 i 个任务 需要耗费 的实际能量。
//    minimumi 是开始第 i 个任务前需要达到的最低能量。
//    比方说，如果任务为 [10, 12] 且你当前的能量为 11 ，那么你不能开始这个任务。如果你当前的能量为 13 ，你可以完成这个任务，且完成它后剩余能量为 3 。
//
//    你可以按照 任意顺序 完成任务。
//
//    请你返回完成所有任务的 最少 初始能量。
//
//
//
//    示例 1：
//
//    输入：tasks = [[1,2],[2,4],[4,8]]
//    输出：8
//    解释：
//    一开始有 8 能量，我们按照如下顺序完成任务：
//            - 完成第 3 个任务，剩余能量为 8 - 4 = 4 。
//            - 完成第 2 个任务，剩余能量为 4 - 2 = 2 。
//            - 完成第 1 个任务，剩余能量为 2 - 1 = 1 。
//    注意到尽管我们有能量剩余，但是如果一开始只有 7 能量是不能完成所有任务的，因为我们无法开始第 3 个任务。

    boolean check(int[][] tasks, int x) {
        for (int[] t : tasks) {
            if (x < t[1]) return false;
            x -= t[0];
        }
        return true;
    }

    public int minimumEffort(int[][] tasks) {
        //任意顺序 完成任务 -> 对任务进行排序(按照任务能量的绝对值 递减排序)
        Arrays.sort(tasks, (a, b) -> Integer.compare(b[1] - b[0], a[1] - a[0]));
        int l = 0, r = 1000000001;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(tasks, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{4,8}};
        System.out.println(new LC_1665().minimumEffort(tasks));
    }
}
