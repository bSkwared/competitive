import sys

for line in sys.stdin:
    nums = list(map(int, line.split()))

    sm = sum(nums)
    for n in nums:
        if n == sm-n:
            print(n)
            break
