N = int(input())

while N != 0:
    mp = {}
    for _ in range(N):
        line = input()
        name = line.split()[0]
        for food in line.split()[1:]:
            l = mp.get(food, [])
            l.append(name)
            mp[food] = l

    foods = list(mp.keys())
    foods.sort()
    for food in foods:
        people = mp[food]
        people.sort()
        print("{} {}".format(food, " ".join(people)))
    print()

    N = int(input())
