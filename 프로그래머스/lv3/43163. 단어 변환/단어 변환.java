class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] v = new boolean[words.length];
        dfs(begin, target, words, v, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] v, int count) {
        // System.out.println(begin);
        if(begin.equals(target)){
            answer = Math.min(answer, count);
            return;
        }
        for(int i = 0; i < words.length;  i++) {
            if(v[i]) continue;
            int cnt = 0;
            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    cnt++;
                }
            }
            if(cnt != 1) continue;
            v[i] = true;
            dfs(words[i], target, words, v, count+1);
            v[i] = false;
        }
    }
    
}