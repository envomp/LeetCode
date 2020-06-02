cases = int(input())

for case in range(cases):
    weights = [[0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0],
               [0, 0, 0, 0, 0]]

    new_weights = int(input())
    for _ in range(new_weights):
        x, y, w = list(map(int, input().split()))
        weights[y][x] = w

    results = [sum([sum(sub) for sub in
                    [[weights[rootY][rootX] * (abs(rootY - leafY) + abs(rootX - leafX)) for rootY in range(5)] for rootX
                     in range(5)]]) for leafX in range(5) for leafY in range(5)]

    repetitions = dict()
    coordinates = dict()

    for i, answer in enumerate(results):
        if answer in repetitions.keys():
            repetitions[answer] += 1
        else:
            coordinates[answer] = i
            repetitions[answer] = 1

    answers = []

    for possible in sorted(repetitions):
        if repetitions[possible] == 1:
            answers.append(possible)
            if len(answers) == 5:
                break

    print(answers)
    print(repetitions)