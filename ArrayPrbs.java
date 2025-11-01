import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

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

    // Find missing number
    public int missingNumber(int[] nums) {
        // Optimal 1 O(n) & O(1) space

        // int n = nums.length;
        // int expectedSum = n * (n + 1) / 2;
        // int actualSum = 0;

        // for (int idx = 0; idx < n; idx++) {
        // actualSum += nums[idx];
        // }

        // return expectedSum - actualSum;

        // Optimal 2 O(n) & O(1) space

        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;

        for (int idx = 0; idx < n; idx++) {
            xor1 ^= idx + 1;
            xor2 ^= nums[idx];
        }

        return xor1 ^ xor2;
    }

    // Union of two sorted arrays
    public int[] unionArray(int[] nums1, int[] nums2) {
        // Brute O((n + m) log(n + m)) + O(n + m) & O(n + m) space

        // Set<Integer> union = new TreeSet<>();

        // for (int ele : nums1) {
        // union.add(ele);
        // }

        // for (int ele : nums2) {
        // union.add(ele);
        // }

        // int resultIdx = 0;
        // int[] result = new int[union.size()];
        // for (int ele : union) {
        // result[resultIdx++] = ele;
        // }

        // return result;

        // Optimal O(n + m) & O(n + m) space

        int firstPtr = 0, secondPtr = 0;
        ArrayList<Integer> unionList = new ArrayList<>();

        while (firstPtr < nums1.length && secondPtr < nums2.length) {
            if (nums1[firstPtr] < nums2[secondPtr]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[firstPtr]) {
                    unionList.add(nums1[firstPtr]);
                }
                firstPtr++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[secondPtr]) {
                    unionList.add(nums2[secondPtr]);
                }
                secondPtr++;
            }
        }

        while (firstPtr < nums1.length) {
            if (unionList.get(unionList.size() - 1) != nums1[firstPtr]) {
                unionList.add(nums1[firstPtr]);
            }
            firstPtr++;
        }

        while (secondPtr < nums2.length) {
            if (unionList.get(unionList.size() - 1) != nums2[secondPtr]) {
                unionList.add(nums2[secondPtr]);
            }
            secondPtr++;
        }

        int[] result = new int[unionList.size()];
        for (int idx = 0; idx < unionList.size(); idx++) {
            result[idx] = unionList.get(idx);
        }

        return result;
    }

    // Intersection of two sorted arrays
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        // Brute force: O(n1 * n2) time, O(n2) extra space for 'visited' (plus
        // O(min(n1,n2)) output )

        // int[] visited = new int[nums2.length];
        // ArrayList<Integer> intersectionList = new ArrayList<>();

        // for (int fPtr = 0; fPtr < nums1.length; fPtr++) {
        // for (int sPtr = 0; sPtr < nums2.length; sPtr++) {
        // if (visited[sPtr] != 1 && nums1[fPtr] == nums2[sPtr]) {
        // intersectionList.add(nums1[fPtr]);
        // visited[sPtr] = 1;
        // break;
        // }
        // if (nums2[sPtr] > nums1[fPtr]) {
        // break;
        // }
        // }
        // }

        // int[] result = new int[intersectionList.size()];
        // for (int idx = 0; idx < intersectionList.size(); idx++) {
        // result[idx] = intersectionList.get(idx);
        // }

        // return result;

        // Optimal: O(n1 + n2) time, O(min(n1, n2)) space

        int fPtr = 0, sPtr = 0;
        ArrayList<Integer> intersectionList = new ArrayList<>();

        while (fPtr < nums1.length && sPtr < nums2.length) {
            if (nums1[fPtr] < nums2[sPtr]) {
                fPtr++;
            } else if (nums2[sPtr] < nums1[fPtr]) {
                sPtr++;
            } else {
                intersectionList.add(nums1[fPtr]);
                fPtr++;
                sPtr++;
            }
        }

        int[] result = new int[intersectionList.size()];
        for (int idx = 0; idx < intersectionList.size(); idx++) {
            result[idx] = intersectionList.get(idx);
        }

        return result;
    }

    // Majority Element-I
    public int majorityElement(int[] nums) {
        // Brute force: O(n^2) time, O(1) space

        // int half = nums.length / 2, count;

        // for (int idx = 0; idx < nums.length; idx++) {
        // count = 0;
        // for (int subIdx = 0; subIdx < nums.length; subIdx++) {
        // if (nums[idx] == nums[subIdx])
        // count++;
        // }

        // if (count > half)
        // return nums[idx];
        // }

        // return -1;

        // Better: O(n) time, O(n) space

        // int half = nums.length / 2;
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int ele : nums) {
        // map.put(ele, map.getOrDefault(ele, 0) + 1);
        // }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // if (entry.getValue() > half)
        // return entry.getKey();
        // }

        // return -1;

        // Optimal: O(n) time, O(1) space

        int ele = 0, count = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            if (count == 0)
                ele = nums[idx];
            if (nums[idx] == ele) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }

    // Leaders in an Array
    public List<Integer> leaders(int[] nums) {
        // Brute: O(n^2) time, O(n) space
        // List<Integer> leaders = new ArrayList<>();
        // boolean isLeader;

        // for (int idx = 0; idx < nums.length; idx++) {
        // isLeader = true;
        // for (int subIdx = idx + 1; subIdx < nums.length; subIdx++) {
        // if (nums[subIdx] >= nums[idx]) {
        // isLeader = false;
        // break;
        // }
        // }
        // if (isLeader) {
        // leaders.add(nums[idx]);
        // }
        // }

        // return leaders;

        // Optimal: O(n) time, O(n) space

        List<Integer> leaders = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            if (nums[idx] > max) {
                max = nums[idx];
                leaders.add(nums[idx]);
            }
        }

        // Reverse for correct order
        int left = 0, right = leaders.size() - 1, temp;
        while (left < right) {
            temp = leaders.get(right);
            leaders.set(right, leaders.get(left));
            leaders.set(left, temp);
            left++;
            right--;
        }

        return leaders;
    }

    // Rearrange array elements by sign
    public int[] rearrangeArray(int[] nums) {
        // Brute: O(2n) time, O(n) space

        // List<Integer> positives = new ArrayList<>();
        // List<Integer> negatives = new ArrayList<>();

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (nums[idx] < 0)
        // negatives.add(nums[idx]);
        // else
        // positives.add(nums[idx]);
        // }

        // for (int idx = 0; idx < nums.length / 2; idx++) {
        // nums[2 * idx] = positives.get(idx);
        // nums[2 * idx + 1] = negatives.get(idx);
        // }

        // return nums;

        // Optimal: O(n) time, O(n) space

        int[] result = new int[nums.length];
        int positivePtr = 0, negativePtr = 1;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] < 0) {
                result[negativePtr] = nums[idx];
                negativePtr += 2;
            } else {
                result[positivePtr] = nums[idx];
                positivePtr += 2;
            }
        }

        return result;
    }

    // Print the matrix in spiral manner
    public List<Integer> spiralOrder(int[][] matrix) {
        // Optimal: O(row * col) time and O(row * col) space

        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, top = 0;
        int right = columns - 1, bottom = rows - 1;
        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {
            for (int ptr = left; ptr <= right; ptr++) {
                result.add(matrix[top][ptr]);
            }
            top++;
            for (int ptr = top; ptr <= bottom; ptr++) {
                result.add(matrix[ptr][right]);
            }
            right--;
            if (top <= bottom) {
                for (int ptr = right; ptr >= left; ptr--) {
                    result.add(matrix[bottom][ptr]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int ptr = bottom; ptr >= top; ptr--) {
                    result.add(matrix[ptr][left]);
                }
                left++;
            }
        }

        return result;
    }

    public int nCr(int n, int r) {
        if (r == 1)
            return n;

        int answer = 1;

        for (int idx = 0; idx < r; idx++) {
            answer *= n - idx;
            answer /= idx + 1;
        }

        return answer;
    }

    // Pascal's Triangle I
    public int pascalTriangleI(int r, int c) {
        // Optimal O(r) time and O(1) space
        return nCr(r - 1, c - 1);
    }

    // Pascal's Triangle II
    public int[] pascalTriangleII(int r) {
        // Optimal O(r) time and O(r) space

        int temp = 1;
        int[] result = new int[r];
        result[0] = 1;

        for (int idx = 1; idx < r; idx++) {
            temp *= r - idx;
            temp /= idx;
            result[idx] = temp;
        }

        return result;
    }

    public List<Integer> generatePascalRow(int r) {
        int temp = 1;
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int idx = 1; idx < r; idx++) {
            temp *= r - idx;
            temp /= idx;
            result.add(temp);
        }

        return result;
    }

    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> fullPascalRows = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            fullPascalRows.add(generatePascalRow(row));
        }

        return fullPascalRows;
    }
}

public class ArrayPrbs {
    public static void main(String[] args) {
        ArraySolutions solution = new ArraySolutions();
        System.out.println(solution.pascalTriangleIII(6));
    }
}
