N = int(input())

for _ in range(N):
    b, p = map(float, input().split())

    min = 60.0/(p/(b-1))
    act = 60.0*b/p
    max = 60.0/(p/(b+1))

    print("{} {} {}".format(min, act, max))
