class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int startNum = ((total - num * (num + 1) / 2) / num) + 1;

        for (int j = 0; j < num; j++) {
            answer[j] = startNum;
            startNum++;
        }

        return answer;
    }
}