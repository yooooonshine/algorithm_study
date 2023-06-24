    import sys

    N, K = sys.stdin.readline().split()
    N = int(N)
    K = int(K)
    sequence_list = []
    result_list = []
    for i in range(N):
        sequence_list.append(i + 1)

    current_index = 0
    for i in range(N):
        current_index = (current_index + K - 1) % len(sequence_list)
        result_list.append(sequence_list.pop(current_index))
    print('<', end='')
    for i in range(len(result_list)):
        if i != len(result_list) - 1:
            print(str(result_list[i]) + ", ", end='')
        else:
            print(result_list[i], end='')
    print('>')

# n, k = map(int, input().split()) 맵을 사용하면 바로 인트로 쪼갤 수 있다.
# ', '.join(map(str,ans)) 를 사용했으면 리스트 내용물을 모두 str로 만든후 join은 구분자를 사이로 리스트를 문자열로 출력