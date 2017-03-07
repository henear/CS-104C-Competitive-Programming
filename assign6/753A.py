import math
num = int(input())
maxp = int((-1+math.sqrt(1+8*num))/2)
print(maxp)
for i in range(1, maxp):
    print(i, end = ' ')
print(int(num - maxp*(maxp-1) / 2))
