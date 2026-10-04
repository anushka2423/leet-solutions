class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        charArr = [0]*26
        for i in range(len(s)):
            charArr[ord(s[i])-ord('a')] += 1

        for i in range(len(t)):
            if charArr[ord(t[i])-ord('a')] == 0:
                return False
            else:
                charArr[ord(t[i])-ord('a')] -= 1

        for i in range(len(charArr)):
            if charArr[i] != 0:
                return False

        return True