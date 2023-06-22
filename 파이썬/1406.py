import sys


# input_string = list(sys.stdin.readline().rstrip())  # 개행문자 제거 및 각 문자별로 리스트화
left_string = list(sys.stdin.readline().rstrip())  # 개행문자 제거 및 각 문자별로 리스트화
right_string = []
for i in range(int(sys.stdin.readline())):
    my_function = sys.stdin.readline().rstrip()
    if my_function == "L" and left_string:
        right_string.append(left_string.pop())
    elif my_function == "D" and right_string:
        left_string.append(right_string.pop())
    elif my_function == "B" and left_string:
        left_string.pop()
    elif my_function[0] == "P":
        my_function_list = my_function.split(' ')
        left_string.append(my_function_list[1])

print(''.join(left_string) + ''.join(reversed(right_string)))

# 문자열을 리스트화해서 수행했더니 시간초과가 났다.
# 결론적으로는 pop, append 는 O(N) 의 시간이 걸리기에, 이를 해결하기 위해 stack 두개를 사용
