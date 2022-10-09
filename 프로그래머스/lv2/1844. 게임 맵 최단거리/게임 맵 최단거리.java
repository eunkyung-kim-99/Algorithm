import java.util.Queue;
import java.util.LinkedList;

class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        
        return answer;
    }
    
    public int bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        map[0][0] = -1;
        
        while(!q.isEmpty()){
            int[] c = q.poll();
            if(c[0] == map.length-1 && c[1]== map[0].length-1){
                return c[2];
            }
            for(int d = 0; d < dx.length; d++){
                int nr = c[0]+dx[d];
                int nc = c[1]+dy[d];
                if(nr<0 || nr>= map.length || nc<0 || nc>= map[0].length || map[nr][nc] != 1) 
                    continue;
                map[nr][nc] = -1;
                q.add(new int[]{nr,nc, c[2]+1});
            }
        }
        return -1;
    }
}