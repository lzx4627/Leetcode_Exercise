package com.cicisp.exercise;

/** 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * example:matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * 
 * k = 8,
 * 
 * 返回 13。
 */
public class leetcode_378{
    static int n;
    public static int count(int num,int[][] matrix){
        int res=0,s=0;
        for(int i=n-1;i>=0;i--){
            while(s<n&&matrix[i][s]<=num){
                s++;
            }
            res+=s;
        }
        return res;
    }
    public static int kthSmallest(int[][] matrix, int k) {
        n=matrix.length;
        int left=matrix[0][0],right=matrix[n-1][n-1];
        while(left<right){
            int mid=(left+right)/2,cnt=count(mid,matrix);
            if(cnt>=k){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[][] matrix = {{ 1,  5,  9},{10, 11, 13},{12, 13, 15}};
        int k = 8;
        int res = kthSmallest(matrix, k);
        System.out.println(res);
    }
}