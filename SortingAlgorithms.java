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

    // Bubble Sort
    public int[] bubbleSort(int[] nums) {
        int n = nums.length, temp;
        boolean isSwapped;

        for (int idx = 0; idx <= n - 1; idx++) {
            isSwapped = false;
            for (int subIdx = 0; subIdx < n - 1 - idx; subIdx++) {
                if (nums[subIdx] > nums[subIdx + 1]) {
                    temp = nums[subIdx + 1];
                    nums[subIdx + 1] = nums[subIdx];
                    nums[subIdx] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped)
                break;
        }

        return nums;
    }

    // Insertion Sort
    public int[] insertionSort(int[] nums) {
        int n = nums.length, temp;
        for (int idx = 0; idx < n; idx++) {
            int subIdx = idx;
            while (subIdx > 0) {
                if (nums[subIdx - 1] > nums[subIdx]) {
                    temp = nums[subIdx];
                    nums[subIdx] = nums[subIdx - 1];
                    nums[subIdx - 1] = temp;
                }
                subIdx--;
            }
        }

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
}

public class SortingAlgorithms {
    public static void main(String[] args) {
        SortingSolutions solution = new SortingSolutions();
        System.out.println(Arrays.toString(solution.mergeSort(new int[] { 7, 2, 9, 3, 4 })));
    }
}
