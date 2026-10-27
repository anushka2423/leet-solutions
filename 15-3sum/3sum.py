class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:

        ans = []
        nums.sort()
        i = 0

        while i < len(nums):
            target = -nums[i]
            left = i+1
            right = len(nums)-1
            while left < right:

                if nums[left]+nums[right] == target:
                    ans.append([nums[i], nums[left], nums[right]])

                    left += 1
                    right -= 1

                    while(left < right and nums[left] == nums[left-1]):
                        left += 1

                    while(right > left and nums[right] == nums[right+1]):
                        right -= 1

                elif nums[left]+nums[right] > target:
                    right -= 1
                
                else:
                    left += 1

            i += 1
            while(i < len(nums) and nums[i] == nums[i-1]):
                i += 1
                    
        return ans