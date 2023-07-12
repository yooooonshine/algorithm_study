import sys

N = int(sys.stdin.readline())
result_list = [-1] * N
my_string = sys.stdin.readline().strip()
my_list = list(map(int, my_string.split(' ')))
my_stack = []

my_list_counter = {}
for i in my_list:
    if i in my_list_counter:
        my_list_counter[i] = my_list_counter[i] + 1
    else:
        my_list_counter[i] = 1

for i in range(len(my_list)):
    if len(my_stack) == 0:
        my_stack.append(i)
    else:
        if my_list_counter[my_list[my_stack[-1]]] >= my_list_counter[my_list[i]]:
            my_stack.append(i)
        else:
            while my_list_counter[my_list[my_stack[-1]]] < my_list_counter[my_list[i]]:
                result_list[my_stack[-1]] = my_list[i]
                my_stack.pop()
                if len(my_stack) == 0:
                    break
            my_stack.append(i)
for element in result_list:
    print(element,end=' ')