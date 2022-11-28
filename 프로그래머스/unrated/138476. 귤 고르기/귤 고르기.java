import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> sorting = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            if (sorting.containsKey(tangerine[i])) {
                sorting.put(tangerine[i], sorting.get(tangerine[i]) + 1);
            } else {
                sorting.put(tangerine[i], 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> sortedList = sorting.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
        
        int sum = 0;
        for (int i = 0; i < sortedList.size(); i++) {
            sum += sortedList.get(i).getValue();
        
            if (k <= sum) {
                return i + 1;
            }
        }
        
        return sortedList.size();
    }
}