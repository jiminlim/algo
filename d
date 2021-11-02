class Solution {
    public int solution(int[] budgets, int M) {
        int max = 0;
        for (int b : budgets) Math.max(max, b);

        return reculsion(budgets, M, 0, max + 1);
    }

    private int reculsion(int[] budgets, int M, int low, int high) {
        int mid = (low + high) / 2;
        if (mid <= low) return low;

        int total = 0;
        for (int i = low; i <= high; i++) {
            total += budgets[i];
        }

        if (total < M) {
            return reculsion(budgets, M, mid, high);
        } else if (total > M) {
            return reculsion(budgets, M, low, mid);
        }

        return mid;
    }
}

import java.util.Arrays;

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        Arrays.sort(budgets);

        int low = 0;
        int high = budgets[budgets.length - 1];
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;

            int total = 0;
            for (int i = 0; i < budgets.length; ++i) {
                total += budgets[i];
            }

            if (total > M) {
                high = mid;
            } else {
                low = mid;
                answer = mid;
            }
        }

        return answer;
    }
}
