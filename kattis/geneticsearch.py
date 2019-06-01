def count(L, S):
    diff = len(L) - len(S)
    if diff < 0:
        return 0

    cnt = 0
    for i in range(diff+1):
        if S == L[i:i+len(S)]:
            cnt += 1

    return cnt

while True:
    try:
        S, L = input().split()
        s1 = count(L, S)
        s2 = sum([count(L, s) for s in set([S[:i] + S[i+1:] for i in range(len(S))])])
        s3 = sum([count(L, s) for s in set([S[:i] + c + S[i:] for i, c in zip(list(range(len(S)+1))*4, ["A"]*(len(S)+1) + ["G"]*(len(S)+1) + ["C"]*(len(S)+1) + ["T"]*(len(S)+1))])])
        print("{} {} {}".format(s1, s2, s3))
    except:
        break
    