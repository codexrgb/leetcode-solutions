class Solution(object):
    def judgeCircle(self, moves):
        x=0 #x and y when 0,0 it is the origin point 
        y=0
        for move in moves:
            if move=="U":
                y=y+1
            elif move=="D":
                y=y-1
            elif move=="R":
                x=x+1
            elif move=="L":
                x=x-1
        return x==0 and y==0
        
        """
        :type moves: str
        :rtype: bool
        """
        