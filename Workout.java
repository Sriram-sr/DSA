import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    int freq;
    char ele;

    Pair(int freq, char ele) {
        this.freq = freq;
        this.ele = ele;
    }
}

class WorkoutSolutions {
    public int mostFrequentElement(int[] nums) {
        // Brute

        // int max = nums[0];
        // for (int idx = 1; idx < nums.length; idx++) {
        // if (nums[idx] > max)
        // max = nums[idx];
        // }

        // int[] visited = new int[max + 1];
        // int maxFreq = -1, maxEle = 0;
        // int count;
        // for (int idx = 0; idx < nums.length; idx++) {
        // if (visited[nums[idx]] != 1) {
        // count = 0;
        // for (int subIdx = 0; subIdx < nums.length; subIdx++) {
        // if (nums[subIdx] == nums[idx]) {
        // count++;
        // }
        // }
        // if (count > maxFreq) {
        // maxEle = nums[idx];
        // maxFreq = count;
        // } else if (count == maxFreq && nums[idx] < maxEle) {
        // maxEle = nums[idx];
        // }
        // visited[nums[idx]] = 1;
        // }
        // }

        // return maxEle;

        // Optimal

        int max = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] > max)
                max = nums[idx];
        }

        int[] hashArray = new int[max + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            hashArray[nums[idx]]++;
        }

        int maxEle = 0, maxFreq = -1;
        for (int idx = 0; idx < hashArray.length; idx++) {
            if (hashArray[idx] != 0 && hashArray[idx] > maxFreq) {
                maxFreq = hashArray[idx];
                maxEle = idx;
            }
        }

        return maxEle;
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        int max = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] > max)
                max = nums[idx];
        }

        int[] hashArray = new int[max + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            hashArray[nums[idx]]++;
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for (int idx = 0; idx < hashArray.length; idx++) {
            if (hashArray[idx] != 0 && hashArray[idx] > maxFreq) {
                maxFreq = hashArray[idx];
            }
            if (hashArray[idx] != 0 && hashArray[idx] < minFreq) {
                minFreq = hashArray[idx];
            }
        }

        return minFreq + maxFreq;
    }

    public String largeOddNum(String s) {
        int n = s.length();
        int lastIdx = -1, firstIdx = -1;
        for (int idx = n - 1; idx >= 0; idx--) {
            if ((s.charAt(idx) - '0') % 2 != 0) {
                lastIdx = idx;
                break;
            }
        }

        if (lastIdx == -1)
            return "";

        for (int idx = 0; idx < n; idx++) {
            if (s.charAt(idx) - '0' != 0) {
                firstIdx = idx;
                break;
            }
        }

        return s.substring(firstIdx, lastIdx + 1);
    }

    public boolean rotateString(String s, String goal) {
        String concatenatedStr = s + s;

        return concatenatedStr.contains(goal);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] hash = new int[26];

        for (int idx = 0; idx < s.length(); idx++) {
            hash[s.charAt(idx) - 'a'] = 1;
        }

        for (int idx = 0; idx < t.length(); idx++) {
            if (hash[t.charAt(idx) - 'a'] != 1)
                return false;
        }

        return true;
    }

    public List<Character> frequencySort(String s) {
        Pair[] hash = new Pair[26];

        for (int idx = 0; idx < hash.length; idx++) {
            hash[idx] = new Pair(0, (char) (idx + 'a'));
        }

        for (int idx = 0; idx < s.length(); idx++) {
            hash[s.charAt(idx) - 'a'].freq++;
        }

        Arrays.sort(hash, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ele - p2.ele;
        });

        List<Character> ans = new ArrayList<>();

        for (int idx = 0; idx < hash.length; idx++) {
            if (hash[idx].freq == 0)
                break;
            ans.add(hash[idx].ele);
        }

        return ans;
    }

    public void rotateArrayByOne(int[] nums) {
        int first = nums[0];

        for (int idx = 1; idx < nums.length; idx++) {
            nums[idx - 1] = nums[idx];
        }

        nums[nums.length - 1] = first;
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int zPtr = -1;
        int temp;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] == 0) {
                zPtr = idx;
                break;
            }
        }

        for (int nPtr = zPtr + 1; nPtr < nums.length; nPtr++) {
            if (nums[nPtr] != 0) {
                temp = nums[nPtr];
                nums[nPtr] = nums[zPtr];
                nums[zPtr] = temp;
                zPtr++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int fPtr = 0;

        for (int sPtr = 1; sPtr < nums.length; sPtr++) {
            if (nums[sPtr] != nums[fPtr]) {
                nums[fPtr + 1] = nums[sPtr];
                fPtr++;
            }
        }

        return fPtr + 1;
    }

    public int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                count += (mid - left + 1);
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int idx = low; idx <= high; idx++) {
            arr[idx] = temp.get(idx - low);
        }

        return count;
    }

    public int mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return 0;

        int count = 0;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    public void mergeSortArray(int[] arr) {
        int inversions = mergeSort(arr, 0, arr.length - 1);
        System.out.println(inversions);
    }

    public int[] getFloorAndCeil(int[] nums, int x) {
        int floor = -1, ceil = -1;

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] <= x) {
                floor = nums[idx];
            }
            if (nums[idx] >= x) {
                ceil = nums[idx];
                break;
            }
        }

        return new int[] { floor, ceil };
    }

    public int lowerBound(int[] nums, int x) {
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

    public int upperBound(int[] nums, int x) {
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

    public int[] searchRange(int[] nums, int target) {
        // int first = -1, last = -1;

        // for (int idx = 0; idx < nums.length; idx++) {
        // if (nums[idx] == target) {
        // if (last == -1) {
        // first = idx;
        // last = idx;
        // } else {
        // last = idx;
        // }
        // }
        // }

        // return new int[] { first, last };

        // Approach 2

        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);

        if (lb != nums.length && nums[lb] == target) {
            return new int[] { lb, ub - 1 };
        }

        return new int[] { -1, -1 };
    }

    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == k) {
                return true;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high++;
                continue;
            }

            if (nums[low] < nums[mid]) {
                if (nums[low] <= k && k <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= k && k <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public int floorSqrt(int n) {
        int low = 1;
        int high = n;
        int mid;
        long val;

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

    public int minimumRateToEatBananas(int[] nums, int h) {
        // Initialize binary search bounds
        int low = 1, high = findMax(nums);

        // Apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            long totalH = calculateTotalHours(nums, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

public class Workout {
    public static void main(String[] args) {
        WorkoutSolutions solutions = new WorkoutSolutions();
        System.out.println(solutions.floorSqrt(18));
    }
}
