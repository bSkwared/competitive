import math

N, W, H = [int(n) for n in input().split()]

G = "DA"
B = "NE"

MAX_LEN = math.sqrt(W*W + H*H)

for OUTER in range(N):
    print(G if int(input()) <= MAX_LEN else B)
