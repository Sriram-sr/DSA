import java.util.ArrayList;
import java.util.Arrays;

class SortingSolutions {
    // Selection Sort
    public int[] selectionSort(int nums[]) {
        int n = nums.length, minIdx, temp;
        for (int idx = 0; idx < n - 1; idx++) {
            minIdx = idx;
            for (int subIdx = idx; subIdx < n; subIdx++) {
                if (nums[subIdx] < nums[minIdx]) {
                    minIdx = subIdx;
                }
            }
            if (minIdx == idx)
                continue;
            temp = nums[minIdx];
            nums[minIdx] = nums[idx];
            nums[idx] = temp;
        }

        return nums;
    }

    public void bubbleSortRecursive(int[] arr, int n) {
        if (n == 1)
            return;

        boolean isSwapped = false;
        int temp;

        for (int idx = 0; idx < n - 1; idx++) {
            if (arr[idx] > arr[idx + 1]) {
                temp = arr[idx + 1];
                arr[idx + 1] = arr[idx];
                arr[idx] = temp;
                isSwapped = true;
            }
        }

        if (!isSwapped)
            return;

        bubbleSortRecursive(arr, n - 1);
    }

    // Bubble Sort
    public int[] bubbleSort(int[] nums) {
        // int n = nums.length, temp;
        // boolean isSwapped;

        // for (int idx = 0; idx <= n - 1; idx++) {
        // isSwapped = false;
        // for (int subIdx = 0; subIdx < n - 1 - idx; subIdx++) {
        // if (nums[subIdx] > nums[subIdx + 1]) {
        // temp = nums[subIdx + 1];
        // nums[subIdx + 1] = nums[subIdx];
        // nums[subIdx] = temp;
        // isSwapped = true;
        // }
        // }
        // if (!isSwapped)
        // break;
        // }

        // return nums;

        // Using recursion O(n^2) time and O(n) space

        bubbleSortRecursive(nums, nums.length);

        return nums;
    }

    public void insertionSortRecursive(int[] arr, int n) {
        if (n == 1)
            return;

        insertionSortRecursive(arr, n - 1);
        int lastIdx = n - 1;
        int temp;

        while (lastIdx > 0) {
            if (arr[lastIdx] < arr[lastIdx - 1]) {
                temp = arr[lastIdx - 1];
                arr[lastIdx - 1] = arr[lastIdx];
                arr[lastIdx] = temp;
            }
            lastIdx--;
        }
    }

    // Insertion Sort
    public int[] insertionSort(int[] nums) {
        // Linear approach O(n ^ 2) space & O(1) time

        // int n = nums.length, temp;
        // for (int idx = 0; idx < n; idx++) {
        // int subIdx = idx;
        // while (subIdx > 0) {
        // if (nums[subIdx - 1] > nums[subIdx]) {
        // temp = nums[subIdx];
        // nums[subIdx] = nums[subIdx - 1];
        // nums[subIdx - 1] = temp;
        // }
        // subIdx--;
        // }
        // }

        // return nums;

        // Recursive approach O(n ^ 2) time and O(n) space

        insertionSortRecursive(nums, nums.length);

        return nums;
    }

    public void merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
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
    }

    public void divide(int arr[], int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public int[] mergeSort(int nums[]) {
        divide(nums, 0, nums.length - 1);

        return nums;
    }

    public int partition(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[low];
        int temp;

        while (left < right) {
            while (arr[left] <= pivot && left <= high - 1)
                left++;
            while (arr[right] > pivot && right >= low - 1)
                right--;

            if (left < right) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        temp = arr[right];
        arr[right] = arr[low];
        arr[low] = temp;

        return right;
    }

    public void divideAndConquer(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIdx = partition(arr, low, high);
            divideAndConquer(arr, low, partitionIdx - 1);
            divideAndConquer(arr, partitionIdx + 1, high);
        }
    }

    public int[] quickSort(int[] nums) {
        divideAndConquer(nums, 0, nums.length - 1);

        return nums;
    }
}

public class SortingAlgorithms {
    public static void main(String[] args) {
        SortingSolutions solution = new SortingSolutions();
        System.out.println(Arrays.toString(solution.insertionSort(new int[] { 7, 4, 1, 5, 3 })));
    }
}
