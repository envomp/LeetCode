class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        oneFer = dict()

        for num in nums:
            diff = target - num
            if oneFer.get(diff) is not None and oneFer[diff] != i:
                return [oneFer[diff], i]
            oneFer[num] = i

        return None
