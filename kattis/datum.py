#M, D = map(int, input().split())
line = input().split()
M = int(line[1])
D = int(line[0])

mp = [
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday",
    "Moday",
    "Tuesday",
    "Wednesday"
]

count = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
sum = D-1
for i in range(M-1):
    sum += count[i]

print(mp[sum%7])