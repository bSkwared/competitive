from decimal import getcontext, Decimal

def in_box(points, x, y):
    return (points[0] <= x <= points[2]) and (points[1] <= y <= points[3])

while True:
    getcontext().prec = 16
    N = int(input())
    if N == 0:
        break

    bs = []
    for _ in range(N):
        line = input().split()
        bs.append(list(map(Decimal, line[:-1]))+[line[-1]])

    for _ in range(int(input())):
        x, y, bx = input().split()
        x = Decimal(x)
        y = Decimal(y)

        for b in bs:
            if in_box(b, x, y):
                print(bx, "correct" if b[-1] == bx else b[-1])
                break
        else:
            print(bx, "floor")

    print()
