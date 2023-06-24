import sys
my_queue = []

for i in range(int(sys.stdin.readline())):
    instruction = sys.stdin.readline().split()
    if instruction[0] == "push":
        my_queue.append(instruction[1])
    elif instruction[0] == "pop":
        if len(my_queue) == 0:
            print(-1)
        else:
            print(my_queue.pop(0))
    elif instruction[0] == "size":
        print(len(my_queue))
    elif instruction[0] == "empty":
        if len(my_queue) == 0:
            print(1)
        else:
            print(0)
    elif instruction[0] == "front":
        if len(my_queue) == 0:
            print(-1)
        else:
            print(my_queue[0])
    elif instruction[0] == "back":
        if len(my_queue) == 0:
            print(-1)
        else:
            print(my_queue[len(my_queue) - 1])