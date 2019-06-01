# See balanceddiet.java for a java implementation
# of this that will not get TLE

while True:
    line = list(map(int, input().split()))
    n = line[0]
    if n == 0:
        break

    cans = line[1:]
    cal_sum = sum(cans)
    length = int(cal_sum/2) + 1
    has_sum = [False] * length


    for can in cans:

        for i in range(length-1, -1, -1):
            if has_sum[i] and can + i < length:
                has_sum[can+i] = True

        if can < length:
            has_sum[can] = True
    
    best_i = 0
    min_diff = cal_sum
    for i in range(length-1, -1, -1):
        if has_sum[i]:
            best_i = i
            break
            a = cal_sum - i
            b = cal_sum - a
            cur_diff = a - b
            if cur_diff < 0:
                cur_diff = -cur_diff
            if cur_diff < min_diff:
                best_i = i
                min_diff = cur_diff

    m1 = cal_sum - best_i
    m2 = cal_sum - m1
    if m2 > m1:
        t = m1
        m1 = m2
        m2 = t

    print("{} {}".format(m1, m2))
