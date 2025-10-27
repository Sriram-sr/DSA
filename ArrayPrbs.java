import java.util.Arrays;

class ArraySolutions {
    // Linear Search
    public int linearSearch(int nums[], int target) {
        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == target) {
                return idx;
            }
        }

        return -1;
    }

    // Largest Element
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int ele : nums) {
            if (ele > max)
                max = ele;
        }

        return max;
    }

    // Second Largest Element
    public int secondLargestElement(int[] nums) {
        // Brute O(n log n)

        // if (nums.length <= 1) {
        // return -1;
        // }

        // Arrays.sort(nums);
        // int largest = nums[nums.length - 1];
        // for (int idx = nums.length - 2; idx >= 0; idx--) {
        // if (nums[idx] != largest)
        // return nums[idx];
        // }

        // return -1;

        // Optimal O(n)

        int max = nums[0], smax = Integer.MIN_VALUE;
        for (int ele : nums) {
            if (ele > max) {
                smax = max;
                max = ele;
            } else if (ele > smax && ele < max)
                smax = ele;
        }

        if (smax == Integer.MIN_VALUE)
            return -1;
        return smax;
    }

    // Maximum Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
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

    // Left Rotate Array by One
    public void rotateArrayByOne(int[] nums) {
        int temp = nums[0];

        for (int idx = 1; idx <= nums.length - 1; idx++) {
            nums[idx - 1] = nums[idx];
        }

        nums[nums.length - 1] = temp;

        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] arr, int left, int right) {
        int temp;
        while (left < right) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }

    // Left Rotate Array by K Places
    public void rotateArray(int[] nums, int k) {
        // Brute O(n + k) & O(k) space

        // int n = nums.length;
        // int d = k % n;
        // int[] temp = new int[d];

        // for (int idx = 0; idx < d; idx++) {
        // temp[idx] = nums[idx];
        // }

        // for (int idx = d; idx < n; idx++) {
        // nums[idx - d] = nums[idx];
        // }

        // for (int idx = n - d; idx < n; idx++) {
        // nums[idx] = temp[idx - (n - d)];
        // }

        // Optimised O(2n) & O(1) space

        int n = nums.length;
        int d = k % n;
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);
        reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    // Move Zeros to End
    public void moveZeroes(int[] nums) {
        int zeroPointer = -1, temp;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == 0) {
                zeroPointer = idx;
                break;
            }
        }

        if (zeroPointer == -1) {
            return;
        }

        for (int nonZeroPointer = zeroPointer + 1; nonZeroPointer < nums.length; nonZeroPointer++) {
            if (nums[nonZeroPointer] != 0) {
                temp = nums[nonZeroPointer];
                nums[nonZeroPointer] = nums[zeroPointer];
                nums[zeroPointer] = temp;
                zeroPointer++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    // Remove duplicates from sorted array
    public int removeDuplicates(int[] nums) {
        // Optimal O(n) & O(1) space

        // int count = 0, temp = Integer.MIN_VALUE, swapIdx = -1;

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (nums[idx] != temp) {
        // count++;
        // nums[++swapIdx] = nums[idx];
        // }
        // temp = nums[idx];
        // }

        // System.out.println(Arrays.toString(nums));
        // return count;

        // Approach 2 O(n) & O(1) space

        int uniquePtr = 0;
        for (int repeatPtr = 1; repeatPtr < nums.length; repeatPtr++) {
            if (nums[uniquePtr] != nums[repeatPtr]) {
                nums[uniquePtr + 1] = nums[repeatPtr];
                uniquePtr++;
            }
        }

        return uniquePtr + 1;
    }
}

public class ArrayPrbs {
    public static void main(String[] args) {
        ArraySolutions solution = new ArraySolutions();
        System.out.println(solution.removeDuplicates(new int[] { -2, 2, 4, 4, 4, 4, 5, 5 }));
    }
}
