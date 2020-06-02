import sys


def get_and_clean_input():
    user_input = sys.stdin.readlines()

    clean_user_input = []
    for command in user_input:
        clean_user_input.append(command.rstrip('\n'))
    return clean_user_input


def onSegment(p, q, r):
    return (
                   q[0] <= max(p[0], r[0])
           ) and (
                   q[0] >= min(p[0], r[0])
           ) and (
                   q[1] <= max(p[1], r[1])
           ) and (
                   q[1] >= min(p[1], r[1])
           )


def orientation(p, q, r):
    val = ((q[1] - p[1]) * (r[0] - q[0])) - ((q[0] - p[0]) * (r[1] - q[1]))
    if val > 0:
        return 1
    elif val < 0:
        return 2
    else:
        return 0


def doIntersect(line1, line2):
    p1, q1 = line1
    p2, q2 = line2

    o1 = orientation(p1, q1, p2)
    o2 = orientation(p1, q1, q2)
    o3 = orientation(p2, q2, p1)
    o4 = orientation(p2, q2, q1)

    if (o1 != o2) and (o3 != o4):
        return True

    if (o1 == 0) and onSegment(p1, p2, q1):
        return True

    if (o2 == 0) and onSegment(p1, q2, q1):
        return True

    if (o3 == 0) and onSegment(p2, p1, q2):
        return True

    if (o4 == 0) and onSegment(p2, q1, q2):
        return True
    return False


def solve_task():
    test_cases = get_and_clean_input()[1:]
    for test_case in test_cases:
        x_start, y_start, x_end, y_end, x_left, y_top, x_right, y_bottom = list(map(int, test_case.split(" ")))
        line = ((x_start, y_start), (x_end, y_end))
        rectangle_pieces = [((x_left, y_top), (x_right, y_top)), ((x_right, y_top), (x_right, y_bottom)),
                            ((x_right, y_bottom), (x_left, y_bottom)), ((x_left, y_bottom), (x_left, y_top))]
        doesIntersect = False
        for piece in rectangle_pieces:
            if doIntersect(line, piece):
                doesIntersect = True

        if not doesIntersect:
            doesIntersect = (
                                    x_left <= x_start <= x_right and y_top >= y_start >= y_bottom
                            ) or (
                                    x_left <= x_end <= x_right and y_top >= y_end >= y_bottom
                            )

        if doesIntersect or min(x_start, x_end) >= min(x_left, x_right) \
                and max(x_start, x_end) <= max(x_left, x_right) \
                and min(y_start, y_end) >= min(y_bottom, y_top) \
                and max(y_start, y_end) < max(y_bottom, y_top):
            print("T")
        else:
            print("F")


solve_task()
