package com.fqh.字典树._01字典树;


import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/15 18:29
 **/
public class LC_2935 {

    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        ZeroOneTrie trie = new ZeroOneTrie();
        int ans = 0, j = 0;
        for (int i = 0; i < nums.length; i++) {
            trie.put(nums[i]);
            // 1 2 3 4 5
            while (nums[i] > 2 * nums[j]) { // 缩小窗口
                trie.del(nums[j]);
                j++;
            }
            ans = Math.max(ans, trie.maxXor2(nums[i]));
        }
        return ans;
    }

    class ZeroOneTrie {

        class Trie01Node {
            Trie01Node[] son = new Trie01Node[2];
            int cnt;    // 子树叶子数
            int min;    // 子树最小值

            public Trie01Node() {
                min = Integer.MAX_VALUE;
            }
        }

        Trie01Node root = new Trie01Node();
        static final int trieBitLen = 31; // 30 for 1e9, 63 for int64, or bits.Len(MAX_VAL)

        // 向trie中插入一个数
        public void put(int v) {
            Trie01Node cur = root;
            if (v < cur.min) {
                cur.min = v;
            }
            for (int i = trieBitLen - 1; i >= 0; i--) {
                int b = v >> i & 1;
                if (cur.son[b] == null) {
                    cur.son[b] = new Trie01Node();
                }
                cur = cur.son[b];
                cur.cnt++;
                if (v < cur.min) {
                    cur.min = v;
                }
            }
        }

        // trie的删除
        public void del(int v) {
            Trie01Node cur = root;
            for (int i = trieBitLen - 1; i >= 0; i--) {
                cur = cur.son[v >> i & 1];
                cur.cnt--;
            }
        }

        // 返回 v 与 trie 上所有数的最大异或值，trie 不能是空的
        public int maxXor2(int v) {
            Trie01Node cur = root;
            int ans = 0;
            for (int i = trieBitLen - 1; i >= 0; i--) {
                int b = v >> i & 1;
                if (cur.son[b ^ 1] != null && cur.son[b ^ 1].cnt > 0) {
                    ans |= 1 << i;
                    b ^= 1;
                }
                cur = cur.son[b];
            }
            return ans;
        }
    }




//    2935. 找出强数对的最大异或值 II
//    第 371 场周赛
//            Q4
//2349
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums 。如果一对整数 x 和 y 满足以下条件，则称其为 强数对 ：
//
//            |x - y| <= min(x, y)
//    你需要从 nums 中选出两个整数，且满足：这两个整数可以形成一个强数对，并且它们的按位异或（XOR）值是在该数组所有强数对中的 最大值 。
//
//    返回数组 nums 所有可能的强数对中的 最大 异或值。
//
//    注意，你可以选择同一个整数两次来形成一个强数对。

//    输入：nums = [1,2,3,4,5]
//    输出：7
//    解释：数组 nums 中有 11 个强数对：(1, 1), (1, 2), (2, 2), (2, 3), (2, 4), (3, 3), (3, 4), (3, 5), (4, 4), (4, 5) 和 (5, 5) 。
//    这些强数对中的最大异或值是 3 XOR 4 = 7 。
}
