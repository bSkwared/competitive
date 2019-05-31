import math

A, I = map(int, input().split())

for i in range(A*I+1):
    if math.ceil(float(i)/A) >= I:
        print(i)
        break