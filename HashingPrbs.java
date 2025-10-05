public class HashingPrbs {
    public static Object[] calculateMaxAndHash(int[] nums) {
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

        return new Object[] { max, hash };
    }

    public static int mostFrequentElement(int[] nums) {
        Object[] HashData = HashingPrbs.calculateMaxAndHash(nums);
        int max = (int) HashData[0];
        int[] hash = (int[]) HashData[1];
        int maxFreq = 0, maxEle = -1;
        for (int idx = 0; idx <= max; idx++) {

            if (hash[idx] > maxFreq) {
                maxFreq = hash[idx];
                maxEle = idx;
            }
        }

        return maxEle;
    }

    public static int secondMostFrequentElement(int[] nums) {
        Object[] HashData = HashingPrbs.calculateMaxAndHash(nums);
        int max = (int) HashData[0];
        int[] hash = (int[]) HashData[1];

        int ele1Freq = 0, ele2Freq = 0;
        int ele1 = -1, ele2 = -1;

        for (int idx = 0; idx <= max; idx++) {
            if (hash[idx] > ele1Freq) {
                ele2Freq = ele1Freq;
                ele2 = ele1;
                ele1Freq = hash[idx];
                ele1 = idx;
            } else if (hash[idx] < ele1Freq && hash[idx] > ele2Freq) {
                ele2Freq = hash[idx];
                ele2 = idx;
            }
        }

        return ele2;
    }

    public static int sumHighestAndLowestFrequency(int[] nums) {
        Object[] HashData = HashingPrbs.calculateMaxAndHash(nums);
        int max = (int) HashData[0];
        int[] hash = (int[]) HashData[1];

        int maxFreq = hash[0], minFreq = nums.length;
        for (int idx = 0; idx <= max; idx++) {
            if (hash[idx] != 0) {
                if (hash[idx] > maxFreq) {
                    maxFreq = hash[idx];
                }
                if (hash[idx] < minFreq) {
                    minFreq = hash[idx];
                }
            }
        }

        return maxFreq + minFreq;
    }

    public static void main(String[] args) {
        System.out.println(HashingPrbs.mostFrequentElement(new int[] { 2, 4, 3, 2, 5, 4 }));
        System.out.println(
                HashingPrbs.secondMostFrequentElement(new int[] { 10, 9, 7, 7 }));
        System.out.println(HashingPrbs.sumHighestAndLowestFrequency(new int[] { 10, 9, 7, 7, 8, 8, 8 }));
    }
}
