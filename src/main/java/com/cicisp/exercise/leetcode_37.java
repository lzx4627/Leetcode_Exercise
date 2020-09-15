package com.cicisp.exercise;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

一个数独。

答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
 */
public class leetcode_37 {
    public void solveSudoku(char[][] board) {
        // 某行中1-9是否用过
        boolean[][] rowUsed = new boolean[9][10];
        // 某列中1-9是否用过
        boolean[][] colUsed = new boolean[9][10];
        // 每格中1-9是否用过
        boolean[][][] boxUsed = new boolean[3][3][10];
        // 初始化
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                int num = board[row][col] - '0';
                if(1<= num && num <= 9){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;
                }
            }
        }
        // 递归尝试填充数组 
        recusiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
    }
    public boolean recusiveSolveSudoku(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col){
        // 边界校验
        if(col == board[0].length){
            col = 0;
            row ++;
            // 如果到最后一个数字
            if(row == board.length){
                return true;
            }
        }
        // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
        if(board[row][col] == '.'){
            // 尝试填充1~9
            for(int num=1;num<=9;num++){
                // 是否可用
                boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
                if(canUsed){
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row/3][col/3][num] = true;

                    board[row][col] = (char)('0' + num);
                    // 迭代
                    if(recusiveSolveSudoku(board,rowUsed,colUsed,boxUsed,row,col+1)){
                        return true;
                    }
                    board[row][col] = '.';

                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row/3][col/3][num] = false;
                }
            }
        }
        else{
            return recusiveSolveSudoku(board,rowUsed,colUsed,boxUsed,row,col+1);
        }
        return false;
    }
}
