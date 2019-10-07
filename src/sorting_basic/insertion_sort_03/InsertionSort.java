package sorting_basic.insertion_sort_03;

import sorting_basic.selection_sort_using_comparable_02.SelectionSort;

/**
 * 插入排序：实质为arr[i]找到合适的位置，然后将arr[i]插入到合适的位置即可
 * 关键思想：在外层循环从i=0到i=n-1遍历过程中，i始终与0...i-1之间的数据进行比较
 * 若arr[i]与arr[i-1]比较的话，arr[i] < arr[i - 1]，那么此时将两者对换；
 * 然后arr[i - 1]又与arr[i - 2]进行比较，若arr[i - 1] < arr[i - 2]，那么再将两者对换
 * ...以此类推，直到arr[i]插入到合适的位置后停止。
 * 关键：在外层循环遍历i的过程中，里面还有一个内层循环用来比较i与i之前的数据，直到i插入到合适的位置
 */

/*
 * 插入排序基本思想
 * 将n个元素的数列分为已有序和无序两个部分，如插入排序过程示例下所示：
 * {{a1}，{a2，a3，a4，…，an}}
 * {{a1⑴，a2⑴}，{a3⑴，a4⑴ …，an⑴}}
 * {{a1(n-1），a2(n-1) ，…},{an(n-1)}}
 * 每次处理就是将无序数列的第一个元素与有序数列的元素从后往前逐个进行比较，
 * 找出插入位置，将该元素插入到有序数列的合适位置中。
 */
public class InsertionSort {

    public void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            /*for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }*/

            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
    private static void swap(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

       Integer[] arr = {10,9,8,7,6,5,4,3,2,1};
        // int[] arr = {1,2,3};
        // Student[] arr = {new Student("liming",100), new Student("zhangsan", 11), new Student("xiaohong", 15)};
        SelectionSort.sort(arr);
        for( int  i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
}
