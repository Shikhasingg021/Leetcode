class Solution:
    def kidsWithCandies(self, candies: list[int], extraCandies: int) -> list[bool]:
        maxCandies = max(candies)
        ans = []
        for i in candies:
            if(i+extraCandies>=maxCandies):
                ans.append(True)
            else:
                ans.append(False)
        return ans
