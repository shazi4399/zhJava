package com.kuang.Yu;

public class Main {
    public static int maxExpectation(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        int n = arr.length;
        int[][] dp = new int[k + 1][4];

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                // 根据j的值更新dp[i][j]
                switch (j) {
                    case 0:
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][2] + arr[0]);
                        break;
                    case 1:
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][3] + arr[n - 1]);
                        break;
                    case 2:
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][0] - arr[0]);
                        break;
                    case 3:
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][1] - arr[n - 1]);
                        break;
                }
            }
        }

        int maxExpectation = Math.max(dp[k][0], dp[k][1]);
        return maxExpectation;
    }

    public static void main(String[] args) {
        int[] arr = {-10, 8, 2, 1, 2, 6};
        int k = 4;
        System.out.println(maxExpectation(arr, k));
    }
}
