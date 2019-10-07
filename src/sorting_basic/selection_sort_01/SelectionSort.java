package sorting_basic.selection_sort_01;

public class SelectionSort {

    /**
     * 选择排序，时间复杂度为o(N)
     * @param nums
     */
    /*
     * 选择排序基本思路：
     * 把第一个元素依次和后面的所有元素进行比较。
     * 第一次结束后，就会有最小值出现在最前面。
     * 依次类推
     */
    public static void sort(int[] nums) {

        for (int i = 0; i < nums.length; i ++) {
            // 从0到length - 1开始遍历，从0到length-1，每一个nums[i]都是默认要被交换的值
            // 一开始假定 i便是最小的值，然后跟i + 1之后的数据去比较，若小于i处的数据，那么，
            // 则记下这个最小数据的下标，从i + 1以后的数据中挑出最小值的下标后，
            // 此时再将i和minIndex（即i+1开始处与i比较最小数据的下标）处的值交换即可
            int minIndex = i;
            for (int j = i +1; j < nums.length; j ++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        /*int[] arr = {10,9,8,7,6,5,4,3,2,1};*/
        int[] arr = {1,2,3};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
