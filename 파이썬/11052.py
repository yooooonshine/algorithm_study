import sys

N = int(sys.stdin.readline())
N_list = []
sorted_list = []
for i in range(N):
    N_list.append(0)

# P = map(int, sys.stdin.readline().split())
totalPrice = 0


def add_N_list(my_list):
    sum = 0
    for i in range(len(my_list)):
        sum += (i + 1) * my_list[i]
    return sum

3
# def my_tuple(my_list, number):
#     my_list[number] += 1
#     if add_N_list(my_list) == N:
#         print(add_N_list())
#     if add_N_list(my_list) < N:
#         my_tuple(my_list, number)
#     else:
#         return

# def my_tuple(my_list, number):
#     global sorted_list
#     if number < 0:
#         return
#     while my_list[number] <= N:
#
#         if add_N_list(my_list) <= N:
#
#             if add_N_list(my_list) == N:
#                 print(add_N_list(my_list))
#                 print("solution", my_list)
#
#             else:
#                 my_tuple(my_list, number - 1)
#         print(my_list)
#         my_list[number] += 1
#
#
# my_tuple(N_list, N - 1)
#
# print('sorted',sorted_list)

def tuples(my_list, number):
    for i in range(0, N):
        list[number] = i
        if add_N_list(my_list) == N:

