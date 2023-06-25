import sys

my_deque = []
instruction = []
for i in range(int(sys.stdin.readline())):
    instruction = sys.stdin.readline().strip().split(' ')
    if instruction[0] == 'push_front':
        a = [instruction[1]]
        my_deque = a + my_deque
        # my_deque.insert(0, instruction[1])
    elif instruction[0] == 'push_back':
        my_deque.append(instruction[1])
    elif instruction[0] == 'pop_front':
        if len(my_deque) == 0:
            print(-1)
        else:
            print(my_deque.pop(0))
    elif instruction[0] == 'pop_back':
        if len(my_deque) == 0:
            print(-1)
        else:
            print(my_deque.pop(-1))
    elif instruction[0] == 'size':
        print(len(my_deque))
    elif instruction[0] == 'empty':
        if len(my_deque) == 0:
            print(1)
        else:
            print(0)
    elif instruction[0] == 'front':
        if len(my_deque) == 0:
            print(-1)
        else:
            print(my_deque[0])
    elif instruction[0] == 'back':
        if len(my_deque) == 0:
            print(-1)
        else:
            print(my_deque[-1])
