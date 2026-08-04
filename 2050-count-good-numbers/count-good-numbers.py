class Solution:
    def countGoodNumbers(self, n: int) -> int:
        MOD = 1_000_000_007
        good_numbers = 0

        even_indices = (n+1) // 2
        odd_indices = n // 2

        good_numbers = (pow(4, odd_indices, MOD)*pow(5, even_indices, MOD))%MOD
        
        return good_numbers