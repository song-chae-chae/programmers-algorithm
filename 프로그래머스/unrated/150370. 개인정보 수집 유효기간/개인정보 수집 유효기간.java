import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answers = new ArrayList<>();
        Map<String, String> term = new HashMap<String, String>();

        for (String s : terms) {
            term.put(s.split(" ")[0], s.split(" ")[1]);
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String privacyDate = privacy[0];
            String privacyType = privacy[1];

            int destructionDate = getDestructionDate(privacyDate, term.get(privacyType));

            if (haveToDestruct(destructionDate, convertDateInteger(today))) {
                answers.add(i + 1);
            }

        }
        return answers.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public int getDestructionDate(String date, String storagePeriod) {
        return convertDateInteger(date) + (Integer.parseInt(storagePeriod) * 28);
    }

    public int convertDateInteger(String date) {
        String[] dates = date.split("\\.");

        int year = Integer.parseInt(dates[0]) * 12 * 28;
        int month = Integer.parseInt(dates[1]) * 28;
        int day = Integer.parseInt(dates[2]);

        return year + month + day;
    }

    public boolean haveToDestruct(int destructionDate, int todayDate) {
        return destructionDate - todayDate <= 0;
    }
}