class WorkoutSolutions {
    public int mostFrequentElement(int[] nums) {
        // Brute

        // int max = nums[0];
        // for (int idx = 1; idx < nums.length; idx++) {
        // if (nums[idx] > max)
        // max = nums[idx];
        // }

        // int[] visited = new int[max + 1];
        // int maxFreq = -1, maxEle = 0;
        // int count;
        // for (int idx = 0; idx < nums.length; idx++) {
        // if (visited[nums[idx]] != 1) {
        // count = 0;
        // for (int subIdx = 0; subIdx < nums.length; subIdx++) {
        // if (nums[subIdx] == nums[idx]) {
        // count++;
        // }
        // }
        // if (count > maxFreq) {
        // maxEle = nums[idx];
        // maxFreq = count;
        // } else if (count == maxFreq && nums[idx] < maxEle) {
        // maxEle = nums[idx];
        // }
        // visited[nums[idx]] = 1;
        // }
        // }

        // return maxEle;

        // Optimal

        int max = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] > max)
                max = nums[idx];
        }

        int[] hashArray = new int[max + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            hashArray[nums[idx]]++;
        }

        int maxEle = 0, maxFreq = -1;
        for (int idx = 0; idx < hashArray.length; idx++) {
            if (hashArray[idx] != 0 && hashArray[idx] > maxFreq) {
                maxFreq = hashArray[idx];
                maxEle = idx;
            }
        }

        return maxEle;
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        int max = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] > max)
                max = nums[idx];
        }

        int[] hashArray = new int[max + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            hashArray[nums[idx]]++;
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for (int idx = 0; idx < hashArray.length; idx++) {
            if (hashArray[idx] != 0 && hashArray[idx] > maxFreq) {
                maxFreq = hashArray[idx];
            }
            if (hashArray[idx] != 0 && hashArray[idx] < minFreq) {
                minFreq = hashArray[idx];
            }
        }

        return minFreq + maxFreq;
    }
}

public class Workout {
    public static void main(String[] args) {
        WorkoutSolutions solutions = new WorkoutSolutions();
        System.out.println(solutions.sumHighestAndLowestFrequency(new int[] { 10, 9, 7, 7, 8, 8, 8 }));
    }
}
