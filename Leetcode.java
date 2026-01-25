class Problems {
    // Max Consecutive Ones
    public int Problem_485(int[] nums) {
        int maxFreq = 0, tempFreq = 0;

        for (int ele : nums) {
            if (ele == 0) {
                tempFreq = 0;
            } else {
                tempFreq += 1;
                if (tempFreq > maxFreq || maxFreq == 0) {
                    maxFreq = tempFreq;
                }
            }
        }

        return maxFreq;
    }

    // Reverse Integer
    public int Problem_7(int x) {
        long reversed = 0;
        int remainder = 0;
        while (x != 0) {
            remainder = x % 10;
            reversed = (reversed * 10) + remainder;
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return (int) (-1 * reversed);
        }

        return (int) reversed;
    }

    // Find the Duplicate Number
    public int Problem_287(int[] nums) {
        // Better O(3n) time and O(n) space

        int max = nums[0];

        for (int num : nums) {
            if (num > max)
                max = num;
        }

        int[] hash = new int[max + 1];
        for (int num : nums) {
            hash[num]++;
        }

        for (int idx = 0; idx < hash.length; idx++) {
            if (hash[idx] > 1)
                return idx;
        }

        return -1;
    }
}

public class Leetcode {
    public static void main(String[] args) {
        Problems problems = new Problems();
        System.out.println(problems.Problem_287(new int[] {3,3,3,3,3 }));
    }
}
