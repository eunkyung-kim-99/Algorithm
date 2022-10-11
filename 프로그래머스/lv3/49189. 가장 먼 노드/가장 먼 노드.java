import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] edgeList = new ArrayList[n+1];
        for(int i = 0; i< edgeList.length; i++){
            edgeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            edgeList[edge[i][0]].add(edge[i][1]);
            edgeList[edge[i][1]].add(edge[i][0]);
        }
        
        int[] dist = new int[n+1];
        boolean[] visit = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for(int m = 0; m < dist.length; m++){
                if(dist[m] < min && !visit[m]){
                    min = dist[m];
                    minIdx= m;
                }
            }
            
            visit[minIdx] = true;
            
            for(int e = 0; e < edgeList[minIdx].size(); e++){
                if(visit[edgeList[minIdx].get(e)]) continue;
                dist[edgeList[minIdx].get(e)] = Math.min(dist[edgeList[minIdx].get(e)], dist[minIdx]+1);
            }
        }
        
        int max = 0;
        int count = 0;
        for(int i = 1; i< dist.length; i++){
            if(dist[i] > max){
                max = dist[i];
                count = 1;
            } else if (dist[i] == max){
                count++;
            }
        }
        System.out.print(Arrays.toString(dist));
        return count;
    }
}