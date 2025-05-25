public class PracticeProblem {

	public static void main(String args[]) {

	}
    public static int fib(int num) {
        if (num <= 0) {
            return 0;
        }
        int[] memo = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            memo[i] = -1; 
        }
        return fibHelper(num, memo);
    }

    private static int fibHelper(int num, int[] memo) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        if (memo[num] != -1) {
            return memo[num];
        }

        memo[num]  = fibHelper(num - 1, memo) + fibHelper(num - 2, memo);
        return memo[num];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
		 if (n == 0) {
            return 0; 
        }
        if (n == 1) {
            return cost[0]; 
        }
        int[] memo = new int[n + 1]; 
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return Math.min(minCostHelper(cost, 0, memo), minCostHelper(cost, 1, memo));
    }

    private static int minCostHelper(int[] cost, int i, int[] memo) {
        if (i >= cost.length) {
            return 0; 
        }
        if (memo[i] != -1) {
            return memo[i];
        } 
        memo[i] = cost[i] + Math.min(minCostHelper(cost, i + 1, memo), minCostHelper(cost, i + 2, memo));
        return memo[i];
    }
}