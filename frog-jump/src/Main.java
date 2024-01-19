public class Main {

    public static int frogJump(int i, int[] height, int[] dp) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }
        int left = frogJump(i - 1, height, dp) + Math.abs(height[i] - height[i - 1]);
        int right = 0;
        if(i > 1){
            right = frogJump(i - 2, height, dp) + Math.abs(height[i] - height[i-2]);
        }
        return dp[i] = Math.min(left, right);
    }

    // frog jump with space optimization
    public static int optimizedFrogJump(int[] height) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 1; i < height.length; i++) {
            int oneStep = prev1 + Math.abs(height[i] - height[i - 1]);
            int twoSteps = Integer.MAX_VALUE;
            if(i > 1) twoSteps = prev2 + Math.abs(height[i] - height[i - 2]);

            int current = Math.min(oneStep, twoSteps);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] height = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[height.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        System.out.println(frogJump(height.length - 1, height, dp));
        System.out.println(optimizedFrogJump(height));
    }
}