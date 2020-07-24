package com.cicisp.exercise;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。

 

示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 */

public class leetcode_1025 {
    /**
     *  N=1 的时候，区间 (0, 1)(0,1) 中没有整数是 nn 的因数，所以此时 Alice 败。
        N = 2N=2 的时候，Alice 只能拿 11，NN 变成 11，Bob 无法继续操作，故 Alice 胜。
        N = 3N=3 的时候，Alice 只能拿 11，NN 变成 22，根据 N = 2N=2 的结论，我们知道此时 Bob 会获胜，Alice 败。
        N = 4N=4 的时候，Alice 能拿 11 或 22，如果 Alice 拿 11，根据 N = 3N=3 的结论，Bob 会失败，Alice 会获胜。
        N = 5N=5 的时候，Alice 只能拿 11，根据 N = 4N=4 的结论，Alice 会失败。
        ......
        写到这里，也许你有了一些猜想。没关系，请大胆地猜想，在这种情况下大胆地猜想是 AC 的第一步。也许你会发现这样一个现象：NN 为奇数的时候 Alice（先手）必败，NN 为偶数的时候 Alice 必胜。 这个猜想是否正确呢？下面我们来想办法证明它。

        证明

        N = 1N=1 和 N = 2N=2 时结论成立。

        N > 2N>2 时，假设 N \leq kN≤k 时该结论成立，则 N = k + 1N=k+1 时：

        如果 kk 为偶数，则 k + 1k+1 为奇数，xx 是 k + 1k+1 的因数，只可能是奇数，而奇数减去奇数等于偶数，且 k + 1 - x \leq kk+1−x≤k，故轮到 Bob 的时候都是偶数。而根据我们的猜想假设 N\le kN≤k 的时候偶数的时候先手必胜，故此时无论 Alice 拿走什么，Bob 都会处于必胜态，所以 Alice 处于必败态。
        如果 kk 为奇数，则 k + 1k+1 为偶数，xx 可以是奇数也可以是偶数，若 Alice 减去一个奇数，那么 k + 1 - xk+1−x 是一个小于等于 kk 的奇数，此时 Bob 占有它，处于必败态，则 Alice 处于必胜态。
        综上所述，这个猜想是正确的。
     */
    // public boolean divisorGame(int N) {
    //     return N % 2 == 0;
    // }
    public boolean divisorGame(int N) {
        boolean[] f = new boolean[N + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= N; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[N];
    }
}