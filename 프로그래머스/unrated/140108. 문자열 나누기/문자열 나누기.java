class Solution {
    public int solution(String s) {
        int answer = 0;
        String word = s;
        int firstLetterCount = 0;
        int otherLetterCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(0) == word.charAt(i)) {
                firstLetterCount++;
            } else {
                otherLetterCount++;
            }

            if (firstLetterCount == otherLetterCount) {
                word = word.substring(i + 1);
                answer++;
                firstLetterCount = 0;
                otherLetterCount = 0;

                i = -1;
            } else if (i == word.length() - 1) {
                answer++;
            }
            
        }


        return answer;
    }
}