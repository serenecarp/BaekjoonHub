k = int(input())
for i in range (1, k+1):
  data = list(map(int, input().split()))
  print('#%d' %i, max(data))
