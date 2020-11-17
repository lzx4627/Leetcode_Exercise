package com.cicisp.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */
public class leetcode_406 {
    public int[][] reconstructQueue(int[][] people) {
        //两数不等，按照左边数降序，两边相等，按照右边数升序
        Arrays.sort(people,(o1,o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int []> list = new LinkedList<>();
        for(int [] p :people){
            // 把p加到p[1]下标为右边数的位置
            // 高个子先站好位， 矮个子插入到k位置上， 前面肯定有k个高个子，矮个子再插到前面也 满足k的要求
            list.add(p[1],p);
        }
        // 返回新数组，注意设置长度 几行2列
        return list.toArray(new int[list.size()][2]);
    }
}
