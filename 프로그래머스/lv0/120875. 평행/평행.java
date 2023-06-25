class Solution {
    public int solution(int[][] dots) {
        double a1 = (double) (dots[0][0] - dots[1][0]) /(double) (dots[0][1] - dots[1][1]);
        double a2 = (double)(dots[0][0] - dots[2][0]) / (double)(dots[0][1] - dots[2][1]);
        double a3 = (double)(dots[0][0] - dots[3][0]) / (double)(dots[0][1] - dots[3][1]);

        double a4 = (double)(dots[1][0] - dots[2][0]) / (double)(dots[1][1] - dots[2][1]);
        double a5 = (double)(dots[1][0] - dots[3][0]) / (double)(dots[1][1] - dots[3][1]);
        double a6 = (double)(dots[2][0] - dots[3][0]) / (double)(dots[2][1] - dots[3][1]);

        if (a1 == a6 || a2 == a5 || a3 == a4) {
            return 1;
        }

        return 0;
    }
}