import sys
N = int(sys.stdin.readline().strip()) # 연산자 개수
my_string = sys.stdin.readline().strip() # 받는 문자열
my_string_list = list(my_string)
alphabetDic = {}

my_stack = []
def string_parsing1(x):
    if x == '+':
        pass
    elif x == '-':
        pass
    elif x == '*':
        pass
    elif x == '/':
        pass
    else:
        if x in alphabetDic:
            pass
        else:
            alphabetDic[x] = int(sys.stdin.readline())


def string_parsing2(x):
    if x == '+':
        pass
    elif x == '-':
        pass
    elif x == '*':
        pass
    elif x == '/':
        pass
    else:
        alphabetDic[x] = int(sys.stdin.readline())

for i in my_string:
    string_parsing1(i)

for i in range(len(my_string_list)):
    if my_string_list[i] == '+' or my_string_list[i] == '-' or my_string_list[i] == '*' or my_string_list[i] == '/':
        pass
    else:
        my_string_list[i] = alphabetDic[my_string_list[i]]


for i in my_string_list:
    if i == '+':
        x = my_stack.pop()
        y = my_stack.pop()
        my_stack.append(y + x)
    elif i == '-':
        x = my_stack.pop()
        y = my_stack.pop()
        my_stack.append(y - x)
    elif i == '*':
        x = my_stack.pop()
        y = my_stack.pop()
        my_stack.append(y * x)
    elif i == '/':
        x = my_stack.pop()
        y = my_stack.pop()
        my_stack.append(y / x)
    else:
        my_stack.append(i)


print(f"{my_stack[0]:.2f}")