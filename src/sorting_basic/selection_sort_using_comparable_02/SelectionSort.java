package sorting_basic.selection_sort_using_comparable_02;

public class SelectionSort {

    /**
     * 选择排序，时间复杂度为o(N)
     * @param arr
     */
    public static void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i ++) {
            // 从0到length - 1开始遍历，从0到length-1，每一个arr[i]都是默认要被交换的值
            // 一开始假定 i便是最小的值，然后跟i + 1之后的数据去比较，若小于i处的数据，那么，
            // 则记下这个最小数据的下标，从i + 1以后的数据中挑出最小值的下标后，
            // 此时再将i和minIndex（即i+1开始处与i比较最小数据的下标）处的值交换即可
            int minIndex = i;
            for (int j = i +1; j < arr.length; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        /*int[] arr = {10,9,8,7,6,5,4,3,2,1};*/
        Integer[] arrs = {1,2,3,9,1,2,4,3};
        SelectionSort.sort(arrs);
        for( int i = 0 ; i < arrs.length ; i ++ ){
            System.out.print(arrs[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
