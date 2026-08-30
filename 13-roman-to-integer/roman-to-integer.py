class Solution(object):
    def romanToInt(self, s):
        d={"I":1,"V":5, "X":10,"L":50, "C":100, "D":500, "M":1000}
        n=len(s)
        result=0
        for i in range(0,n):
            #if (i+1<n and d[s[i]]<d[s[i+1]]):
            if i<n-1 and d[s[i]]< d[s[i+1]]:
                result -=d[s[i]]
            else:
                result +=d[s[i]]
        return result
        """
        :type s: str
        :rtype: int
        """
        