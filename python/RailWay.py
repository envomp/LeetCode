import sys

lines = sys.stdin.readlines()

while lines:
    mx = float(lines.pop(0))
    my = float(lines.pop(0))
    n = int(lines.pop(0))
    points = [(float(lines.pop(0)), float(lines.pop(0))) for _ in range(n + 1)]

    if len(points) == 1:
        print(format(round(points[0][0], 4), '.4f'))
        print(format(round(points[0][1], 4), '.4f'))
        continue

    best = [100000000000, 0, 0]

    for i in range(n):
        if (points[i][0] - points[i + 1][0]) == 0:
            m = float("inf")
        else:
            m = (points[i][1] - points[i + 1][1]) / (points[i][0] - points[i + 1][0])
        b = (points[i][1] - points[i][0] * m)

        x1 = points[i][0]
        y1 = points[i][1]
        x2 = points[i + 1][0]
        y2 = points[i + 1][1]
        x3 = mx
        y3 = my

        px = x2 - x1
        py = y2 - y1
        u = ((x3 - x1) * px + (y3 - y1) * py) / (px * px + py * py)

        x = x1 + u * px
        y = y1 + u * py

        h = ((x - mx) ** 2 + (y - my) ** 2) ** 0.5

        if not (min(points[i][0], points[i + 1][0]) <= x <= max(points[i][0], points[i + 1][0]) and
                min(points[i][1], points[i + 1][1]) <= y <= max(points[i][1], points[i + 1][1])):
            # perpendicular height not on line
            h2 = ((points[i][0] - mx) ** 2 + (points[i][1] - my) ** 2) ** 0.5
            h3 = ((points[i + 1][0] - mx) ** 2 + (points[i + 1][1] - my) ** 2) ** 0.5
            if h2 < h3:
                h = h2
                x = points[i][0]
                y = points[i][1]
            else:
                h = h3
                x = points[i + 1][0]
                y = points[i + 1][1]

        if h < best[0]:
            best = [h, x, y]

    print(format(round(best[1], 4), '.4f'))
    print(format(round(best[2], 4), '.4f'))
