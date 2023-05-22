# 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
#
# 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.
#
# level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.


def palindrome(name):
    for i in range(0, int(len(name) / 2)):
        if (name[i] != name[len(name) - 1 - i]):
            return 0
    return 1


print(palindrome(input()))

# k=input();print(int(k==k[::-1])) 숏코딩 즉 받은거와 이를 뒤집은게 같은지
