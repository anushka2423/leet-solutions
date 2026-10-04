class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:
        uniqueEle = set()

        for i in range(len(nums)):
            if nums[i] in uniqueEle:
                return True
            else:
                uniqueEle.add(nums[i])

        return False