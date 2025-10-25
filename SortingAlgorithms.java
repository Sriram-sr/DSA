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
}

public class SortingAlgorithms {
    public static void main(String[] args) {
        SortingSolutions solution = new SortingSolutions();
        System.out.println(Arrays.toString(solution.selectionSort(new int[] { 5, 3, 1, 2, 4 })));
    }
}
