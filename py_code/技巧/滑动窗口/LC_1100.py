from collections import Counter


# 1100. 长度为 K 的无重复字符子串
# 提示
# 1349
# 53
# 第 3 场双周赛
# Q2
# company
# 亚马逊
# company
# 华为
# company
# 谷歌 Google
# 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
class Solution:
    def numKLenSubstrNoRepeats(self, s: str, k: int) -> int:
        cnt = Counter()
        i = j = ans = 0
        while i < len(s):
            cnt[s[i]] += 1
            while cnt[s[i]] > 1 or len(cnt) > k:
                cnt[s[j]] -= 1
                if cnt[s[j]] == 0:
                    del cnt[s[j]]
                j += 1
            ans += len(cnt) == k
            i += 1
        return ans


if __name__ == '__main__':
    print("ok")

