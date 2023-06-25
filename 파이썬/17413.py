import sys

start = 0
my_string = sys.stdin.readline().strip()
for i in range(len(my_string)):
    if my_string[i] == '<':
        my_string_list = my_string[start: i].split(' ')
        for my_string_list_index in range(len(my_string_list)):
            my_string_list[my_string_list_index] = (my_string_list[my_string_list_index])[::-1]
        print(' '.join(my_string_list), end='')
        start = i
    elif my_string[i] == '>':
        print(my_string[start:i+1], end='')
        start = i + 1
    else:
        if i == len(my_string) - 1:
            my_string_list = my_string[start:i+1].split(' ')
            for my_string_list_element in my_string_list:
                print(my_string_list_element[::-1] + ' ', end='')


import re
# my_string_list = sys.stdin.readline().strip().split(' ')
# for my_string_list_index in range(len(my_string_list)):
#     first_list = my_string_list[my_string_list_index].split('<')
#     for first_list_index in range(len(first_list)):
#         second_list = first_list[first_list_index].split('>')
#         for second_list_index in range(len(second_list)):
#             second_list[second_list_index] = (second_list[second_list_index])[::-1]
#         first_list[first_list_index] = '>'.join(second_list)
#     print('<'.join(first_list)+' ', end='')

# start = 0


#  정규표현식을 사용하려했으나 어떻게 나눠야 할지 몰랐다
# found = re.findall(r"<.*?>|\w+", s) 이거를 참고하면 , 일반 문자열을 or로 받아야 완전하게 나눌수 있었다.
# 또한 문제를 잘 읽은 후 풀자 엉뚱하게 풀지 말고.