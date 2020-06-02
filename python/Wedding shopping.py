cases = int(input())

garments = None
money = None
memory = None


def recc(cur, best, cur_state, score):
    if score <= money:
        memory[cur_state] = score
        best = max(best, score)
    else:
        memory[cur_state] = 0
        return best

    for j in range(len(cur)):
        if cur[j] + 1 < len(garments[j]) and best != max_spend:
            cur[j] += 1
            cur_state += 20 ** j
            # step = ((cur_state % 20 ** (j + 1)) - (cur_state % 20 ** j)) // (20 ** j)
            go = True
            intermediate_state = cur_state

            for _ in range(20):
                if memory.get(intermediate_state):
                    go = False
                    break
                intermediate_state += 20 ** j

            if go:
                score += - garments[j][cur[j] - 1] + garments[j][cur[j]]
                best = max(best, recc(cur, best, cur_state, score))
                score += garments[j][cur[j] - 1] - garments[j][cur[j]]

            cur_state -= 20 ** j
            cur[j] -= 1

    return best


for i in range(cases):
    money, nr_garments = list(map(int, input().split(" ")))
    garments = [sorted(list(map(int, input().split(" ")))[1:]) for _ in range(nr_garments)]
    max_spend = min(sum([x[-1] for x in garments]), money)
    sizes = [len(x) for x in garments]
    initial_state = [0 for _ in range(nr_garments)]
    memory = dict()

    score = 0
    for i, j in enumerate(initial_state):
        score += garments[i][j]

    answer = recc(initial_state, -1, 0, score)
    if answer > 0:
        print(answer)
    else:
        print("no solution")
