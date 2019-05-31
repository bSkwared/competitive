for _ in range(int(input())):
    try:
        print(sum(map(int, input().split('+'))))
    except:
        print("skipped")
