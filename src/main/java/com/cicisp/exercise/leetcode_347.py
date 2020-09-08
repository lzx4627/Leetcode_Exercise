from collections import Counter

'''
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
'''

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        return [ a for a,b in sorted(Counter(nums).items(), key=lambda x:-x[1])[:k] ]