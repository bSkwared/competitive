N = int(input())

yes = "advertise"
no = "do not advertise"
meh = "does not matter"

for i in range(N):
    r, e, c = map(int, input().split())
    if e > r + c:
        print(yes)
    elif e == r + c:
        print(meh)
    else:
        print(no)
