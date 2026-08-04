class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        product = []
        product.append(1)
        prev = nums[0]

        for i in range(1, len(nums)):
            product.append(prev)
            prev *= nums[i]

        prev = nums[len(nums)-1]
        for i in range(len(nums)-2, -1, -1):
            product[i] *= prev
            prev *= nums[i]

        return product