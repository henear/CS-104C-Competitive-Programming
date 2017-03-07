length, start, end = map(int,input().split())
data = input()
if data[end - 1] == data[start -1] :
    print ("0")
else :
    print ("1")
