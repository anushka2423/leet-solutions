class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        compPairs = {}

        for i in range(len(nums)):
            comp = target-nums[i]
            if comp in compPairs:
                return [compPairs[comp], i]
            
            compPairs[nums[i]] = i

        return []