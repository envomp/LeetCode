#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'match' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts following parameters:
#  1. STRING_ARRAY prefixes
#  2. STRING_ARRAY numbers
#

def match(prefixes, numbers):  # Total complexity O(n), where n is the number of phone numbers
    hashmap = dict()
    answers = []

    for prefix in prefixes:  # Complexity O(n)
        hashmap[prefix] = True

    for number in numbers:  # Complexity O(n)
        suitable_prefix = ""
        for i in range(len(number) - 1, 0, -1):  # Iterate every possible substring starting from 0. Max length is 15, so this has complexity or O(1)
            if hashmap.get(number[:i]) is not None:  # Hashmap key has O(1) complexity
                suitable_prefix = number[:i]
                break

        answers.append(suitable_prefix)

    return answers


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    prefixes_count = int(input().strip())

    prefixes = []

    for _ in range(prefixes_count):
        prefixes_item = input()
        prefixes.append(prefixes_item)

    numbers_count = int(input().strip())

    numbers = []

    for _ in range(numbers_count):
        numbers_item = input()
        numbers.append(numbers_item)

    result = match(prefixes, numbers)

    fptr.write('\n'.join(result))
    fptr.write('\n')

    fptr.close()
