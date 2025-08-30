class Solution {
    /*
     *
     * Write a program to print the below pattern
    E 
    D E
    C D E 
    B C D E 
    A B C D E
    *
    */

    public void pattern20(int n) {
        for (int row = 1; row <= n; row++) {
            char element = (char) ('A' + n - row);
            for (int col = 1; col <= row; col++) {
                System.out.print(element + " ");
                element++;
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        A
       ABA
      ABCBA
     ABCDCBA
    ABCDEDCBA
    *
    */
    public void pattern19(int n) {
        /*
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < n - i - 1; x++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print((char)('A' + j));
            }
            System.out.print((char) ('A' + i));
            for (int k = i; k > 0; k--) {
                System.out.print((char) ('A' + k - 1));
            }
            System.out.println();
        }
        */

        // Approach 2

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            char element = 'A';
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(element);
                if (k < i)
                    element++;
                else
                    element--;
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        A
        BB
        CCC
        DDDD
        EEEEE
    *
    */
    public void pattern18(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print((char)('A' + row -1));
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        ABCDE
        ABCD
        ABC
        AB
        A
    *
    */
    public void pattern17(int n) {
        for (int row = 0; row < n; row++) {
            for (char col = 'A'; col < 'A' + n - row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        A
        AB
        ABC
        ABCD
        ABCDE
    *
    */
    public void pattern16(int n) {
        char alphabet;
        for (int row = 1; row <= n; row++) {
            alphabet = 'A';
            for (int col = 1; col <= row; col++) {
                System.out.print(alphabet);
                alphabet += 1;
            }
            System.out.println();
        }

        // Approach 2
        for (int row = 0; row < n; row++) {
            for (char col = 'A'; col <= 'A' + row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        1 
        23
        456
        78910
        1112131415
    *
    */
    public void pattern15(int n) {
        int count = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(count + " ");
                count += 1;
            }
            System.out.println();
        }
    }

    /*
     *
     * Write a program to print the below pattern
        1        1
        12      21
        123    321
        1234  4321
        1234554321
    *
    */
    public void pattern14(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = 1; k <= (2 * n) - (2 * i); k++) {
                System.out.print(" ");
            }
            for (int l = i; l >= 1; l--) {
                System.out.print(l);
            }
            System.out.println();
        }
    }

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
        solution.pattern20(5);
    }
}