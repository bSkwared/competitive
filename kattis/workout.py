class W():
    def __init__(self, st):
        self.usage, self.recovery, self.start = map(int, st.split())

class Jim():
    def __init__(self, u, r):
        self.usage = u
        self.recovery = r

jim = []
line = input().split()
for i in range(10):
    jim.append(Jim(line[i*2], line[i*2+1]))

ppl = []
for _ in range(10):
    ppl.append(W(input()))

cur_time = 0
for i in range(10):
    



print(jim)
print(ppl)