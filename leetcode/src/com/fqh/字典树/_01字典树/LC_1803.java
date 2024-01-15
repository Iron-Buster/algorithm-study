package com.fqh.字典树._01字典树;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/15 18:05
 **/
public class LC_1803 {

    public int countPairs(int[] nums, int low, int high) {
        return f(nums, high) - f(nums, low-1);
    }

    public int f(int[] a, int k) {
        ZeroOneTrie trie = new ZeroOneTrie();
        int ans = 0;
        for (int v : a) {
            trie.put(v);
            ans += trie.countLimitXOR(v, k);
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

        public int maxXor(int v) {
            Trie01Node cur = root;
            int ans = 0;
            for (int i = trieBitLen - 1; i >= 0; i--) {
                int b = v >> i & 1;
                if (cur.son[b ^ 1] != null) {
                    ans |= 1 << i;
                    b ^= 1;
                }
                cur = cur.son[b];
            }
            return ans;
        }

        // 求与 v 异或值不超过 limit 的元素个数
        public int countLimitXOR(int v, int limit) {
            limit++;
            Trie01Node cur = root;
            int cnt = 0;
            for (int i = trieBitLen - 1; i >= 0; i--) {
                int b = v >> i & 1;
                if ((limit >> i & 1) > 0) {
                    if (cur.son[b] != null) {
                        cnt += cur.son[b].cnt;
                    }
                    b ^= 1;
                }
                if (cur.son[b] == null) {
                    return cnt;
                }
                cur = cur.son[b];
            }
            return cnt;
        }
    }


//    1803. 统计异或值在范围内的数对有多少
//    第 233 场周赛
//            Q4
//2479
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。
//
//    漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[j]) <= high 。
//
//
//
//    示例 1：
//
//    输入：nums = [1,4,2,7], low = 2, high = 6
//    输出：6
//    解释：所有漂亮数对 (i, j) 列出如下：
//            - (0, 1): nums[0] XOR nums[1] = 5
//            - (0, 2): nums[0] XOR nums[2] = 3
//            - (0, 3): nums[0] XOR nums[3] = 6
//            - (1, 2): nums[1] XOR nums[2] = 6
//            - (1, 3): nums[1] XOR nums[3] = 3
//            - (2, 3): nums[2] XOR nums[3] = 5
//    示例 2：
//
//    输入：nums = [9,8,4,2,1], low = 5, high = 14
//    输出：8
//    解释：所有漂亮数对 (i, j) 列出如下：
//            ​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//            - (0, 3): nums[0] XOR nums[3] = 11
//            - (0, 4): nums[0] XOR nums[4] = 8
//            - (1, 2): nums[1] XOR nums[2] = 12
//            - (1, 3): nums[1] XOR nums[3] = 10
//            - (1, 4): nums[1] XOR nums[4] = 9
//            - (2, 3): nums[2] XOR nums[3] = 6
//            - (2, 4): nums[2] XOR nums[4] = 5
}
