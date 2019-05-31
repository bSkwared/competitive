L, x = map(int, input().split())

E = "enter"
#L = "leave"

count = 0
bad = 0

for _ in range(x):
    cmd, p = input().split()
    p = int(p)

    if cmd == E:
        if count + p > L:
            bad += 1
        else:
            count += p
    else:
        count -= p
        count = 0 if count < 0 else count

print(bad)
