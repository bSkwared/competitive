line = int(input())

while True:
    if line % sum([int(c) for c in str(line)]) == 0:
        print(line)
        break

    line += 1
