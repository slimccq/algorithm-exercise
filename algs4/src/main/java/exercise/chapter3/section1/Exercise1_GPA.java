package exercise.chapter3.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter3.BinarySearchST;
import exercise.chapter3.OrderedST;
import exercise.chapter3.OrderedSequentialSearchST;

// 打印GPA分数
public class Exercise1_GPA {
    public static void main(String[] args) {
        OrderedST<Double, String> st = new BinarySearchST<>();
        double[] scores = new double[]{4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00};
        String[] gpaList = new String[]{"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        for (int i = 0; i < scores.length; i++) {
            st.put(scores[i], gpaList[i]);
        }

        double score = Double.parseDouble(args[0]);
        for (int i = 0; i < scores.length; i++) {
            if (score >= scores[i]) {
                String gpa = st.get(scores[i]);
                StdOut.printf("GPA score %f is %s\n", score, gpa);
                break;
            }
        }
    }
}
