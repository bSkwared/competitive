robot_think = "Robot thinks {} {}"
actually = "Actually at {} {}"

while True:
    w, l = map(int, input().split())
    if not w and not l:
        break
    n = int(input())

    # (w, l)
    think = (0, 0)
    act = (0, 0)
    for _ in range(n):
        dir, dist = input().split()
        dist = int(dist)

        if dir == "u":
            think = (think[0], think[1]+dist)
            act = (act[0], act[1]+dist)
        elif dir == "d":
            think = (think[0], think[1]-dist)
            act = (act[0], act[1]-dist)
        elif dir == "l":
            think = (think[0]-dist, think[1])
            act = (act[0]-dist, act[1])
        elif dir == "r":
            think = (think[0]+dist, think[1])
            act = (act[0]+dist, act[1])

        if act[0] < 0:
            act = (0, act[1])
        elif act[0] >= w:
            act = (w-1, act[1])
            
        if act[1] < 0:
            act = (act[0], 0)
        elif act[1] >= l:
            act = (act[0], l-1)

    print(robot_think.format(think[0], think[1]))
    print(actually.format(act[0], act[1]))

                    
