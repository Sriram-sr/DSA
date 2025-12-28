import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

class ArraySolutions {
    // Sum of Array Elements
    public int sum(int arr[], int n) {
        int elementsSum = 0;

        for (int idx = 0; idx < n; idx++) {
            elementsSum += arr[idx];
        }

        return elementsSum;
    }

    // Count Odd Numbers in an Array
    public int countOdd(int[] arr, int n) {
        int count = 0;

        for (int idx = 0; idx < n; idx++) {
            if (arr[idx] % 2 == 1) {
                count += 1;
            }
        }

        return count;
    }

    // Check if Array is Sorted
    public boolean arraySortedOrNot(int[] arr, int n) {
        for (int idx = 0; idx <= n - 2; idx++) {
            if (!(arr[idx] <= arr[idx + 1])) {
                return false;
            }
        }
        return true;
    }

    // Reverse an array
    public int[] reverseArray(int[] arr, int n) {
        // Brute

        // int[] tempArray = new int[n];

        // for (int idx = n - 1; idx >= 0; idx--) {
        // tempArray[n - 1 - idx] = arr[idx];
        // }

        // for (int idx = 0; idx < n; idx++) {
        // arr[idx] = tempArray[idx];
        // }

        // return arr;

        // Optimal

        int left = 0;
        int right = n - 1;
        int temp;

        while (right > left) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }

