class Solution {
    /*
     * """
     * Write a program to print the below pattern
     *****
     ****
     ***
     **
     *
     * """
     */
    public void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     * """
     * Write a program to print the below pattern
     *
     ***
     *****
     *******
     *********
     * """
     */
    public void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row * 2 - 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     * """
     * Write a program to print the below pattern
     *
     **
     ***
     ****
     ***** 
     * """
     */
    public void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     * """
     * Write a program to print the below pattern
     *****
     *****
     *****
     *****
     *****
     * """
     */
    public void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Patterns {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pattern4(5);
    }
}