from collections import Counter


def solution(array):
    # Edit your code here
    cnt = Counter(array)
    k = (len(array) + 1) // 2
    for x in cnt:
        if cnt[x] >= k:
            return x
    return 0


if __name__ == "__main__":
    # Add your test cases here

    print(solution([1, 3, 8, 2, 3, 1, 3, 3, 3]) == 3)
