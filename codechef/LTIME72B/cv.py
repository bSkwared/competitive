T = int(input())

v = ['a', 'e', 'i', 'o', 'u']

for i in range(T):
    N = int(input())
    S = input().lower()
    c = 0
    for i in range(N-1):
        if S[i+1] in v:
            if 'a' <= S[i] and S[i] <= 'z' and S[i] not in v:
                c += 1
    print(c)

