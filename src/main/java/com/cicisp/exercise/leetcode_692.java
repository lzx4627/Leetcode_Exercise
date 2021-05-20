package com.cicisp.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
 
示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 
注意：

假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。
 
扩展练习：

尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class leetcode_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> word = new HashMap<String, Integer>();
        for (String wd : words){
            word.put(wd, word.getOrDefault(wd, 0) + 1);
        }

        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : word.entrySet()){
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2){
                return word.get(word1) == word.get(word2) ? word1.compareTo(word2) : word.get(word2) - word.get(word1);
            }
        });

        return rec.subList(0, k);
    }
}
