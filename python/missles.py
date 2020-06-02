import sys


def do_stuff(missile_list):
    memorized_indices = [0]
    prev = [0] * len(missile_list)

    for i in range(1, len(missile_list)):
        if missile_list[memorized_indices[-1]] < missile_list[i]:
            prev[i] = memorized_indices[-1]
            memorized_indices.append(i)
            continue

        lowest_index = 0
        highest_index = len(memorized_indices) - 1
        while lowest_index < highest_index:
            middle_index = (highest_index + lowest_index) // 2
            if missile_list[memorized_indices[middle_index]] < missile_list[i]:
                lowest_index = middle_index + 1
            else:
                highest_index = middle_index

        if missile_list[i] < missile_list[memorized_indices[lowest_index]]:
            if lowest_index > 0:
                prev[i] = memorized_indices[lowest_index - 1]
            memorized_indices[lowest_index] = i

    missile_sequence = []
    last_missile = memorized_indices[-1]

    for i in range(len(memorized_indices)):
        missile_sequence.append(missile_list[last_missile])
        last_missile = prev[last_missile]
    missile_sequence.reverse()

    return missile_sequence


if __name__ == '__main__':
    results = [do_stuff(list(map(int, x.split()))) for x in "".join(sys.stdin.readlines()[2:]).split("\n\n")]
    output = ""
    for i, result in enumerate(results):
        output += 'Max hits: %d\n' % len(result)
        for missile in result:
            output += '%d\n' % missile
        if i != len(result) - 1:
            output += '\n'
    print(output)
