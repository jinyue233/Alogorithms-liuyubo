package sorting_basic.selection_sort_using_comparable_02;

public class SelectionSortOptimized {
    /**
     * 选择排序，这个选择排序是对之前那个选择排序的优化
     * 思想：之前那个选择排序只是从一端开始排序，在遍历过程中只保存了一个最小值。
     * 现在的优化是，在遍历过程中从两端开始排序。
     * 即在内循环遍历过程中同时保存最小值和最大值即左边保存最小值，右边保存遍历到的最大值
     * 但是初始遍历比较前要保证arr[left] < arr[right]
     * 外循环是while(left < right)，内循环是for (int i = left + 1; i < right; i ++)
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left].compareTo(arr[right]) > 0) {
                swap(arr, left, right);
            }
            int minIndex = left;
            int maxIndex = right;
            for (int i = left + 1; i < right; i ++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                }
                if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
            left ++;
            right --;
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

//       Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        // int[] arr = {1,2,3};
        Student[] arr = {new Student("liming",100), new Student("zhangsan", 11), new Student("xiaohong", 15)};
        SelectionSort.sort(arr);
        for( int  i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
