import sys


lines = sys.stdin.readlines()
amount = int(lines[0].strip())
i = 1
wannabeStringBuilder = []
for line in range(amount):
    case = list(map(int, list(lines[i].strip())))
    case_size = len(case)
    answer = 0

    while case:
        floor = case_size >> 1
        if case_size % 2 != 0:  # is odd
            a = case.pop(floor)
        else:
            a = case.pop(floor - (0 if case[floor] > case[floor - 1] else 1))

        if case_size == 1:
            answer += a
        else:
            answer = answer + (a * 2) ** (case_size - 1)

        case_size -= 1
    wannabeStringBuilder.append(f"Case #{line + 1}: {answer % 1000000007}")
    i += 1

sys.stdout.write("\n".join(wannabeStringBuilder))
sys.stdout.close()
