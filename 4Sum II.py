class Solution:
    def fourSumCount(self, A: List[int], B: List[int], C: List[int], D: List[int]) -> int:
        twoSums = [dict(), dict()]
        answers = 0

        inputLists = [A, B, C, D]

        for n, twoSum in enumerate(twoSums):
            left = inputLists[0 + n * 2]
            right = inputLists[1 + n * 2]
            for i in range(len(left)):
                for j in range(len(right)):
                    product = left[i] + right[j]
                    if twoSum.get(product) is None:
                        twoSum[product] = 0
                    twoSum[product] += 1

        for existing, existingTwos in twoSums[0].items():
            find = 0 - existing

            if twoSums[1].get(find) is None:
                continue

            answers += existingTwos * twoSums[1].get(find)

        return answers
