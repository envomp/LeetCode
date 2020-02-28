class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        twoSum = dict()
        answers = set()
        size = len(nums)
        numsRepetitions = dict()

        nums.sort()

        for num in nums:
            if numsRepetitions.get(num) == None:
                numsRepetitions[num] = 0
            numsRepetitions[num] += 1

        for i in range(size):
            for j in range(i + 1, size):
                product = nums[i] + nums[j]
                if (twoSum.get(product) == None):
                    twoSum[product] = set()
                twoFer = (min(nums[i], nums[j]), max(nums[i], nums[j]))
                twoSum[product].add(twoFer)

        for existing, existingTwos in twoSum.items():

            find = target - existing
            if twoSum.get(find) == None:
                continue

            for existingTwo in existingTwos:
                for otherTwo in twoSum.get(find):
                    toContinue = False
                    existingFour = sorted(
                        [list(existingTwo)[0], list(existingTwo)[1], list(otherTwo)[0], list(otherTwo)[1]])

                    # continue if duplicate fields yield a 4 way pair
                    for toCheck in list(set(existingFour)):
                        count = 0
                        for num in existingFour:
                            if toCheck == num:
                                count += 1
                        if numsRepetitions[toCheck] < count:
                            toContinue = True
                            break
                    if toContinue:
                        continue

                    answers.add(tuple(existingFour))

        return answers
