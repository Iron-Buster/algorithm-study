'''
https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/description/?envType=daily-question&envId=2024-11-02
'''
class Solution:
    def minChanges(self, n: int, k: int) -> int:
        cnt = 0
        for i in range(31, -1, -1):
            if (n>>i&1) != (k>>i&1):
                if (k>>i&1) == 1:
                    return -1
                cnt += 1
        return cnt



if __name__ == '__main__':
    print(Solution().minChanges(14, 13))