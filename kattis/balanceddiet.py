# See balanceddiet.java for a less optimized java implementation
# This was originally TLE'ing, but I optimized it a bit and now accepts.

while True:
    line = list(map(int, input().split()))
    n = line[0]
    if n == 0:
        break

    if n == 1:
        print("{} 0".format(line[1]))
        continue

    cans = line[1:]
    cal_sum = sum(cans)
    has_sum = set()

    max_meal = int(cal_sum/2 + 0.5)

    for can in cans:
        copy_has = has_sum.copy()
        for sm in copy_has:
            if sm + can <= max_meal:
                has_sum.add(sm+can)
        if can <= max_meal:
            has_sum.add(can)
    
    try:
        meals = list(has_sum)
        meals.sort()
        best_i = meals[-1]
    except:
        exit()

    m1 = cal_sum - best_i
    m2 = cal_sum - m1
    if m2 > m1:
        t = m1
        m1 = m2
        m2 = t

    print("{} {}".format(m1, m2))
