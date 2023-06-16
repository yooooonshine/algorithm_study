# 실패

N = input("가로")
M = input("세로")
arr = []
# 붓질 횟수
painting_count = 0
# 데이터 받기
for i in range(0, N):
    arr[i] = list(map(int, input().split()))

def counter():


for i in range(0, N):
    count1 = 0
    count2 = 0
    current_index = 0;
    next_index = 1;
    while arr[i][current_index] != 0:
        if arr[i][current_index] == 1:
            count1 += 1
        else:
            count2 += 1