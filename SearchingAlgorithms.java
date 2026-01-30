import java.util.ArrayList;
import java.util.Arrays;

class SearchingSolutions {
    public int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (target == arr[mid])
            return mid;
        else if (target > arr[mid])
            return binarySearchRecursive(arr, target, mid + 1, high);

        return binarySearchRecursive(arr, target, low, mid - 1);
    }

    public int binarySearch(int[] nums, int target) {
        // O(log n) Approach - Iterative

        // int low = 0, mid, high = nums.length - 1;

        // while (low <= high) {
        // mid = (low + high) / 2;

        // if (nums[mid] == target)
        // return mid;
        // else if (target < nums[mid])
        // high = mid - 1;
        // else
        // low = mid + 1;
        // }
        // return -1;

        // Recursive Approach

        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    // Lower Bound
    public int lowerBound(int[] nums, int x) {
        // O(log n)

        int low = 0;
        int high = nums.length - 1;
        int answer = high + 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= x) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    // Upper Bound
    public int upperBound(int[] nums, int x) {
        // O(log n)

        int low = 0;
        int high = nums.length - 1;
        int answer = high + 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] > x) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    // Search insert position
    public int searchInsert(int[] nums, int target) {
        return lowerBound(nums, target);
    }

    public int getFloor(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int answer = -1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] <= x) {
                answer = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    public int getCeil(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int answer = -1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] >= x) {
                answer = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public int[] getFloorAndCeil(int[] nums, int x) {
        // Optimal I O(2 log n) time & O(1) space

        // return new int[] { getFloor(nums, x), getCeil(nums, x) };

        // Optimal II O(log n) time & O(1) space

        int floor = -1, ceil = -1;
        int low = 0, high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == x) {
                return new int[] { nums[mid], nums[mid] };
            } else if (nums[mid] > x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                floor = nums[mid];
                low = mid + 1;
            }
        }

        return new int[] { floor, ceil };
    }

    public int getFirstOccurance(int[] arr, int target) {
        int first = -1;
        int low = 0;
        int high = arr.length;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    public int getLastOccurance(int[] arr, int target) {
        int last = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    // First and last occurrence
    public int[] getFirstAndLastOccurance(int[] nums, int target) {
        // Brute: O(n)

        // int[] result = { -1, -1 };

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (nums[idx] == target) {
        // if (result[0] == -1)
        // result[0] = idx;
        // result[1] = idx;
        // }
        // }

        // return result;

        // Optimal: 2 O(log n) && O(1) space

        // int lb = lowerBound(nums, target);
        // if (lb == nums.length || nums[lb] != target)
        // return new int[] { -1, -1 };

        // return new int[] { lb, upperBound(nums, target) - 1 };

        // Optimal: Using binary search 2 O(log n) && O(1) space

        int first = getFirstOccurance(nums, target);
        if (first == -1)
            return new int[] { -1, -1 };

        return new int[] { first, getLastOccurance(nums, target) };
    }

    // Search in rotated sorted array-I
    public int rotatedSearch(int[] nums, int k) {
        // Optimal: O(log n) && O(1) space

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == k) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                // This part is checking for left as sorted portion
                if (nums[low] <= k && k <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // This part is checking for right as sorted portion
                if (nums[mid] <= k && k <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    // Count Occurrences in a Sorted Array
    public int countOccurrences(int[] arr, int target) {
        // Optimal: 2 O(log n) && O(1) space

        int[] occurances = getFirstAndLastOccurance(arr, target);

        if (occurances[0] == -1)
            return 0;

        return occurances[1] - occurances[0] + 1;
    }

    // Search in rotated sorted array-II
    public boolean rotatedSearchWithDuplicates(int[] nums, int k) {
        // Optimal
        // O(log n) -> Average case
        // O(n/2) -> Worst case (When there are lot of duplicates, can shrink upto n/2)

        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == k)
                return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                // Shrinking the search space
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                // This part is checking for left as sorted portion
                if (nums[low] <= k && k <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // This part is checking for right as sorted portion
                if (nums[mid] <= k && k <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return false;
    }

    // Find minimum in Rotated Sorted Array
    public int findMin(ArrayList<Integer> arr) {
        // Optimal: O(log n) && O(1) space

        int low = 0;
        int high = arr.size() - 1;
        int minElement = Integer.MAX_VALUE;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            // At some point search space is only sorted
            if (arr.get(low) < arr.get(high)) {
                minElement = Math.min(minElement, arr.get(low));
                break;
            }

            if (arr.get(low) <= arr.get(mid)) {
                minElement = Math.min(minElement, arr.get(low));
                low = mid + 1;
            } else {
                minElement = Math.min(minElement, arr.get(mid));
                high = mid - 1;
            }
        }

        return minElement;
    }

    public int findKRotation(ArrayList<Integer> nums) {
        // Brute: O(n) && O(1) space

        // for (int idx = 0; idx < nums.size() - 1; idx++) {
        // if (nums.get(idx + 1) < nums.get(idx))
        // return idx + 1;
        // }

        // return 0;

        // Optimal: O(log n) && O(1) space

        int low = 0;
        int high = nums.size() - 1;
        int minElement = Integer.MAX_VALUE;
        int minIdx = -1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums.get(low) < nums.get(high)) {
                if (nums.get(low) < minElement) {
                    minElement = nums.get(low);
                    minIdx = low;
                }
                break;
            }

            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < minElement) {
                    minElement = nums.get(low);
                    minIdx = low;
                }
                low = mid + 1;
            } else {
                if (nums.get(mid) < minElement) {
                    minElement = nums.get(mid);
                    minIdx = mid;
                }
                high = mid - 1;
            }
        }

        return minIdx;
    }

    public int singleNonDuplicate(int[] nums) {
        // Brute O(n) time & O(1) space

        // for (int idx = 0; idx < nums.length - 1; idx++) {
        // if (idx == nums.length - 1 && idx % 2 != 0) {
        // return nums[idx];
        // }

        // if (idx % 2 == 0) {
        // if (nums[idx] != nums[idx + 1])
        // return nums[idx];
        // }
        // }

        // return -1;

        // Optimal: O(log n) time & O(1) space

        if (nums.length == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];

        int low = 1;
        int high = nums.length - 2;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int findPeakElement(int[] arr) {
        // Brute - I O(n) time & O(1) space

        // if (arr.length == 1)
        // return 0;

        // if (arr[0] > arr[1]) {
        // return 0;
        // }

        // for (int idx = 1; idx < arr.length; idx++) {
        // if (idx == arr.length - 1) {
        // if (arr[idx - 1] < arr[idx])
        // return idx;
        // }

        // if (arr[idx - 1] < arr[idx] && arr[idx + 1] < arr[idx])
        // return idx;
        // }

        // return -1;

        // Brute - II O(n) time & O(1) space

        // for (int idx = 0; idx < arr.length; idx++) {
        // if ((idx == 0 || arr[idx - 1] < arr[idx]) && (idx == arr.length - 1 ||
        // arr[idx] > arr[idx + 1]))
        // return idx;
        // }

        // return -1;

        // Optimal O(log n) time & O(1) space

        int n = arr.length;
        if (n == 1)
            return 0;

        if (arr[0] > arr[1])
            return 0;

        if (arr[n - 1] > arr[n - 2])
            return n - 1;

        int low = 1, high = n - 2;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if ((arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1]))
                return mid;
            else if (arr[mid] > arr[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    // Find square root of a number
    public int floorSqrt(int n) {
        // Optimal: O(log n)time & O(1) space
        int low = 0;
        int high = n;
        long val;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            val = (long) mid * (long) mid;
            if (val <= (long) n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public long findPower(int b, int exp) {
        long base = b;
        long ans = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans *= base;
            } else {
                exp /= 2;
                base *= base;
            }
        }

        return ans;
    }

    public int findPowHelper(int mid, int N, int M) {
        // O(N) implementation

        // long ans = 1;

        // for (int cnt = 1; cnt <= N; cnt++) {
        // ans *= mid;
        // if (ans > M)
        // return 2;
        // }
        // if (ans == M)
        // return 1;

        // return 0;

        // Alternate O(log N) implementation

        long base = mid;
        long ans = 1;

        while (N > 0) {
            if (N % 2 == 1) {
                N--;
                ans *= base;
                if (ans > M)
                    return 2;
            } else {
                N /= 2;
                base *= base;
                if (base > M)
                    return 2;
            }
        }

        if (ans == M)
            return 1;

        return 0;
    }

    public int NthRoot(int N, int M) {
        // Brute (log M) * O(N) time & O(1) space

        // long value;

        // for (int idx = 1; idx <= M; idx++) {
        // value = findPower(idx, N);
        // if (value == M)
        // return idx;
        // else if (value > M)
        // break;
        // }

        // return -1;

        // Binary search Optimal: O(N log M) or O(log M * log N) based on findPowHelper
        // method implementation

        int low = 0, high = M;
        int mid;
        long answer;

        while (low <= high) {
            mid = (low + high) / 2;
            answer = findPowHelper(mid, N, M);
            if (answer == 1)
                return mid;
            else if (answer == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public int calculateDivSum(int[] nums, int limit, int divisor) {
        int sum = 0;

        for (int num : nums) {
            // sum += Math.ceilDiv(num, divisor);
            sum += (num + divisor - 1) / divisor;
            if (sum > limit)
                return limit + 1;
        }

        return sum;
    }

    // Find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        // Brute: O(n * m) time & O(1) space where m is max element in nums

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        int val;

        for (int divisor = 1; divisor <= max; divisor++) {
            val = 0;
            for (int idx = 0; idx < nums.length; idx++) {
                val += Math.ceil((double) nums[idx] / (double) divisor);
            }
            if (val <= limit)
                return divisor;
        }

        return -1;

        // Optimal: O(n log m) time & O(1) space where m is max element in nums

        // int low = 1;
        // int max = Integer.MIN_VALUE;
        // for (int num : nums) {
        // if (num > max)
        // max = num;
        // }
        // int high = max;
        // int mid, divSum;
        // int minDivisor = -1;

        // while (low <= high) {
        // mid = low + (high - low) / 2;
        // divSum = calculateDivSum(nums, limit, mid);

        // if (divSum <= limit) {
        // minDivisor = mid;
        // high = mid - 1;
        // } else {
        // low = mid + 1;
        // }
        // }

        // return minDivisor;
    }

    public long calculateHours(int[] arr, int hour) {
        long hoursTaken = 0;

        for (int idx = 0; idx < arr.length; idx++) {
            hoursTaken += (long) Math.ceil((double) arr[idx] / (double) hour);
        }

        return hoursTaken;
    }

    // Koko eating bananas
    public int minimumRateToEatBananas(int[] nums, int h) {
        // Brute O(n * m) time & O(1) space where m is max element in nums

        // int max = Integer.MIN_VALUE;

        // for (int num : nums) {
        // if (num > max) {
        // max = num;
        // }
        // }

        // for (int hour = 1; hour <= max; hour++) {
        // if (calculateHours(nums, hour) <= (long) h)
        // return hour;
        // }

        // return max;

        // Optimal

        int max = Integer.MIN_VALUE;
        int mid;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (calculateHours(nums, mid) <= (long) h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isBouquetPossible(int arr[], int day, int adjflwrs, int totalBouquets) {
        int cnt = 0;
        int bouquetsPossible = 0;

        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] <= day) {
                cnt++;
            } else {
                bouquetsPossible += cnt / adjflwrs;
                cnt = 0;
            }
        }

        bouquetsPossible += cnt / adjflwrs;

        return bouquetsPossible >= totalBouquets;
    }

    // Minimum days to make M bouquets
    public int roseGarden(int n, int[] nums, int k, int m) {
        // Brute - 1 O(max * n) time & O(1) space

        // int max = Integer.MIN_VALUE;
        // int requiredRoses = k * m;
        // int rosesBloomed;

        // if (requiredRoses > n) {
        // return -1;
        // }

        // for (int num : nums) {
        // if (num > max) {
        // max = num;
        // }
        // }

        // for (int day = 1; day <= max; day++) {
        // rosesBloomed = 0;
        // for (int idx = 0; idx < nums.length; idx++) {
        // if (idx == 0 && nums[idx] <= day)
        // rosesBloomed++;
        // if (idx != 0 && nums[idx] <= day && nums[idx - 1] <= day)
        // rosesBloomed++;
        // }

        // if (rosesBloomed == requiredRoses) {
        // return day;
        // }
        // }

        // return -1;

        // Brute - 2 O(max - min) * O(n) time & O(1) space

        // if (k * m > n) {
        // return -1;
        // }

        // int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // for (int day : nums) {
        // if (day < min)
        // min = day;
        // if (day > max)
        // max = day;
        // }

        // for (int day = min; day <= max; day++) {
        // if (isBouquetPossible(nums, day, k, m)) {
        // return day;
        // }
        // }

        // return -1;

        // Optimal O(log(max - min)) * O(n) time & O(1) space

        if (k * m > n) {
            return -1;
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int day : nums) {
            if (day < min)
                min = day;
            if (day > max)
                max = day;
        }

        int low = min;
        int high = max;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (isBouquetPossible(nums, mid, k, m))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    public int calculateDays(int[] weights, int maxLoad) {
        int days = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight > maxLoad) {
                days += 1;
                load = weight;
            } else {
                load += weight;
            }
        }

        return days;
    }

    // Capacity to Ship Packages Within D Days
    public int shipWithinDays(int[] weights, int days) {
        // Brute O(sum - max * n) time & O(1) space where sum is total of weights

        // int maxValue = Integer.MIN_VALUE;
        // int maxCapacity = 0;

        // for (int weight : weights) {
        // if (weight > maxValue)
        // maxValue = weight;
        // maxCapacity += weight;
        // }

        // int minCapacity = maxValue;

        // for (int maxLoad = minCapacity; maxLoad <= maxCapacity; maxLoad++) {
        // if (calculateDays(weights, maxLoad) <= days)
        // return maxLoad;
        // }

        // return maxCapacity;

        // Optimal O(n log(sum - max)) time & O(1) space

        int maxValue = Integer.MIN_VALUE;
        int maxCapacity = 0;

        for (int weight : weights) {
            if (weight > maxValue)
                maxValue = weight;
            maxCapacity += weight;
        }

        int minCapacity = maxValue;

        int low = minCapacity;
        int high = maxCapacity;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (calculateDays(weights, mid) <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    // Kth Missing Positive Number
    public int findKthPositive(int[] arr, int k) {
        // Brute (Tried - Won't work for all testcases)

        // int max = 0;
        // for (int num : arr) {
        // if (num > max) {
        // max = num;
        // }
        // }

        // int[] hash = new int[max + 2];
        // for (int num : arr) {
        // hash[num]++;
        // }

        // int cnt = 0;
        // for (int idx = 1; idx < hash.length; idx++) {
        // if (hash[idx] == 0) {
        // cnt++;
        // }
        // if (cnt == k) {
        // return idx;
        // }
        // }

        // return -1;

        // Brute 2

        for (int ele : arr) {
            if (ele <= k)
                k++;
            else
                return k;
        }

        return k;
    }

    public int getCowsPlaced(int[] cows, int distance) {
        int cowPositioned = cows[0];
        int possiblePstns = 1;

        for (int idx = 1; idx < cows.length; idx++) {
            if (cows[idx] - cowPositioned >= distance) {
                possiblePstns++;
                cowPositioned = cows[idx];
            }
        }

        return possiblePstns;
    }

    public int aggressiveCows(int[] nums, int k) {
        // Brute O(max * n) + O n log n time & O(1) space

        // Arrays.sort(nums);
        // int max = nums[nums.length - 1];
        // int cowPositioned, possiblePstns;
        // int maxDistance = 0;

        // for (int distance = 1; distance <= max; distance++) {
        // cowPositioned = nums[0];
        // possiblePstns = 1;
        // for (int idx = 1; idx < nums.length; idx++) {
        // if (nums[idx] >= cowPositioned + distance) {
        // possiblePstns += 1;
        // cowPositioned = nums[idx];
        // }
        // if (possiblePstns == k) {
        // break;
        // }
        // }

        // if (possiblePstns < k) {
        // break;
        // }

        // if (distance > maxDistance) {
        // maxDistance = distance;
        // }

        // }

        // return maxDistance;

        // Optimal O(n log n) + O(n log max) time & O(1) space

        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length - 1];
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            int possiblePstns = getCowsPlaced(nums, mid);
            if (possiblePstns >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public int calculateStudents(int[] arr, int maxPages) {
        int students = 1;
        int currentPages = 0;

        for (int idx = 0; idx < arr.length; idx++) {
            if (currentPages + arr[idx] <= maxPages) {
                currentPages += arr[idx];
            } else {
                students++;
                currentPages = arr[idx];
            }
        }

        return students;
    }

    public int findPages(int[] nums, int m) {
        // Brute tried

        // int n = nums.length;
        // int difference = n - m;
        // int ptr = 0;
        // int pages;
        // int maxPages = Integer.MAX_VALUE;

        // while (ptr + difference < n) {
        // pages = 0;
        // for (int idx = ptr; idx <= ptr + difference; idx++)
        // pages += nums[idx];
        // maxPages = Math.min(maxPages, pages);
        // System.out.println("Pages from " + ptr + " to " + (ptr + difference) + " = "
        // + pages);
        // ptr++;
        // }

        // if (maxPages == Integer.MAX_VALUE)
        // return -1;

        // return maxPages;

        // Brute O((sum - max) * n)

        // if (m > nums.length)
        // return -1;

        // int low = Integer.MIN_VALUE;
        // long high = 0;

        // for (int num : nums) {
        // if (num > low)
        // low = num;
        // high += (long) num;
        // }

        // for (int pages = low; pages <= high; pages++) {
        // if (calculateStudents(nums, pages) <= m)
        // return pages;
        // }

        // return -1;

        // Optimal O(n log (sum - max))

        if (m > nums.length)
            return -1;

        int low = Integer.MIN_VALUE;
        long high = 0;

        for (int num : nums) {
            if (num > low)
                low = num;
            high += (long) num;
        }

        int mid;

        while (low <= high) {
            mid = low + ((int) high - low) / 2;

            if (calculateStudents(nums, mid) <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

public class SearchingAlgorithms {
    public static void main(String[] args) {
        SearchingSolutions solutions = new SearchingSolutions();
        System.out.println(
                solutions.findPages(new int[] { 3, 5, 9, 8, 6 }, 4));
    }
}
