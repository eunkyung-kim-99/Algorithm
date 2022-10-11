import java.util.*;
class Solution {
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        for(int i = 0; i< puddles.length; i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = 0;
        }
        
        dfs(0, 0, dp);
        return dp[0][0] % 1000000007;
    }
    
    public int dfs(int r, int c, int[][] dp) {
        if(r == dp.length-1 && c == dp[0].length - 1){
            return 1;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = 0;
        for(int d= 0; d < dx.length; d++){
            int nr = r+ dx[d];
            int nc = c+ dy[d];
            if(nr < 0 || nr >= dp.length || nc < 0 || nc >= dp[0].length) continue;
            dp[r][c] += dfs(nr, nc, dp) % 1000000007;
        }
        return dp[r][c];
    }
}