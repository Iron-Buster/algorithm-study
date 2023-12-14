package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/14 10:06
 * @Version V1.0
 */

/**
 * 字符串相关模板
 */
public class StringTemplate {
}

/*
## 练习：0-1 trie（右边分数为题目难度）

- [421. 数组中两个数的最大异或值](https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/) ~2000
- [2935. 找出强数对的最大异或值 II](https://leetcode.cn/problems/maximum-strong-pair-xor-ii/)
- [1707. 与数组中元素的最大异或值](https://leetcode.cn/problems/maximum-xor-with-an-element-from-array/) 2359
- [1803. 统计异或值在范围内的数对有多少](https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/) 2479
- [1938. 查询最大基因差](https://leetcode.cn/problems/maximum-genetic-difference-query/) 2503
- [2479. 两个不重叠子树的最大异或值](https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/)（会员题）

*/

// 异或字典树
// 一棵（所有叶节点深度都相同的）二叉树
// 模板题 LC421 https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/
// LC1707 https://leetcode.cn/problems/maximum-xor-with-an-element-from-array/
// LC1803 https://leetcode.cn/problems/count-pairs-with-xor-in-a-range/
// LC2479 利用先序遍历的特点 https://leetcode.cn/problems/maximum-xor-of-two-non-overlapping-subtrees/
// https://codeforces.com/problemset/problem/706/D
// 数组前缀异或数组后缀的最大值（前后缀不重叠，但这要求可以无视）https://codeforces.com/problemset/problem/282/E
// https://codeforces.com/contest/1446/problem/C
// 字典序最小 https://codeforces.com/problemset/problem/923/C
// 启发式合并 https://codeforces.com/problemset/problem/1777/F
// todo https://codeforces.com/problemset/problem/1055/F
//  转换 https://codeforces.com/contest/1720/problem/D2
//  异或和 ≥k 的最短区间 https://acm.hdu.edu.cn/showproblem.php?pid=6955
//  https://codeforces.com/problemset/problem/1849/F

/**
 * 0-1 trie
 */
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

    // https://codeforces.com/problemset/problem/282/E
    // LC1938 https://leetcode-cn.com/problems/maximum-genetic-difference-query/

    // trie的删除
    public void del(int v) {
        Trie01Node cur = root;
        for (int i = trieBitLen - 1; i >= 0; i--) {
            cur = cur.son[v >> i & 1];
            cur.cnt--;
        }
    }

    // 返回 v 与 trie 上所有数的最小异或值，trie 不能是空的
    // 注：若要求 a[i] 与数组 a 中元素的最小异或值，可以先把 a[i] 从 trie01 中删掉，算好后再把 a[i] 重新插入
    // https://codeforces.com/problemset/problem/888/G 2300
    public int minXor(int v) {
        Trie01Node cur = root;
        int ans = 0;
        for (int i = trieBitLen - 1; i >= 0; i--) {
            int b = v >> i & 1;
            if (cur.son[b] == null) {
                ans |= 1 << i;
                b ^= 1;
            }
            cur = cur.son[b];
        }
        return ans;
    }

    // 返回 v 与 trie 上所有数的最大异或值，trie 不能是空的
    // 模板题 LC421 https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
    // 加约束 LC2935 https://leetcode.cn/problems/maximum-strong-pair-xor-ii/
    // 离线 LC1707 https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/ 注：可以通过记录子树最小值来在线查询
    // todo 模板题：树上最长异或路径 https://www.luogu.com.cn/problem/P4551
    // todo 好题：区间异或第 k 大 https://www.luogu.com.cn/problem/P5283
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

    // 返回 v 与 trie 上所有数的第 k 大异或值
    // k 从 1 开始
    // 如果 k 超过 trie 中元素个数，返回 0
    // [十二省联考 2019] 异或粽子 https://www.luogu.com.cn/problem/P5283
    public int maxXorKth(int v, int k) {
        Trie01Node cur = root;
        int ans = 0;
        for (int i = trieBitLen - 1; i >= 0; i--) {
            int b = v >> i & 1;
            if (cur.son[b ^ 1] != null) {
                if (k <= cur.son[b ^ 1].cnt) {
                    ans |= 1 << i;
                    b ^= 1;
                } else {
                    k -= cur.son[b ^ 1].cnt;
                }
            }
            cur = cur.son[b];
        }
        return ans;
    }

    // v 与 trie 上所有不超过 limit 的数的最大异或值
    // 不存在时返回 -1
    // https://codeforces.com/problemset/problem/979/D
    // LC1707 https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
    public int maxXorWithLimitVal(int v, int limit) {
        Trie01Node cur = root;
        if (cur.min > limit) {
            return -1;
        }
        int ans = 0;
        // 由于上面的判断保证了必然存在一个值，后面是不需要判断 o 是否为空的
        for (int i = trieBitLen - 1; i >= 0; i--) {
            int b = v >> i & 1;
            if (cur.son[b ^ 1] != null && cur.son[b ^ 1].min <= limit) {
                ans |= 1 << i;
                b ^= 1;
            }
            cur = cur.son[b];
        }
        return ans;
    }

    // 求与 v 异或值不超过 limit 的元素个数
    // 核心原理是，当 limit+1 的某一位是 1 的时候，若该位异或值取 0，则后面的位是可以取任意数字的
    // 如果在 limit 上而不是 limit+1 上讨论，就要单独处理走到叶子的情况了（恰好等于 limit）
    // LC1803 https://leetcode-cn.com/problems/count-pai(rs-with-xor-in-a-range/
    // 补集 https://codeforces.com/problemset/problem/665/E
    // https://codeforces.com/problemset/problem/817/E
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

    // v 与 trie 上所有数异或不超过 limit 的最大异或值
    // 不存在时返回 -1
    // 原理同 countLimitXOR
}
