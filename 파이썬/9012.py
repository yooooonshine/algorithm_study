import sys

string = []


def vps():
    global string
    number = 0

    while True:
        if len(string) == 0:
            break
        if len(string) <= number:
            break

        if string[number] == "(":
            number += 1
        else:
            if number == 0:
                break
            if string[number - 1] == "(":
                string.pop(number)
                string.pop(number - 1)
                number -= 1

    if len(string) != 0:
        print("NO")
    else:
        print("YES")


length_of_input = input()
for i in range(0, int(length_of_input)):
    string = list(sys.stdin.readline())
    string.pop(len(string) - 1)
    vps()


# replace("()", "")을 이용하면 쉽게 가능