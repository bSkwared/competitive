s = set()
for w in input().split():
    if w in s:
        print("no")
        exit()
    s.add(w)

print("yes")
