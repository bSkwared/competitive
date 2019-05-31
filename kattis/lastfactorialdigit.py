N = int(input())

for OUTER in range(N):
    x = int(input())
    fact = 1
    for i in range(1, x+1):
        fact *= i
    print(str(fact)[-1])
