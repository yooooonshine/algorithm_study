import sys

my_stack_counter = 1
my_stack = []
sequence_index = 0
sequence_number = int(sys.stdin.readline())
output_list = []

for i in range(sequence_number):
    sequence_index = int(sys.stdin.readline())
    while my_stack_counter <= sequence_index:
        my_stack.append(my_stack_counter)
        my_stack_counter += 1
        output_list.append("+")
    if my_stack[-1] == sequence_index:
        my_stack.pop()
        output_list.append("-")

if len(my_stack) == 0:
    for index in output_list:
        print(index)

else:
    print("NO")
