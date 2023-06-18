import sys

array_of_string = []
string_list = []

instruction_counter = input()
for i in range(0, int(instruction_counter)):
    array_of_string = sys.stdin.readline()
    string_list = array_of_string.split()
    for index in string_list:
        print(index[::-1], '', end='')
    print('')