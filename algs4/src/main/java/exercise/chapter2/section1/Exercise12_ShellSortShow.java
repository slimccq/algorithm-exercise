package exercise.chapter2.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise12_ShellSortShow {

    private static final int FF = 4;

    public static void shellSort(Double[] arr)
    {
        int N = arr.length;
        int gap = 1;
        int k = 1;
        while (gap < N/3) {
            gap = 3 * gap + 1;    // 1,4,13,40,121
            k++;
        }

        for (; gap > 0; gap /= 3)
        {
            int compare_count = 0;
            StdOut.printf("-------------gap %d-------------\n", gap);
            for (int i = gap; i < N; i++)
            {
                for (int j = i; j >= gap; j -= gap)
                {
                    StdOut.printf("compare and sort index %d <--> %d\n", j, j-gap);
                    compare_count++;
                    if (arr[j].compareTo(arr[j-gap]) > 0) {
                        Double tmp = arr[j];
                        arr[j] = arr[j-gap];
                        arr[j-gap] = tmp;
                    } else {
                        break;
                    }
                }
                StdOut.println("-------------end sort---------------\n");
            }
            StdOut.printf("-------------end gap %d-------------\n", gap);
            //double rate = (double)(compare_count) / (double)(N);
            //StdOut.printf("gap: %d, compare %d, rate: %.2f", gap, compare_count, rate);
            if (gap < N) {
                show(arr, --k, gap + "-sorted");
            }
        }
    }

    public static void show(Double[] a, int k, String message)
    {
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++) {
            StdDraw.filledRectangle(i, FF*k + a[i]*(FF-1)*0.5, 0.25, a[i]*(FF-1)*0.5);
        }
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.textLeft(0, FF*k - 0.3, message);
    }

    public static void main(String[] args) {
        int N = 100;
        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        }
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0.0, 1.0);
        }
        shellSort(a);
    }
}
