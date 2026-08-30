class Solution(object):
    def lexicographicallySmallestArray(self, nums, limit):
        arr = sorted((value, index) for index, value in enumerate(nums))

        ans = nums[:]

        start = 0

        while start < len(arr):
            end = start

            # Find one connected group
            while (end + 1 < len(arr) and
                   arr[end + 1][0] - arr[end][0] <= limit):
                end += 1

            # Values are already sorted
            values = [arr[i][0] for i in range(start, end + 1)]

            # Get original indices
            indices = sorted(arr[i][1] for i in range(start, end + 1))

            # Put smallest values at smallest indices
            for i in range(len(values)):
                ans[indices[i]] = values[i]

            start = end + 1

        return ans
        """
        :type nums: List[int]
        :type limit: int
        :rtype: List[int]
        """
        