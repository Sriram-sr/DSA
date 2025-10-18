class Problems {
    public int Problem_7(int x) {
        // Reverse Integer

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
