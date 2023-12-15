package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/12/14 18:48
 * @Version V1.0
 */
public class LC_2038 {

//    2038. 如果相邻两个颜色均相同则删除当前颜色
//    第 63 场双周赛
//            Q2
//    1468
//    相关标签
//            相关企业
//    提示
//    总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。
//
//    Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。
//
//    如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
//    如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
//    Alice 和 Bob 不能 从字符串两端删除颜色片段。
//    如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
//    假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。


//    输入：colors = "AAABABB"
//    输出：true
//    解释：
//    AAABABB -> AABABB
//    Alice 先操作。
//    她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。
//
//    现在轮到 Bob 操作。
//    Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
//    因此，Alice 获胜，返回 true 。

    // A能比B操作的次数多，A就一定获胜
    public boolean winnerOfGame(String colors) {
        char[] c = colors.toCharArray();
        return f(c, 'A') > f(c, 'B');
    }

    int f(char[] c, char x) {
        int n = c.length;
        int i = 0;
        int cnt = 0;
        while (i < n - 1) {
            int st = i;
            if (c[st] != x) {
                i++;
                continue;

            }
            for (i++; i < n - 1 && c[i] == c[i - 1] && c[i] == c[i + 1]; i++) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new LC_2038().winnerOfGame("AAAABABB"));
    }
}
