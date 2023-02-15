k = int(input())
data = list(map(int, input().split()))
data.sort()
print(data[k//2])