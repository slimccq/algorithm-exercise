package exercise.chapter2.section1;

import exercise.chapter2.SortUtil;

// shell排序的递增序列预先计算并存储在数组中
public class Exercise11_ShellSort {

    public static int[] createShellArray(int N)  {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i]  = 3 * i + 1;    // 1,4,13,40,121
        }
        return array;
    }

    public static void shellSort(Comparable[] arr)
    {
        int[] gaps = createShellArray(arr.length);
        for (int k = 0; k < gaps.length; k++)
        {
            int h = gaps[k];
            for (int i = h; i < arr.length; i++)
            {
                for (int j = i; j >= h && SortUtil.less(arr[j], arr[j-h]); j -= h) {
                    SortUtil.exch(arr, j, j-h);
                }
            }
        }
    }
}
