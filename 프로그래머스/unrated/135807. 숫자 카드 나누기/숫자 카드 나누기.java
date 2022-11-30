import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> aDivisors = getDivisors(maxDivisor(arrayA));
        System.out.println("aDivisors = " + aDivisors);
        List<Integer> bDivisors = getDivisors(maxDivisor(arrayB));
        System.out.println("bDivisors = " + bDivisors);
        List<Integer> aConditionSatisfyNumber = findNumberSatisfyCondition(aDivisors, arrayB);
        List<Integer> bConditionSatisfyNumber = findNumberSatisfyCondition(bDivisors, arrayA);

        List<Integer> result = aConditionSatisfyNumber;
        result.addAll(bConditionSatisfyNumber);

        Collections.sort(result);

        if (result.size() == 0) return 0;
        return result.get(result.size() - 1);
    }

    public List<Integer> findNumberSatisfyCondition(List<Integer> divisors, int[] array) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (Integer divisor : divisors) {
                if (array[i] % divisor == 0) {
                    result.add(divisor);
                }
            }
        }
        divisors.removeAll(new ArrayList<>(result));
        return divisors;
    }

    // 약수
    public List<Integer> getDivisors(int maxDivisor) {
        int sqrt = (int) Math.sqrt(maxDivisor);
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (maxDivisor % i == 0) {
                result.add(i);
                if (i != maxDivisor / i) {
                    result.add(maxDivisor / i);
                }
            }
        }
        System.out.println(result.toString());
        return result;
    }
    
    public int maxDivisor(int[] array) {
        int dividend = array[array.length - 1]; // 나누어지는 수
        for (int i = array.length - 2; i >= 0; i--) {
            dividend = divider(dividend, array[i]);
        }
        return dividend;
    }
    
    public int divider(int dividend, int divisor) {
        if (dividend % divisor == 0) return divisor;
        return divider(divisor, dividend % divisor);
    }
}