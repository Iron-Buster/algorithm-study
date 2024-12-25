from collections import defaultdict


def solution(s: str, k: int) -> int:
    # PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
    # write code here
    n = len(s)
    l = 1
    r = n * n
    def check(mid: int, cnt: int) -> bool:
        mp = defaultdict(int)
        j = 0
        for i, c in enumerate(s):
            mp[c] += 1
            sz = len(mp)
            v = i - j + 1
            if sz * v > mid:
                cnt -= 1
                mp.clear()
                j = i
                mp[c] += 1

        return cnt > 0


    while l < r:
        mid = l + r >> 1
        if check(mid, k):
            r = mid
        else:
            l = mid + 1
    return l

if __name__ == '__main__':
    print(solution("ababbbb", 2) == 6)
    print(solution("abcabcabc", 3) == 9)
    print(solution("aaabbbcccddd", 4) == 3)