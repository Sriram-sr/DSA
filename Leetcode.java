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
}

public class Leetcode {
    public static void main(String[] args) {
        Problems problems = new Problems();
        System.out.println(problems.Problem_7(123));
    }
}
