A = input()
B = input()

if len(A) < len(B):
    A = "0"*(len(B)-len(A)) + A

elif len(B) < len(A):
    B = "0"*(len(A) - len(B)) + B

a_out = ""
b_out = ""

for a, b in [(int(a), int(b)) for a,b in zip(A, B)]:
    if a > b:
        a_out += str(a)
    elif b > a:
        b_out += str(b)
    else:
        a_out += str(a)
        b_out += str(b)

print(int(a_out) if a_out else "YODA")
print(int(b_out) if b_out else "YODA")
