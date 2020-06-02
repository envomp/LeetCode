import sys

try:
    fibio = [0, 1]

    for i in range(200):
        fibio.append(fibio[-1] + fibio[-2])

    fibio.pop(0)
    fibio.pop(0)

    lines = sys.stdin.readlines()

    while True:
        get_fibo_number = lambda inp: sum([fibio[i] for i, x in enumerate(list(inp[::-1])) if x == "1"])
        find = get_fibo_number(lines.pop(0)) + get_fibo_number(lines.pop(0))
        answer = []
        i = 0
        increment = True
        while 1:

            if increment and fibio[i] > find:
                increment = False
                i -= 1
                continue

            if not increment:
                if fibio[i] <= find:
                    find -= fibio[i]
                    answer.append("1")
                else:
                    answer.append("0")

            if increment:
                i += 1
            else:
                i -= 1

            if i == 0 and not increment:
                print(find)
                break

        print("".join(answer))
        if lines:
            lines.pop(0)
            print()
        else:
            break

except Exception:
    exit()
