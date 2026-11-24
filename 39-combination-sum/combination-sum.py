class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        combination = []

        def helper(ind, s, combination, temp):
            if s == target:
                combination.append(temp[:])
                return None
            
            if(ind >= len(candidates)):
                return None

            if(s > target):
                return None
            
            temp.append(candidates[ind])
            helper(ind, s+candidates[ind], combination, temp)
            temp.pop()
            helper(ind+1, s, combination, temp)
            
        helper(0, 0, combination, [])
        return combination
        
        
        