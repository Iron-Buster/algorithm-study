def solution(values: list) -> int:
    # PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
    # write code here

    # values[i] + values[j] + i - j
    # -> values[j] - j + values[i] + i
    lmx = values[0]
    ans = 0
    for i in range(1, len(values)):
        ans = max(ans, lmx + values[i] - i)
        lmx = max(lmx, values[i] + i)
    return ans  # Placeholder return

if __name__ == '__main__':
    print(solution(values=[8, 3, 5, 5, 6]) == 11)
    print(solution(values=[10, 4, 8, 7]) == 16)
    print(solution(values=[1, 2, 3, 4, 5]) == 8)