        return arr;
    }

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
        // Brute O(n log n + n)

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

        // Better: O(2n)

        if (nums.length <= 1)
            return -1;

        int largest = nums[0], slargest = Integer.MIN_VALUE;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > largest)
                largest = nums[idx];
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > slargest && nums[idx] != largest) {
                slargest = nums[idx];
            }
        }

        if (slargest == Integer.MIN_VALUE)
            return -1;

        return slargest;

        // Optimal O(n)

        // int max = nums[0], smax = Integer.MIN_VALUE;
        // for (int ele : nums) {
        // if (ele > max) {
        // smax = max;
        // max = ele;
        // } else if (ele > smax && ele < max)
        // smax = ele;
        // }

        // if (smax == Integer.MIN_VALUE)
        // return -1;
        // return smax;
    }

    public int secondSmallestElement(int[] nums) {
        int min = nums[0], smin = Integer.MAX_VALUE;

        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] < min) {
                smin = min;
                min = nums[idx];
            } else if (nums[idx] < smin && nums[idx] != min) {
                smin = nums[idx];
            }
        }

        if (smin == Integer.MAX_VALUE)
            return -1;

        return smin;
    }

    // Maximum Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        // Brute O(n^2) & O(1) space

        int maxFreq = 0, count;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == 1) {
                count = 0;
                for (int subIdx = idx; subIdx < nums.length; subIdx++) {
                    if (nums[subIdx] != 1)
                        break;
                    count++;
                }
                if (count > maxFreq)
                    maxFreq = count;
            }
        }

        return maxFreq;

        // Optimal O(n) & O(1) space

        // int maxFreq = 0, tempFreq = 0;

        // for (int ele : nums) {
        // if (ele == 0) {
        // tempFreq = 0;
        // } else {
        // tempFreq += 1;
        // if (tempFreq > maxFreq) {
        // maxFreq = tempFreq;
        // }
        // }
        // }

        // return maxFreq;
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

        // int uniquePtr = 0;
        // for (int repeatPtr = 1; repeatPtr < nums.length; repeatPtr++) {
        // if (nums[uniquePtr] != nums[repeatPtr]) {
        // nums[uniquePtr + 1] = nums[repeatPtr];
        // uniquePtr++;
        // }
        // }

        // return uniquePtr + 1;

        // Brute O(n log n) & O(n) space

        Set<Integer> set = new TreeSet<>();

        for (int idx = 0; idx < nums.length; idx++) {
            set.add(nums[idx]);
        }

        int uniquePtr = 0;
        for (int ele : set) {
            nums[uniquePtr] = ele;
            uniquePtr++;
        }

        System.out.println(Arrays.toString(nums));
        return set.size();
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
        // Brute O(n1 log n + n2 log n) + O(n1 + n2) & O(n1 + n2) space
        // Where n1 is size of nums1 and n2 is size of nums2

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

        // Better: O(n log n) time, O(1) space

        // Arrays.sort(nums);

        // return nums[nums.length/2];

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

    // Pascal's Triangle III
    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> fullPascalRows = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            fullPascalRows.add(generatePascalRow(row));
        }

        return fullPascalRows;
    }

    // public
    // Rotate matrix by 90 degrees
    public void rotateMatrix(int[][] matrix) {
        // Brute O(2n^2) time and O(n^2) space

        // int rows = matrix.length;
        // int columns = matrix[0].length;
        // int[][] result = new int[rows][columns];

        // for (int row = 0; row < rows; row++) {
        // for (int col = 0; col < columns; col++) {
        // result[col][rows - row - 1] = matrix[row][col];
        // }
        // }

        // // Copy back to original matrix
        // for (int row = 0; row < rows; row++) {
        // for (int col = 0; col < columns; col++) {
        // matrix[row][col] = result[row][col];
        // }
        // }

        // Optimal O(1) space

        // Find transpose and reverse each row
        int n = matrix.length, temp;
        // O(n/2 * n/2)
        for (int row = 0; row < n - 1; row++) {
            for (int col = row + 1; col < n; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // O(n * n/2)
        for (int row = 0; row < n; row++) {
            reverse(matrix[row], 0, matrix[row].length - 1);
        }
    }

    // Two Sum
    public int[] twoSum(int[] nums, int target) {
        // Brute O(n^2) time and O(1) space

        // for (int fPtr = 0; fPtr < nums.length; fPtr++) {
        // for (int sPtr = fPtr + 1; sPtr < nums.length; sPtr++) {
        // if (nums[fPtr] + nums[sPtr] == target) {
        // return new int[] { fPtr, sPtr };
        // }
        // }
        // }

        // return new int[] { -1, -1 };

        // Optimal O(n) time and O(n) space

        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (map.get(target - nums[idx]) != null) {
        // return new int[] { map.get(target - nums[idx]), idx };
        // } else {
        // map.put(nums[idx], idx);
        // }
        // }

        // return new int[] { -1, -1 };

        // Better O(N) + O(N log N) time & O(2N) space

        int[][] indexedArr = new int[nums.length][2];

        for (int idx = 0; idx < nums.length; idx++) {
            indexedArr[idx][0] = nums[idx];
            indexedArr[idx][1] = idx;
        }

        Arrays.sort(indexedArr, (x, y) -> Integer.compare(x[0], y[0]));

        int left = 0, right = indexedArr.length - 1;
        while (left <= right) {
            if (indexedArr[left][0] + indexedArr[right][0] < target) {
                left++;
            } else if (indexedArr[left][0] + indexedArr[right][0] > target) {
                right--;
            } else {
                return new int[] { indexedArr[left][1], indexedArr[right][1] };
            }
        }

        return new int[] { -1, -1 };
    }

    // Two Sum - II
    public boolean isTwoSum(int[] nums, int target) {
        // Optimal O(n log n + n) time and O(1) space

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target)
                left++;
            else if (nums[left] + nums[right] > target)
                right--;
            else
                return true;
        }

        return false;
    }

    // Single Number - I
    public int singleNumber(int[] nums) {
        // Brute O(N^2) & O(1) space

        // int count;

        // for (int idx = 0; idx < nums.length; idx++) {
        // count = 0;
        // for (int subIdx = 0; subIdx < nums.length; subIdx++) {
        // if (count == 2) {
        // break;
        // }
        // if (nums[idx] == nums[subIdx])
        // count++;
        // }
        // if (count == 1)
        // return nums[idx];
        // }

        // return 0;

        // Better O(N + N/2 + 1) & space O(N/2 + 1)

        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int val : nums) {
        // map.put(val, map.getOrDefault(val, 0) + 1);
        // }

        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        // if (entry.getValue() == 1)
        // return entry.getKey();
        // }

        // return 0;

        // Optimal O(N) & O(1) space

        int xor = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            xor ^= nums[idx];
        }

        return xor;
    }

    // Longest subarray with sum K
    public int longestSubarray(int[] nums, int k) {
        // Brute O(n^2) time and O(1) space

        // int maxSub = 0;
        // int sum;

        // for (int left = 0; left < nums.length; left++) {
        // sum = 0;
        // for (int right = left; right < nums.length; right++) {
        // sum += nums[right];
        // if (sum == k && (right - left + 1) > maxSub)
        // maxSub = right - left + 1;
        // }
        // }

        // return maxSub;

        // Better O(N x 1) Time & O(N) Space => Optimal soln when +ve & -ve

        // HashMap<Integer, Integer> map = new HashMap<>();
        // int sum = 0, rem;
        // int maxSub = 0;

        // for (int idx = 0; idx < nums.length; idx++) {
        // sum += nums[idx];
        // if (sum == k)
        // maxSub = Math.max(maxSub, idx + 1);
        // rem = sum - k;
        // if (map.containsKey(rem))
        // maxSub = Math.max(maxSub, idx - map.get(rem));
        // if (!map.containsKey(sum)) {
        // map.put(sum, idx);
        // }
        // }

        // return maxSub;

        // Optimal O(2N) Time & O(1) Space => When all +ve elements

        int left = 0, right = 0;
        int maxSub = 0, sum = nums[0];

        while (right < nums.length) {
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k)
                maxSub = Math.max(maxSub, right - left + 1);

            right++;
            if (right < nums.length)
                sum += nums[right];
        }

        return maxSub;
    }

    public void sortArray(int[] arr) {
        Integer[] indices = new Integer[arr.length];
        int[][] indexedArr = new int[arr.length][2];

        for (int idx = 0; idx < arr.length; idx++) {
            indices[idx] = idx;
        }

        for (int idx = 0; idx < arr.length; idx++) {
            indexedArr[idx][0] = arr[idx];
            indexedArr[idx][1] = idx;
        }

        // Sort indexes
        Arrays.sort(indexedArr, (i, j) -> Integer.compare(i[0], j[0]));

        // Sort values
        Arrays.sort(indices, (x, y) -> Integer.compare(arr[x], arr[y]));

        for (int[] pair : indexedArr) {
            System.out.println(Arrays.toString(pair));
        }
    }

    // 3 Sum
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;

        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // for (int k = j + 1; k < n; k++) {
        // if (nums[i] + nums[j] + nums[k] == 0) {
        // List<Integer> triplet = new ArrayList<>();
        // triplet.add(nums[i]);
        // triplet.add(nums[j]);
        // triplet.add(nums[k]);
        // Collections.sort(triplet);
        // set.add(triplet);
        // }
        // }
        // }
        // }

        // List<List<Integer>> result = new ArrayList<>(set);

        // return result;

        // Better O(n^2) time & O(n) + O(2k) where k is size of triplet(used twice in
        // set & result)
        // TC would have been O(n^2 log m) when used a Treeset where m is current size
        // of set

        // Set<List<Integer>> set = new HashSet<>();
        // Set<Integer> tempHash = new HashSet<>();
        // int k;

        // for (int i = 0; i < nums.length - 1; i++) {
        // tempHash.clear();
        // for (int j = i + 1; j < nums.length; j++) {
        // k = -(nums[i] + nums[j]);
        // if (tempHash.contains(k)) {
        // List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], k));
        // Collections.sort(triplet);
        // set.add(triplet);
        // }
        // tempHash.add(nums[j]);
        // }
        // }

        // List<List<Integer>> result = new ArrayList<>(set);

        // return result;

        // Optimal O(n log n + n^2) time & O(k) space where k is number of triplets

        List<List<Integer>> result = new ArrayList<>();
        int left, right, sum;
        Arrays.sort(nums);

        for (int idx = 0; idx < nums.length; idx++) {
            if (idx > 0 && nums[idx] == nums[idx - 1])
                continue;

            left = idx + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[idx] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[idx], nums[left], nums[right])));
                    left++;
                    right--;

                    while (left < right && nums[left - 1] == nums[left])
                        left++;
                    while (left < right && nums[right + 1] == nums[right])
                        right--;
                }
            }
        }

        return result;
    }

    // 4 Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Better O(n^3) time & O(n) + O(2k) where k is unique quad

        // Set<List<Integer>> set = new HashSet<>();
        // Set<Long> hashSet = new HashSet<>();
        // long threeSum;
        // long fourth;

        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // hashSet.clear();
        // for (int k = j + 1; k < nums.length; k++) {
        // threeSum = (long) nums[i] + nums[j];
        // threeSum += nums[k];
        // fourth = target - threeSum;
        // if (hashSet.contains(fourth)) {
        // List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k], (int)
        // fourth);
        // Collections.sort(tempList);
        // set.add(tempList);
        // }
        // hashSet.add((long) nums[k]);
        // }
        // }
        // }

        // return new ArrayList<>(set);

        // Optimal O(n log n + n ^ 3) time && O(k) where k is number of unique quad

        List<List<Integer>> result = new ArrayList<>();
        int left, right, sum;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j])
                    continue;

                left = j + 1;
                right = nums.length - 1;

                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;

                        while (left < right && nums[left - 1] == nums[left])
                            left++;
                        while (left < right && nums[right + 1] == nums[right])
                            right--;
                    }
                }
            }
        }

        return result;
    }

    // Sort an array of 0's 1's and 2's
    public void sortZeroOneTwo(int[] nums) {
        // Brute O(n ^ 2) time & O(1) space

        // int minIdx, temp;

        // for (int idx = 0; idx < nums.length; idx++) {
        // minIdx = idx;
        // for (int subIdx = idx + 1; subIdx < nums.length; subIdx++) {
        // if (nums[subIdx] < nums[minIdx])
        // minIdx = subIdx;
        // }
        // if (minIdx != idx) {
        // temp = nums[minIdx];
        // nums[minIdx] = nums[idx];
        // nums[idx] = temp;
        // }
        // }

        // System.out.println(Arrays.toString(nums));

        // Better O(2n)

        // int cntZero = 0;
        // int cntOne = 0;
        // int cntTwo = 0;

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (nums[idx] == 0)
        // cntZero++;
        // else if (nums[idx] == 1)
        // cntOne++;
        // else
        // cntTwo++;
        // }

        // for (int idx = 0; idx < cntZero; idx++)
        // nums[idx] = 0;
        // for (int idx = cntZero; idx < cntZero + cntOne; idx++)
        // nums[idx] = 1;
        // for (int idx = cntZero + cntOne; idx < nums.length; idx++)
        // nums[idx] = 2;

        // System.out.println(Arrays.toString(nums));

        // Optimal O(n) time & O(1) space
        // Dutch National Flag Algorithm

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp;

        while (mid <= high) {
            if (nums[mid] == 0) {
                temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    // Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        // Brute O(n^2) time & O(1) space

        // if (nums.length == 1)
        // return nums[0];

        // int maxSum = Integer.MIN_VALUE, count;
        // int n = nums.length;

        // for (int idx = 0; idx < n; idx++) {
        // count = 0;
        // for (int subIdx = idx; subIdx < n; subIdx++) {
        // count += nums[subIdx];
        // if (count > maxSum)
        // maxSum = count;
        // }
        // }

        // return maxSum;

        // Optimal O(n) time & O(1) space

        // int maxSum = Integer.MIN_VALUE;
        // int tempSum = 0;

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (tempSum < 0)
        // tempSum = 0;
        // tempSum += nums[idx];
        // if (tempSum > maxSum)
        // maxSum = tempSum;
        // }

        // return maxSum;

        // Find indexes O(n) time & O(1) space

        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        int tempStart = 0;
        int subStart = -1, subEnd = -1;

        for (int idx = 0; idx < nums.length; idx++) {
            if (tempSum == 0)
                tempStart = idx;
            if (tempSum < 0)
                tempSum = 0;
            tempSum += nums[idx];
            if (tempSum > maxSum) {
                maxSum = tempSum;
                subStart = tempStart;
                subEnd = idx;
            }
        }

        System.out.println(subStart + " " + subEnd);
        return maxSum;
    }

    // Next Permutation
    public void nextPermutation(int[] nums) {
        // Optimal O(3n) time & O(1) space

        int n = nums.length, temp;
        int breakIdx = -1;

        // Find dip point from the right
        for (int idx = n - 2; idx >= 0; idx--) {
            if (nums[idx] < nums[idx + 1]) {
                breakIdx = idx;
                break;
            }
        }

        if (breakIdx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Swap the least value from rest which is greater than dip point element
        for (int idx = n - 1; idx > breakIdx; idx--) {
            if (nums[idx] > nums[breakIdx]) {
                temp = nums[breakIdx];
                nums[breakIdx] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        reverse(nums, breakIdx + 1, n - 1);

        System.out.println(Arrays.toString(nums));
    }

    // Best time to buy and sell stock
    public int stockBuySell(int[] arr, int n) {
        // Optimal O(n) time & O(1) space

        int stockPrice = arr[0];
        int profit = 0;

        for (int idx = 1; idx < n; idx++) {
            if (arr[idx] < stockPrice) {
                stockPrice = arr[idx];
            } else {
                if (arr[idx] - stockPrice > profit) {
                    profit = arr[idx] - stockPrice;
                }
            }
        }

        return profit;
    }

    // Longest Consecutive Sequence in an Array
    public int longestConsecutive(int[] nums) {
        // Better O(n + n log n) + O(1)

        // Arrays.sort(nums);

        // int maxSeq = 1;
        // int tempSeq = 0;

        // for (int idx = 0; idx < nums.length - 1; idx++) {
        // if (tempSeq == 0)
        // tempSeq = 1;

        // if (nums[idx + 1] == nums[idx] + 1) {
        // tempSeq++;
        // maxSeq = Math.max(maxSeq, tempSeq);
        // } else if (nums[idx + 1] == nums[idx]) {
        // continue;
        // } else {
        // tempSeq = 0;
        // }
        // }

        // return maxSeq;

        // Optimal O(n + 2n) => O(3n) + O(n) space

        Set<Integer> set = new HashSet<>();

        for (int ele : nums) {
            set.add(ele);
        }

        int maxSeq = 0, count, seqEle;
        for (int ele : set) {
            if (!set.contains(ele - 1)) {
                count = 1;
                seqEle = ele;
                while (set.contains(seqEle + 1)) {
                    count++;
                    seqEle++;
                }
                maxSeq = Math.max(maxSeq, count);
            }
        }

        return maxSeq;
    }

    public void markRow(int[][] matrix, int row, int cols) {
        for (int col = 0; col < cols; col++) {
            if (matrix[row][col] != 0)
                matrix[row][col] = -1;
        }
    }

    public void markCol(int[][] matrix, int col, int rows) {
        for (int row = 0; row < rows; row++) {
            if (matrix[row][col] != 0)
                matrix[row][col] = -1;
        }
    }

    // Set Matrix Zeroes
    public void setZeroes(int[][] matrix) {
        // Brute O((m x n) x (m + n)) + O(m x n) time & O(1) space

        // int m = matrix.length;
        // int n = matrix[0].length;

        // for (int row = 0; row < m; row++) {
        // for (int col = 0; col < n; col++) {
        // if (matrix[row][col] == 0) {
        // markRow(matrix, row, n);
        // markCol(matrix, col, m);
        // }
        // }
        // }

        // for (int row = 0; row < m; row++) {
        // for (int col = 0; col < n; col++) {
        // if (matrix[row][col] == -1) {
        // matrix[row][col] = 0;
        // }
        // }
        // }

        // Brute 2: O(2 x m x n) time & O(m + n) space

        // int m = matrix.length;
        // int n = matrix[0].length;
        // boolean[] rows = new boolean[m];
        // boolean[] columns = new boolean[n];

        // for (int row = 0; row < m; row++) {
        // for (int col = 0; col < n; col++) {
        // if (matrix[row][col] == 0) {
        // rows[row] = true;
        // columns[col] = true;
        // }
        // }
        // }

        // for (int row = 0; row < rows.length; row++) {
        // for (int col = 0; col < columns.length; col++) {
        // if (rows[row] || columns[col])
        // matrix[row][col] = 0;
        // }
        // }

        // Optimal O(2 x m x n) time & O(1) space

        // Considering 1st row & 1st column for tracking rows/colums to be marked 0s
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] == 0) {
                    // For marking columns 0
                    matrix[row][0] = 0;
                    if (col != 0) {
                        // For marking rows 0
                        matrix[0][col] = 0;
                    } else {
                        // 1st row and column colide at (0,0) pos
                        col0 = 0;
                    }
                }
            }
        }

        // Changing 1s to 0's excluding tracking rows and columns
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (matrix[row][col] != 0) {
                    if (matrix[row][0] == 0 || matrix[0][col] == 0)
                        matrix[row][col] = 0;
                }
            }
        }

        // 1st row used for column marking
        if (matrix[0][0] == 0) {
            for (int col = 0; col < m; col++) {
                matrix[0][col] = 0;
            }
        }
        // 1st column used for row marking
        if (col0 == 0) {
            for (int row = 0; row < n; row++) {
                matrix[row][0] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public int subarraySum(int[] nums, int k) {
        // Brute O(n^2)

        int count = 0;
        int sum;

        for (int idx = 0; idx < nums.length; idx++) {
            sum = 0;
            for (int subIdx = idx; subIdx < nums.length; subIdx++) {
                sum += nums[subIdx];
                if (sum == k)
                    count += 1;
            }
        }

        return count;
    }

    public int thirdLargest(int arr[]) {
        if (arr.length < 3) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        int tmax = Integer.MIN_VALUE;

        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] > max) {
                tmax = smax;
                smax = max;
                max = arr[idx];
            } else if (arr[idx] > smax) {
                tmax = smax;
                smax = arr[idx];
            } else if (arr[idx] > tmax) {
                tmax = arr[idx];
            }
        }

        return tmax;
    }

    public List<Integer> majorityElementTwo(int[] nums) {
        // Brute O(n) time & O(n) space

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            if (map.get(ele) > nums.length / 3) {
                if (result.size() == 0 || result.get(0) != ele) {
                    result.add(ele);
                }
            }
            if (result.size() == 2) {
                break;
            }
        }

        return result;

        // Brute O(n^2) time & O(1) space

        // List<Integer> result = new ArrayList<>();
        // int count;

        // for (int ele : nums) {
        // if (result.size() == 0 || result.get(0) != ele) {
        // count = 0;
        // for (int idx = 0; idx < nums.length; idx++) {
        // if (nums[idx] == ele)
        // count++;
        // }
        // if (count > nums.length / 3)
        // result.add(ele);
        // }
        // if (result.size() == 2) {
        // break;
        // }
        // }

        // return result;
    }
}

public class ArrayPrbs {
    public static void main(String[] args) {
        ArraySolutions solution = new ArraySolutions();
        System.out.println(solution.majorityElementTwo(new int[] { 5, 5 }));
    }
}
