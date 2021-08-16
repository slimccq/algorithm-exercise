package exercise.chapter3.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter3.*;

public class Exercise3_OrderedSequentialSearchST {
    public static void main(String[] args)
    {
        //OrderedST<String, Integer> st = new BinarySearchST<>();
        OrderedST<String, Integer> st = new OrderedSequentialSearchST<>();
        for (int i = 1; i < 10; i++) {
            String key = "" + (100 + i*10);
            st.put(key, i);
        }
        StdOut.printf("min %s\n", st.min());
        StdOut.printf("max %s\n", st.max());
        for (int i = 1; i < 10; i++) {
            String key = "" + (100 + i*10);
            int n = st.get(key);
            if (i != n) {
                StdOut.printf("unexpected: %d != %d\n", n, i);
                return ;
            }
        }
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                String key = "" + (100 + i*10);
                st.delete(key);
            }
        }
        for (String k : st) {
            StdOut.printf("key %s, value: %d\n", k, st.get(k));
        }
        String key = Integer.parseInt(st.max())-1 + "";
        String floorKey = st.floor(key);
        StdOut.printf("floor of %s: %s\n", key, floorKey);
        key = Integer.parseInt(st.min())+1 + "";
        String ceilKey = st.ceiling(key);
        StdOut.printf("ceiling of %s: %s\n", key, ceilKey);

        for (String k : st) {
            String s = st.select(st.rank(k));
            if (!s.equals(k)) {
                StdOut.printf("unexpected: %d != %d\n", s, k);
                return ;
            }
        }
        for (int i = 0; i < st.size(); i++) {
            int r = st.rank(st.select(i));
            if (r != i) {
                StdOut.printf("unexpected: %d != %d\n", r, i);
                return ;
            }
        }
    }
}
