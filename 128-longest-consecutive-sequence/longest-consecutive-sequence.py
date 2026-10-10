class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:

        sets = set(nums)

        lens, max_lens = 0, 0
        for ele in sets:
            if ele-1 in sets:
                continue
            
            lens = 0
            while ele in sets:
                lens += 1
                ele += 1

            max_lens = max(max_lens, lens)

        return max_lens