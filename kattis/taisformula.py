N = int(input())

area = 0.0
last_t = 0
last_v = 0

for _ in range(N):
    line = input().split()
    t = int(line[0])
    v = float(line[1])

    if last_t > 0:
        bot = min(v, last_v)
        top = max(v, last_v)
        cur = (t - last_t) * (min(v, last_v) + ((top-bot)/2))
        area += cur

    last_t = t
    last_v = v

print(area)