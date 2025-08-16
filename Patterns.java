class Solution {
    /*
     * """
        Write a program to print the below pattern

        ****
        ****
        ****
        ****

        """
    */
    public void pattern1(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Patterns {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pattern1(4);
    }
}