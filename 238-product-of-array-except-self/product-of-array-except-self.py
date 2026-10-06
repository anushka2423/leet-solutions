class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        answer = []

        prev = 1
        for i in range(0, len(nums)):
            answer.append(prev)
            prev *= nums[i]

        print(answer)

        prev = 1
        for i in range(len(nums) - 1, -1, -1):
            answer[i] *= prev
            prev *= nums[i]

        return answer