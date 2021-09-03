package com.cicisp.interview;

import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
 */
public class interview_17_14 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        int n = arr.length;
        if (k == 0){
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        });
        for (int i = 0;i < k; i ++){
            queue.offer(arr[i]);
        }
        for (int i = k; i < n; i ++){
            if (queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i ++){
            res[i] = queue.poll();
        }
        return res;
    }
}
