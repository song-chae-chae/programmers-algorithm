import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            scores.add(score[i]);
            Collections.sort(scores, Collections.reverseOrder());
            int scoreNum;
            if (i < k) {
                scoreNum = scores.get(scores.size() - 1);
            } else {
                scoreNum = scores.get(k - 1);
            }
            answer[i] = scoreNum;
        }

        return answer;
    }
}