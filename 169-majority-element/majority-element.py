class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        count = 1
        major = nums[0]
        prev = nums[0]

        for i in range(1, len(nums)):
            if count == 0:
                major = nums[i]
                prev = nums[i]
                count = 1
            elif major != nums[i]:
                count -= 1
            else: count += 1
        
        return major