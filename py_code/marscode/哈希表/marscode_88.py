from collections import defaultdict

# 前缀和 + 哈希表 + 同余
def solution(n, b, sequence):
    # Please write your code here
    mp = defaultdict(int)
    mp[0] = 1
    ans = 0
    s = 0
    for x in sequence:
        s += x
        r = s % b
        if r in mp:
            ans += mp[r]
        mp[r] += 1
    return ans

if __name__ == "__main__":
    #  You can add more test cases here
    sequence = [1, 2, 3]
    print(solution(3, 3, sequence) == 3)