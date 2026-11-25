class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        answer = []

        def helper(ind, subset):
            if ind == len(nums):
                answer.append(subset[:])
                return None

            subset.append(nums[ind])
            helper(ind+1, subset)
            subset.pop()
            helper(ind+1, subset)

        helper(0, [])
        return answer