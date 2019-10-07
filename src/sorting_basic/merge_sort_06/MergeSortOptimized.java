package sorting_basic.merge_sort_06;

import sorting_basic.insertion_sort_03.InsertionSort;

/**
 * 归并排序
 * 将数组不停的拆分进行排序，直到拆分粒度为1时为递归终止条件
 * 拆分后再进行排序，排序后然后再合并
 * 注意：1，因为要排序的目标数据排序后是直接保存到原数组中，因此排序的过程需要一个辅助数组来保存目标排序的数据
 *       然后遍历辅助数组的数据，因为此时是将排序数组分为两半来比较排序的，因此开始时是将l(i) 和 mid + 1(j)的数据开始进行比较的，
 *       将较小的数据保存到原数组的arr[l](arr[k])处。
 *       2，要注意越界的情况
 * 时间复杂度：O(nlogn)
 *
 * // 优化1： 对于对于arr[mid] <= arr[mid+1]的情况,不进行merge
 * // 优化2：对于小规模数组，使用插入排序会更快；这里可以去掉归并排序if (l >= r) return的终止条件了
 *
 *
 */
public class MergeSortOptimized {
    public void mergeSort(Integer[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
    // 递归使用归并排序，对arr[l..r]的范围进行排序
    private void mergeSort(Integer[] arr, int l, int r) {
        // 这里表示当拆分数组进行排序时，当拆分粒度为1的时候，此时数组本来就是有序的，因此是递归结束的条件
        /*if (l >= r) {
            return;
        }*/
        // 优化2：对于小规模数组，使用插入排序会更快；这里可以去掉归并排序if (l >= r) return的终止条件了
        if (r - l <= 5) {
            new InsertionSort().sort(arr, l ,r);
            return; //必须return回去，否则会递归报错
        }
        int mid = (r + l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 想象一下，分为两部分的数据，当左半部分最右边元素大小小于等于右半部分最左边元素时，此时是不需要再归并排序的
        // 优化1： 对于对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }

    }

    // 将arr[l...mid]和arr[mid + 1...r]两部分进行归并
    private void merge(Integer[] arr, int l, int mid, int r) {
        int[] auxArr = new int[r - l + 1];
        for (int i = l; i <= r; i ++) {
            auxArr[i - l] = arr[i];
        }
        // 初始化时，i指向左半部分的起始索引l；j指向右半部分起始索引位置mid + 1
        int i = l, j = mid + 1;
        // 因为原数组传递进来的是l...r范围的数据，因此这里从l开始遍历，将符合排序规则的数据放回原数组即可
        for (int k = l; k <= r; k ++) {
            // 这里要防止i或j越界的情况，越界指的是当右边第一个元素（举个栗子）比左边都大时，此时i会越界
            if (i > mid) {// 如果左半部分已经全部处理完
                arr[k] = auxArr[j - l];
                j ++;
            } else if (j > r) {// 如果右半部分已经全部处理完
                arr[k] = auxArr[i - l];
                i ++;
            }
            // 这里必须用else if ,否则前面的越界判断将会失效,即会出现数组越界异常
            else if (auxArr[i - l] < auxArr[j - l]) {// 这里必须用辅助数组来比较，注意是auxArr[i - l]，这里比较的是左半部分所指元素小于右半部分所指元素
                arr[k] = auxArr[i - l];// 因此将小的元素放回原数组中
                i ++;
            } else {
                arr[k] = auxArr[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,6,9,4,3,52,5,26,23,64,12};
        new MergeSortOptimized().mergeSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
