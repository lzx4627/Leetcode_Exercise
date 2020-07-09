'''注意：本题相对原题稍作改动，只需返回未识别的字符数

 

示例：

输入：
dictionary = ["looked","just","like","her","brother"]
sentence = "jesslookedjustliketimherbrother"
输出： 7
解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
'''
class Solution:
    def respace(self, dictionary: List[str], sentence: str) -> int:
        if len(sentence) == 0:return 0
        n = len(sentence)
        dp = [0] * (n+1)
        maxLeng = 0
        for i in range(len(dictionary)):
            if len(dictionary[i]) > maxLeng:
                maxLeng = max(maxLeng,len(dictionary[i]))
        dictionary = set(dictionary)
        for i in range(1,n+1):
            dp[i] = dp[i-1] + 1
            for j in range(max(0,i-maxLeng),i):
                if(sentence[j:i] in dictionary):
                    dp[i] = min(dp[i],dp[j])
        return dp[n]