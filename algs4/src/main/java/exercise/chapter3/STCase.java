package exercise.chapter3;

import edu.princeton.cs.algs4.StdOut;

public class STCase {

    public static void main(String[] args) {
        ST<Integer, Integer> st = null;
        if (args[0].equals("array")) {
            st = new ArrayST();
        } else if (args[0].equals("binary_search")) {
            st = new BinarySearchST<>();
        } else {
            st = new SequentialSearchST<>();
        }
        StdOut.printf("size: %d, is empty: %b\n", st.size(), st.isEmpty());
        for (int i = 1; i <= 10; i++) {
            st.put(i, i*10);
        }
        StdOut.printf("size: %d, is empty: %b\n", st.size(), st.isEmpty());
        StdOut.printf("7th %d\n", st.get(7));
        st.delete(7);
        for (Integer key : st) {
            StdOut.printf("key %d, val: %d\n", key, st.get(key));
        }
    }
}
