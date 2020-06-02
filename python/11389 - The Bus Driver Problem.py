while True:
    order = input()
    if order == "0 0 0":
        break
    else:
        order = list(map(lambda x: int(x), order.split(" ")))
    morning_data = sorted(list(map(lambda x: int(x), input().split(" "))), reverse=True)
    evening_data = sorted(list(map(lambda x: int(x), input().split(" "))))
    print(sum([max((morning_data[x] + evening_data[x]) - order[1], 0) for x in range(order[0])]) * order[2])