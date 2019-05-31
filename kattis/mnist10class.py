import random
mp = {0:"-1", 1:"1"}
for i in range(150):
    print(" ".join([mp[random.randint(0, 1)] for i in range(51)]))
