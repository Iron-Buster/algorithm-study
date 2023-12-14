package com.fqh._01字典树;

/**
 * @Author: vq
 * @Date: 2023/12/14 10:36
 * @Version V1.0
 */
public class LC_421 {

//[421. 数组中两个数的最大异或值](https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/) ~2000

    public int findMaximumXOR(int[] nums) {
        var tire = new ZeroOneTire();
        int ans = 0;
        for (int x : nums) {
            tire.put(x);
            ans = Math.max(ans, tire.maxXor(x));
        }
        return ans;
    }


    class ZeroOneTire {

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
    }
}
