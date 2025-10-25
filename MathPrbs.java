import java.util.Arrays;

class MathSolutions {
    // Program to find the sum of digits

    public int sumOfDigits(int num) {
        int rem, digitsSum = 0;

        while (num >= 1) {
            rem = num % 10;
            digitsSum += rem;
            num /= 10;
        }

        return digitsSum;
    }

    // Count number of odd digits in a number

    public int countOddDigit(int n) {
        int oddCount = 0;
        int rem;

        while (n > 0) {
            rem = n % 10;
            if (rem % 2 != 0) {
                oddCount += 1;
            }
            n /= 10;
        }

        return oddCount;
    }

    // Reverse a number

    public int reverseNumber(int num) {
        long reversed = 0;
        int remainder = 0;
        while (num != 0) {
            remainder = num % 10;
            reversed = (reversed * 10) + remainder;
            num /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        if (num < 0) {
            return (int) (-1 * reversed);
        }

        return (int) reversed;
    }

    // Palindrome Number

    public boolean isPalindrome(int n) {
        int original = n;
        int reversed = 0;
        int remainder = 0;
        while (n >= 1) {
            remainder = n % 10;
            reversed = (reversed * 10) + remainder;
            n /= 10;
        }

        if (original == reversed) {
            return true;
        }

        return false;
    }

    // Return the Largest Digit in a Number

    public int getLargest(int n) {
        int largest = 0, rem;

        while (n > 0) {
            rem = n % 10;
            if (rem > largest) {
                largest = rem;
            }
            n /= 10;
        }

        return largest;
    }

    // Factorial of a given number

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int factorial = 1;
        for (int ele = 1; ele <= n; ele++) {
            factorial *= ele;
        }

        return factorial;
    }

    // Program to check whether a given number is Armstrong or not

    public boolean isAmstrongNumber(int num) {
        int length = String.valueOf(num).length();
        int armstrongValue = 0;
        int originalValue = num;
        int remainder;
        while (num > 0) {
            remainder = num % 10;
            armstrongValue += Math.pow(remainder, length);
            num /= 10;
        }
        if (armstrongValue == originalValue) {
            return true;
        }

        return false;
    }

    // Check for Perfect Number

    public boolean isPerfect(int n) {
        // Brute

        /*
         * int perfectNumber = 0;
         * for (int ele = 1; ele < n; ele++) {
         * if (n % ele == 0) {
         * perfectNumber += ele;
         * }
         * }
         * 
         * if (n == perfectNumber) {
         * return true;
         * }
         * 
         * return false;
         * 
         */

        // Optimal

        int perfectNum = n != 1 ? 1 : 0;

        for (int ele = 2; ele * ele <= n; ele++) {
            if (n % ele == 0 && n / ele != ele) {
                perfectNum += ele;
                perfectNum += n / ele;
            }
        }

        return perfectNum == n;
    }

    // Check for Prime Number

    public static boolean isPrime(int n) {
        // Brute

        // if (n == 1) {
        // return false;
        // }
        // for (int i = 2; i < n; i++) {
        // if (n % i == 0) {
        // return false;
        // }
        // }
        // return true;

        // Optimal

        if (n == 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Count of Prime Numbers till N

    public int countPrimeNumbers(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (MathSolutions.isPrime(i)) {
                count += 1;
            }
        }

        return count;
    }

    // GCD of Two Numbers

    public static int gcdOfTwoNumbers(int n1, int n2) {
        // Brute

        // int gcd = 1;
        // int min = n1 < n2 ? n1 : n2;

        // for (int ele = 1; ele <= min; ele++) {
        // if (n1 % ele == 0 && n2 % ele == 0) {
        // gcd = ele;
        // }
        // }

        // return gcd;

        // Optimal

        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        return n1 != 0 ? n1 : n2;
    }

    // LCM of two numbers

    public int lcmOfNumbers(int n1, int n2) {
        // Brute

        // int max = n1 > n2 ? n1 : n2;
        // int count = 1, lcm;

        // do {
        // lcm = count * max;
        // if (lcm % n1 == 0 && lcm % n2 == 0) {
        // break;
        // }
        // count++;
        // } while (count != 0);

        // return lcm;

        // Optimal

        return (n1 * n2) / MathSolutions.gcdOfTwoNumbers(n1, n2);
    }

    // Divisors of a Number

    public int[] getDivisors(int n) {
        // int[] list = new int[n];

        // int count = 0;
        // for (int i = 1; i <= n; i++) {
        // if (n % i == 0) {
        // list[count] = i;
        // count++;
        // }
        // }

        // return Arrays.copyOf(list, count);

        // Optimal

        int count = 0;
        int temp[] = new int[(int) Math.sqrt(n) * 2];

        for (int num = 1; num * num <= n; num++) {
            if (n % num == 0) {
                temp[count++] = num;
                if (num * num != n) {
                    temp[count++] = n / num;
                }
            }
        }

        Arrays.sort(temp, 0, count);

        return Arrays.copyOf(temp, count);
    }

    // Sum of Digits in a Given Number

    public int addDigits(int num) {
        int count = 0;
        while (true) {
            if (count < 10 && num <= 0) {
                break;
            }
            if (num <= 0) {
                num = count;
                count = 0;
            }
            count += num % 10;
            num /= 10;
        }

        return count;
    }

    // Fibonacci Number

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int last = 1, slast = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            current = last + slast;
            slast = last;
            last = current;
        }

        return current;
    }

}

public class MathPrbs {
    public static void main(String[] args) {
        MathSolutions mathSolutions = new MathSolutions();
        System.out.println(mathSolutions.fibonacci(8));
    }
}
