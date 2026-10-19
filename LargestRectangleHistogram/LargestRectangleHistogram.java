package LargestRectangleHistogram;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int currentIndex = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                int height = heights[currentIndex];
                int area = (right - left - 1) * height;
                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int currentIndex = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = n;
            int height = heights[currentIndex];
            int area = (right - left - 1) * height;
            maxArea = Math.max(maxArea, area);
        }   

        return maxArea;
    }

    static int failed = 0;

    static void check(int expected, int... h) {
        int result = new LargestRectangleHistogram().largestRectangleArea(h);
        if (result != expected) {
            failed++;
            System.out.println("[FAIL] " + Arrays.toString(h) + "expected = " + expected + "result = " + result );
        }
    }

    public static void main(String args[]) {
        check(10, 2, 1, 5, 6, 2, 3);
        check(4, 2, 4);
        check(5, 5);
        check(0, 0);
        check(0);
        check(0, 0, 0, 0);
        check(9, 3, 4, 5);
        check(9, 1, 2, 3, 4, 5);
        check(9, 5, 4, 3, 2, 1);
        check(16, 4, 4, 4, 4);
        check(2, 2, 0, 2);
        check(12, 6, 7, 0, 3, 3, 3);
        check(15, 1, 5, 5, 5);
        check(15, 5, 5, 5, 1);
        check(5, 5, 1, 5);
        check(5, 2, 5, 1, 5, 2);
        check(6, 1, 2, 3, 2, 1);
        check(100, 1, 1, 100, 1, 1);
        check(14, 2, 2, 2, 2, 2, 2, 2);
        check(30000, 10000, 10000, 10000);
        check(6, 4, 2, 0, 3, 2, 5);
        check(20, 3, 6, 5, 7, 4, 8, 1, 0);

        int[] big = new Random(12345).ints(100_000, 0, 10_001).toArray(); // hiệu năng
        long start = System.currentTimeMillis();
        new LargestRectangleHistogram().largestRectangleArea(big);
        System.out.println("n = 100000: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println(failed == 0 ? "All PASS" : failed + " test FAIL");
    }
}
