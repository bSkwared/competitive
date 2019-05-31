T = int(input())

IS = "DPS"
NOT = "!DPS"

def is_dps(s):
    count = {}
    for c in s:
        count[c] = count.get(c, 0) + 1

    num_even = 0
    num_odd = 0
    for key, value in count.items():
        if value % 2 == 0:
            num_even += 1
        else:
            num_odd += 1

    if len(s) % 2 == 0:
        return num_odd == 2
    elif len(s) == 1:
        return True
    else:
        return num_odd in [1, 3]

for i in range(T):
    S = input().lower()
    if is_dps(S):
        print(IS)
    else:
        print(NOT)
