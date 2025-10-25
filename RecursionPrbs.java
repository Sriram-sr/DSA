import java.util.ArrayList;

class RecursionSolutions {
    // Sum of First N Numbers
    public int sumOfNaturalNumbers(int N) {
        if (N == 0)
            return 0;

        return N + sumOfNaturalNumbers(N - 1);
    }

    // Factorial of a Given Number
    public long factorial(int n) {
        if (n <= 1)
            return 1;

        return (long) n * factorial(n - 1);
    }

    public int sum(int[] nums, int idx) {
        if (idx < 0) {
            return 0;
        }

        return nums[idx] + sum(nums, idx - 1);
    }

    // Sum of Array Elements
    public int arraySum(int[] nums) {
        return sum(nums, nums.length - 1);
    }

    public void swapCharacters(ArrayList<Character> list, int left, int right) {
        if (left >= right) {
            return;
        }

        char temp = list.get(right);
        list.set(right, list.get(left));
        list.set(left, temp);
        swapCharacters(list, left + 1, right - 1);
    }

    // Reverse a String
    public ArrayList<Character> reverseString(ArrayList<Character> s) {
        swapCharacters(s, 0, s.size() - 1);
        return s;
    }

    public boolean reverse(String s, int left, int right) {
        if (left >= right)
            return true;

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return reverse(s, left + 1, right - 1);
    }

    // Check if String is Palindrome or Not
    public boolean palindromeCheck(String s) {
        return reverse(s, 0, s.length() - 1);
    }

    public boolean isDivisible(int n, int div) {
        if (div * div > n)
            return true;

        if (n % div == 0)
            return false;

        return isDivisible(n, div + 1);
    }

    // Check if a Number is Prime or Not
    public boolean checkPrime(int num) {
        if (num == 1)
            return false;
        if (num == 2)
            return true;

        return isDivisible(num, 2);
    }

    public void swapIntegers(int[] nums, int left, int right) {
        if (left > right)
            return;

        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;

        swapIntegers(nums, left + 1, right - 1);
    }

    // Reverse an array
    public int[] reverseArray(int[] nums) {
        swapIntegers(nums, 0, nums.length - 1);
        return nums;
    }

    public boolean compareElement(ArrayList<Integer> nums, int idx) {
        if (idx == nums.size() - 1)
            return true;

        if (nums.get(idx) > nums.get(idx + 1))
            return false;

        return compareElement(nums, idx + 1);
    }

    // Check if the Array is Sorted
    public boolean isSorted(ArrayList<Integer> nums) {
        if (nums.size() == 1)
            return true;

        return compareElement(nums, 0);
    }

    public int getSumOfDigits(int num) {
        if (num <= 0) {
            return 0;
        }

        return (num % 10) + getSumOfDigits(num / 10);
    }

    // Sum of Digits in a Given Number
    public int addDigits(int num) {
        // Approach 1

        // while (num >= 10) {
        // num = getSumOfDigits(num);
        // }

        // return num;

        // Approach 2

        // if (num < 10) {
        // return num;
        // }

        // int sum = 0;
        // while (num != 0) {
        // sum += num % 10;
        // num /= 10;
        // }

        // return addDigits(sum);

        // Approach 3

        // if (num < 10) {
        // return num;
        // }

        // return addDigits(getSumOfDigits(num));

        // Approach 4

        if (num == 0) {
            return 0;
        }

        return (num - 1) % 9 + 1;
    }

    // Fibonacci Number
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

public class RecursionPrbs {
    public static void main(String[] args) {
        RecursionSolutions solution = new RecursionSolutions();
        System.out.println(solution.addDigits(529));
    }
}
