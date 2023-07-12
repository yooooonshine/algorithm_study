# import sys
#
# N = int(sys.stdin.readline())
# my_list = []
# result_list = []
# my_string = sys.stdin.readline().strip()
# my_list = my_string.split(' ')
# my_list = list(map(int, my_list))
# for i in range(len(my_list)):
#     if i == len(my_list) - 1:
#         result_list.append(-1)
#         break
#     j = i + 1
#     while my_list[i] >= my_list[j]:
#         j += 1
#         if j == len(my_list): # 개수를 넘어갔을떄
#             result_list.append(-1)
#             break
#     if j == len(my_list):
#         continue
#     else:
#         result_list.append(my_list[j])
#
# for i in result_list:
#     print(i, end=' ')


# import sys
#
# N = int(sys.stdin.readline())
# my_list = []
# result_list = []
# my_string = sys.stdin.readline().strip()
# my_list = my_string.split(' ')
# my_stack


# import sys
#
# N = int(sys.stdin.readline())
# my_list = []
# result_list = []
# for i in range(N):
#     result_list.append(0)
# my_string = sys.stdin.readline().strip()
# my_list = my_string.split(' ')
# my_index_list = []
# for i in range(len(my_list)):
#     my_index_list.append([my_list, i])
# my_stack = []
# for i in my_index_list:
#     if len(my_stack) == 0:
#         my_stack.append(i)
#     elif my_stack[0] >= i[0]:
#         my_stack.append(i)
#     else:
#         while my_stack[0] >= i[0]:
#             if len(my_stack) == 0:
#                 my_stack.append(i)
#             result_list[i[1]] = i[0]
#             my_stack.pop(0)


import sys

N = int(sys.stdin.readline())
my_list = []
result_list = [-1] * N
my_string = sys.stdin.readline().strip()
my_list = list(map(int, my_string.split(' ')))
my_stack = []
for i in range(len(my_list)):
    if len(my_stack) == 0:
        my_stack.append(i)
    else:
        if my_list[my_stack[-1]] >= my_list[i]:
            my_stack.append(i)
        else:
            while my_list[my_stack[-1]] < my_list[i]:
                result_list[my_stack[-1]] = my_list[i]
                my_stack.pop()
                if len(my_stack) == 0:
                    break
            my_stack.append(i)
for element in result_list:
    print(element,end=' ')