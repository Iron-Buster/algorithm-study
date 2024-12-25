from collections import deque, defaultdict


def solution(airports):
    # Please write your code here
    n = len(airports)
    g = defaultdict(list)
    for i, x in enumerate(airports):
        g[x].append(i)
    q = deque()
    q.append([0, 0])
    vis = set()
    vis.add(0)
    while q:
        u, step = q.popleft()
        if u == n - 1:
            return step
        r = u + 1
        l = u - 1
        if r < n and r not in vis:
            q.append([r, step + 1])
            vis.add(r)
        if l >= 0 and l not in vis:
            q.append([l, step + 1])
            vis.add(l)
        for v in g[airports[u]]:
            if v not in vis:
                q.append([v, step + 1])
                vis.add(v)
    return -1

if __name__ == "__main__":
    #  You can add more test cases here
    print(solution([10,12,13,12,14]) == 3 )
    print(solution([10,11,12,13,14]) == 4 )
