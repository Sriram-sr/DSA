public class HashingPrbs {
    public static int mostFrequentElement(int[] nums) {
        int n = nums.length;
        int max = nums[0];

        for (int idx = 1; idx < n; idx++) {
            if (nums[idx] > max) {
                max = nums[idx];
            }
        }

        int[] hash = new int[max + 1];
        for (int idx = 0; idx < n; idx++) {
            hash[nums[idx]]++;
        }

        int maxFreq = 0, maxEle = -1;
        for (int idx = 0; idx <= max; idx++) {
            
            if (hash[idx] > maxFreq) {
                maxFreq = hash[idx];
                maxEle = idx;
            }
        }

        return maxEle;
    }

    public static void main(String[] args) {
        System.out.println(HashingPrbs.mostFrequentElement(new int[] { 2, 4, 3, 2, 5, 4 }));
    }
}
