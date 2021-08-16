package exercise.chapter3.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter3.ST;
import exercise.chapter3.ArrayST;

// 无序数组实现的符号表
public class Exercise2_ArrayST {
    public static void main(String[] args)
    {
        ST<String, Integer> st = new ArrayST<>();
        for (int i = 1; i <= 10; i++) {
            st.put("" + i, i);
        }
        for (int i = 1; i <= 10; i++) {
            int n = st.get("" + i);
            if (i != n) {
                StdOut.printf("unexpected: %d != %d\n", n, i);
                return ;
            }
        }
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                st.delete("" + i);
            }
        }
    }
}
