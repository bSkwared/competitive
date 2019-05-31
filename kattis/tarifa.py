X = int(input())
N = int(input())

leftover = 0
for OUTER in range(N):
    leftover += X
    leftover -= int(input())

print(leftover+X)
