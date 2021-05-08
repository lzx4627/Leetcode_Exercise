package com.cicisp.exercise;

public class leetcode_1723 {
    /**
     * 最小的  工人最大用时	
     */
    private int minId = Integer.MAX_VALUE;
    
    public int minimumTimeRequired(int[] jobs, int k) {
        backTracking(jobs, new int[k], 0, 0);
        return minId;
    }
    /**
     * 
     * @param jobs 
     * @param times 每个工人的用时
     * @param m	现在要分配的工作下标
     * @param minTime 目前工人的最小用时
     */
    public void backTracking(int[] jobs, int[] times, int m, int minTime) {
        //如果工作已经分配完了
        if(m == jobs.length) {
            minId = Math.min(minId, minTime);
            return ;
        }
        /**
         * flag 的作用是  如果一个工人用时为0 那么后面的工人如果也为0，则直接返回
         * true为没有工人用时为0  false为有工人用时为0
         */
        boolean flag = true;
        for(int i = 0; i < times.length; i++) {
            if(times[i] == 0) {
                if(!flag) return;
                flag = false;
            }
            times[i] += jobs[m];
            //如果现在有工人用时已经超过了minId，那么就不用判断了
            int tmpMax = Math.max(minTime, times[i]);
            if(tmpMax <= minId) {
                backTracking(jobs, times, m+1, tmpMax);
            }
            times[i] -= jobs[m];
        }
    }
    
}
