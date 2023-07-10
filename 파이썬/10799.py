# import sys
# import re
# found = "\(\)|\(|\)"
# my_string = sys.stdin.readline().strip()
# my_string_list = re.findall(found, my_string)
# for i in range(len(my_string_list)):
#     if my_string_list[i] == "()":
#         my_string_list[i] = 1
# # print(my_string_list)
# total_count = 0
# while len(my_string_list) != 1:
#     # print(my_string_list)
#     index = 0
#     while (my_string_list[0] != '(') and (my_string_list[0] != ')'):
#         my_string_list.pop(0)
#         # print(my_string_list)
#     while True:
#         index += 1
#         if my_string_list[index] != '(' and my_string_list[index] != ')':
#             if (my_string_list[index + 1] != '(') and (my_string_list[index + 1] != ')'):
#                 my_string_list[index] = my_string_list[index] + my_string_list.pop(index + 1)
#                 break
#             elif my_string_list[index - 1] == "(" and my_string_list[index+1] ==")":
#                 total_count += my_string_list[index] + 1
#                 my_string_list.pop(index + 1)
#                 my_string_list.pop(index - 1)
#                 break
# print(total_count)
# new_my_string_list = []

# while len(my_string_list) != 1:
#     for i in range(len(my_string_list)):
#         if my_string_list[i].isalnum():  # 숫자는 합치기
#             count = my_string_list[i]
#             while my_string_list[i + 1].isalnum():
#                 i += 1
#                 count += my_string_list[i + 1]
#             new_my_string_list.append(count)
#
#         else:
#             new_my_string_list.append(my_string_list[i])
#     new_my_string_list[]
#
#
#     my_string_list = new_my_string_list
#     new_my_string_list = []

# import sys
# import re
# my_string = sys.stdin.readline().strip()
# found = '\(\)'
# my_object = re.match(found, my_string)
# print(my_object.start())


# import sys
# import re
# found = "\(\)|\(|\)"
# my_string = sys.stdin.readline().strip()
# my_string_list = re.findall(found, my_string)
# for i in range(len(my_string_list)):
#     if my_string_list[i] == "()":
#         my_string_list[i] = '1'
# # print(my_string_list)
# total_count = 0
# while len(my_string_list) != 1:
#     print(my_string_list)
#     index = 0
#     while str.isdigit(my_string_list[0]):
#         my_string_list.pop(0)
#         # print(my_string_list)
#     while True:
#         index += 1
#         if str.isdigit(my_string_list[index]):
#             if str.isdigit(my_string_list[index + 1]):
#                 my_string_list[index] = str(int(my_string_list[index]) + int(my_string_list.pop(index + 1)))
#                 break
#             elif my_string_list[index - 1] == "(" and my_string_list[index+1] ==")":
#                 total_count += int(my_string_list[index]) + 1
#                 my_string_list.pop(index + 1)
#                 my_string_list.pop(index - 1)
#                 break
# print(total_count)


# import sys
# import re
# found = "\(\)|\(|\)"
# my_string = sys.stdin.readline().strip()
# my_string_list = re.findall(found, my_string)
# for i in range(len(my_string_list)):
#     if my_string_list[i] == "()":
#         my_string_list[i] = '1'
# # print(my_string_list)
# total_count = 0
# while len(my_string_list) != 1:
#     # print(my_string_list)
#     index = 0
#     # print(my_string_list)
#     while str.isdigit(my_string_list[0]) and len(my_string_list) != 1:
#
#         my_string_list.pop(0)
#         # print(my_string_list)
#     while True:
#         index += 1
#         if index >= len(my_string_list) - 1:
#             break
#         if str.isdigit(my_string_list[index]):
#             if str.isdigit(my_string_list[index + 1]):
#                 my_string_list[index] = str(int(my_string_list[index]) + int(my_string_list.pop(index + 1)))
#         if my_string_list[index - 1] == "(" and my_string_list[index+1] == ")":
#             total_count += int(my_string_list[index]) + 1
#             my_string_list.pop(index + 1)
#             my_string_list.pop(index - 1)
#             index -= 1
# print(total_count)


# 스택이 0이면 카운트 초기화

# import sys
#
# my_string_list = list(sys.stdin.readline().strip())
# # total_lazer_counter = 0
# # lazer_counter = 0
# global stick_counter
# stick_counter = 0
# # before_string = 0
# # my_stack = []
# # for my_string_list_element in my_string_list:
# #     if len(my_stack) == 0:
# #         lazer_counter = 0
# #     if my_string_list_element == '(':
# #         if before_string == ')':
# #             lazer_counter = 0
# #         my_stack.append(my_string_list_element)
# #         before_string = '('
# #     else:
# #         if before_string == '(':
# #             lazer_counter += 1
# #             my_stack.pop()
# #         else:
# #             stick_counter += lazer_counter + 1
# #             my_stack.pop()
# #         before_string = ')'
#
#
# def my_recursion(my_list):
#     global stick_counter
#     lazer_counter = 0
#     before_string = 0
#     my_stack = []
#     for my_list_element in my_list:
#         if len(my_stack) == 0:
#             lazer_counter = 0
#         if my_list_element == '(':
#             if before_string == ')':
#                 lazer_counter = 0
#
#             my_stack.append(my_list_element)
#             before_string = '('
#         else:
#             if before_string == '(':
#                 lazer_counter += 1
#                 my_stack.pop()
#             else:
#                 stick_counter += lazer_counter + 1
#                 my_stack.pop()
#             before_string = ')'
#
#     return lazer_counter
#
#
# print(stick_counter)



import sys

my_string_list = list(sys.stdin.readline().strip())
# total_lazer_counter = 0
# lazer_counter = 0
stick_counter = 0
lazer_counter = 0
my_stack = [my_string_list.pop(0)]
before_string = my_stack[0]
for i in my_string_list:
    if before_string == '(':
        if i == '(':
            my_stack.append(i)
            before_string = '('
        else:
            my_stack.pop()
            lazer_counter += 1
            stick_counter += len(my_stack)
            before_string = ')'

    else:
        if i == ')':
            my_stack.pop()
            before_string = ')'
            stick_counter += 1
        else:
            my_stack.append(i)
            before_string = '('

print(stick_counter)
