import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
       int answer = 0;
        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());
        int boxCount = score.length / m;
        
        for (int i = 0; i < boxCount; i++) {
            Integer[] splitApples = Arrays.copyOfRange(scores, i * m, i * m + m);
            answer += splitApples[splitApples.length - 1] * splitApples.length;
        }
        return answer;
    }
}