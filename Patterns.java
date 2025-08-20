class Solution {
    /*
     *
     * Write a program to print the below pattern
        1 
        0 1
        1 0 1
        0 1 0 1
        1 0 1 0 1
    *
    */
    public void pattern13(int n) {
        int start;
        for (int row = 1; row <= n; row++) {
            if (row % 2 == 0)
                start = 0;
             else
                start = 1;
            for (int col = 1; col <= row; col++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        *
        **
        ***
        ****
        *****
        ****
        ***
        **
        *
    *
    */
    public void pattern12(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = 1; row < n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        * 
       ***
      *****
     *******
    *********
    *********
     *******
      *****
       ***
        *
    *
    */
    public void pattern11(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int l = 1; l <= n; l++) {
            for (int m = 1; m <= l - 1; m++) {
                System.out.print(" ");
            }
            for (int o = 1; o <= (2 * n) - 1 - 2 * (l - 1); o++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
       *********
        *******
         *****
          ***
           *
     *
     */
    public void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * n) - 1 - 2 * (i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
         *
        ***
       *****
      *******
     *********
     *
     */
    public void pattern9(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
     12345
     1234
     123
     12
     1
     *
     */
    public void pattern8(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    /*
    *
    * Write a program to print the below pattern
          *  
         * *  
        * * *  
       * * * *  
      * * * * *
    */
    public void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
     * 1
     * 22
     * 333
     * 4444
     * 55555
     */
    public void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
     * 1
     * 12
     * 123
     * 1234
     * 12345
     */
    public void pattern5(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
     *****
     ****
     ***
     **
     *
     *
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
     *
     * Write a program to print the below pattern
     *
     ***
     *****
     *******
     *********
     *
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
     *
     * Write a program to print the below pattern
     *
     **
     ***
     ****
     ***** 
     *
     */
    public void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Approach 2
        for (int row = 1; row <= n; row++) {
            System.out.println("*".repeat(row));
        }
    }

    /*
     *
     * Write a program to print the below pattern
     *****
     *****
     *****
     *****
     *****
     *
     */
    public void pattern1(int n) {
        // for (int row = 1; row <= n; row++) {
        // for (int col = 1; col <= n; col++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // Approach 2
        for (int row = 1; row <= n; row++) {
            System.out.println("*".repeat(n));
        }
    }
}

public class Patterns {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.pattern13(5);
    }
}