package sorting_basic.selection_sort_01;

public class SelectionSortOptimized {
    /**
     * 选择排序，这个选择排序是对之前那个选择排序的优化
     * 思想：之前那个选择排序只是从一端开始排序，在遍历过程中只保存了一个最小值。
     * 现在的优化是，在遍历过程中从两端开始排序。
     * 即在内循环遍历过程中同时保存最小值和最大值即左边保存最小值，右边保存遍历到的最大值
     * 但是初始遍历比较前要保证arr[left] < arr[right]
     * 外循环是while(left < right)，内循环是for (int i = left + 1; i < right; i ++)
     * @param nums
     */
    public static void sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }
            int minIndex = left;
            int maxIndex = right;
            for (int i = left + 1; i < right; i ++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            left ++;
            right --;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        // int[] arr = {1,2,3};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
