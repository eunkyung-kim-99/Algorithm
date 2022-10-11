class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        for(int i = 0; i< triangle[triangle.length - 1].length; i++){
            dp[triangle.length - 1][i] = triangle[triangle.length - 1][i];
        }
        for(int i = triangle.length - 1; i > 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                if(j - 1 >= 0){
                    dp[i - 1][j - 1] = Math.max(dp[i - 1][j - 1], triangle[i - 1][j - 1] + dp[i][j]);
                }
                if(j == triangle[i].length - 1) continue;
                dp[i - 1][j] = Math.max(dp[i - 1][j], triangle[i - 1][j] + dp[i][j]);                
            }
        }                          
        return dp[0][0];
    }
}