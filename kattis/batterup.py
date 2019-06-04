n = int(input())
at_bats = input().split()
total_bases = sum([int(ab) for ab in at_bats if ab >= 0])
print(total_bases/(n-sum([1 for ab in at_bats if int(ab) == -1])))