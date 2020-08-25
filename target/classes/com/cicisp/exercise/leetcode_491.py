'''
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
'''

class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        if not nums:
            return []
        pres = {(nums[0], )}
        for i in nums[1:]:
            pres.update({j+(i, ) for j in pres if j[-1] <= i})
            pres.add((i, ))
        return list([list(i) for i in pres if len(i) > 1])