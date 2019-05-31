import math
T = int(input())

def tour(n, m, k):
    if math.gcd(k, m) != 1 or math.gcd(k, n) != 1:
        return -1

    return m*n

for OUTER in range(T):
    N, M, K = map(int, input().split())
    print(tour(N, M, K))