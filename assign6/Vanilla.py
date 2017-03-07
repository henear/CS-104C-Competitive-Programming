numTest = int(input())

for i in range(numTest):
    size = int(input())
    x = list(map(int,input().split()))
    y = list(map(int,input().split()))
    x.sort()
    y.sort()

    pointx = size -1
    pointy = size -1

    while pointx >= 0 and pointy >= 0:
        if  x[pointx] <= y[pointy] :
            pointy -= 1
        else :
            # x[pointx] > y[pointy]
            pointx -= 1
            pointy -= 1

    sum = 0
    for i in range( pointx + 1):
        sum += x[i]
    print(sum)


