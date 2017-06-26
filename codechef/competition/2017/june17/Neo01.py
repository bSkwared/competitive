# Problem statement: https://www.codechef.com/problems/NEO01

import sys
import math
from fractions import gcd
 
T = int(sys.stdin.readline().strip())
 
        
 
 
 
for WUTEVS in range(T):
    n = int(sys.stdin.readline().strip())
    arr = sys.stdin.readline().strip().split(' ')#.sort()
 
    arr = [int(i) for i in arr]
 
    positive = [i for i in arr if i >= 0]
    negative = [i for i in arr if i < 0]
 
    posCount = len(positive)
    posSum = sum(positive)
 
    negative.sort(reverse=True)
 
    negSum = 0
    for i in negative:
        next = (posSum + i) * (posCount + 1)
        if (next > posSum*posCount + i):
            posSum += i
            posCount += 1
        else:
            negSum += i
 
 
    
    result = posSum * posCount + negSum
    
    print(result)
 