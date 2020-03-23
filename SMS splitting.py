#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'segments' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts STRING message as parameter.
#


def segments(message):
    MAX_SMS_LENGTH = 160  # characters

    if len(message) < MAX_SMS_LENGTH:
        return [message]

    words = message.split()  # I understand i needed to split by " " (space), but really any whitespace will do :)

    answers = []

    answer = []
    suffix_id = 1
    rolling_length = 5  # suffix length
    while words:
        word = words.pop(0)
        if len(word) + rolling_length <= MAX_SMS_LENGTH:  # extend existing line
            answer.append(word)
            rolling_length += len(word) + 1  # word and space
        else:  # start a new line
            extra_space = " " if rolling_length == MAX_SMS_LENGTH + 1 else ''  # preserve space in the start of new line if it last line had max limit exceeded
            answer, rolling_length, suffix_id = finish_suffix(answer, answers, suffix_id, extra_space + word)

        if not words:  # When message runs out, dump it
            answer, rolling_length, suffix_id = finish_suffix(answer, answers, suffix_id, word)

    messages_with_suffixes = []
    number_of_suffixes = len(answers)

    for message_array, suffix_id in answers:
        message_splice = " ".join(message_array)
        suffix_prefix = ' ' if suffix_id != number_of_suffixes and len(message_splice) + 5 < MAX_SMS_LENGTH else ''
        messages_with_suffixes.append(message_splice + f"{suffix_prefix}({suffix_id}/{number_of_suffixes})")

    return messages_with_suffixes


def finish_suffix(answer, answers, suffix_id, word):  # can add support for breaking word to 2 parts
    answers.append((answer, suffix_id))
    suffix_id += 1
    rolling_length = 5 + len(word) + 1  # next suffix
    answer = [word]
    return answer, rolling_length, suffix_id


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    message = input()

    result = segments(message)

    fptr.write('\n'.join(result))
    fptr.write('\n')

    fptr.close()
