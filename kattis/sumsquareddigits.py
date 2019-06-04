N = int(input())

def baseN(num,b,numerals="0123456789abcdefghijklmnopqrstuvwxyz"):
    return ((num == 0) and numerals[0]) or (baseN(num // b, b, numerals).lstrip(numerals[0]) + numerals[num % b])

nums=[c for c in "0123456789abcdefghijklmnopqrstuvwxyz"]



for _ in range(N):
    a, b, c = map(int, input().split())

    total = 0
    ob = baseN(int(c), int(b))
    for c in str(ob):
        total += nums.index(c)**2

    print("{} {}".format(a, total))