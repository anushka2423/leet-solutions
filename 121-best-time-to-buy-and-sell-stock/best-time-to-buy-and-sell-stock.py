class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if(len(prices) == 1):
            return 0

        maxProfit = 0

        left = 0
        right = 1

        while(right < len(prices)):
            if(prices[left] >= prices[right]):
                left = right
            else:
                maxProfit = max(maxProfit, prices[right]-prices[left])
        
            right += 1

        return maxProfit
        
