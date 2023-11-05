public class A4_0_1_knapsack {
    public static void main(String[] args) {
        int[] val = {50, 100, 150, 200};
        int[] wt = {8, 16, 32, 40};
        int W = 64;
        int n = val.length - 1;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}
