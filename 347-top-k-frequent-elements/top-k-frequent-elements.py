class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        maps = {}

        for i in range(len(nums)):
            maps[nums[i]] = maps.get(nums[i], 0)+1

        sortedMap = dict(sorted(maps.items(), key = lambda x: x[1], reverse=True))

        answer = []
        for key in sortedMap:
            if len(answer) == k:
                break
            answer.append(key)

        return answer