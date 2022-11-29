class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int realPower = power(i);
            answer += realPower > limit ? power : realPower;
        }

        return answer;
    }

    public int power(int number) {
        int sqrt = (int) Math.sqrt(number);
        int result = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                result++;
                if (number / i != i) {
                    result++;
                }
            }
        }
        return result;
    }
}