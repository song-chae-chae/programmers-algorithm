class Solution {
    public int solution(String[] babbling) {
        String[] canSpeak = new String[]{
                "aya", "ye", "woo", "ma"
        };

        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < canSpeak.length; j++) {
                babbling[i] = babbling[i].replace(canSpeak[j], "_");

            }

            if (babbling[i].replaceAll("_", "").length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}