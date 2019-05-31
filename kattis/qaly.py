N = int(input())
sum = 0
for i in range(N):
    q, d = map(float, input().split())
    sum += q * d

print(sum)
