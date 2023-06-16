import sys
stack_array = []


def reading_function(instruction):
    instruction = instruction.split()
    if instruction[0] == "push":
        push(instruction[1])
    elif instruction[0] == "pop":
        pop()
    elif instruction[0] == "size":
        size()
    elif instruction[0] == "empty":
        empty()
    elif instruction[0] == "top":
        top()
    else:
        return -1


def push(x):
    global stack_array
    stack_array.append(x)


def pop():
    global stack_array
    if len(stack_array):
        print(stack_array.pop(-1))
        return
    print(-1)
    return


def size():
    print(len(stack_array))
    return


def empty():
    global stack_array
    if len(stack_array):
        print(0)
        return
    else:
        print(1)
        return


def top():
    global stack_array
    if len(stack_array):
        print(stack_array[len(stack_array) - 1])
        return
    else:
        print(-1)
        return


instruction_counter = input()
for i in range(0, int(instruction_counter)):
    reading_function(sys.stdin.readline())


# 시간초과