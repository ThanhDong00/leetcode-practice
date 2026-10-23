// package KokoEatingBananas;

import java.util.Arrays;

public class KokoEatingBananas {
    static int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int left = 1;
        int right = maxPile;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long hours = 0;
            for (int pile: piles) {
                // if (pile <= mid) {
                //     hours++;
                // } else {
                //     int multi = (int) (pile + mid - 1) / mid;
                //     hours = hours + multi;
                // }
                hours += (pile + (long) mid - 1) / mid;
                if (hours > h) break;
            }

            if (hours <= h) {
                result = Math.min(mid, result);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    static void test(int[] piles, int h, int expected) {
        int result = minEatingSpeed(piles, h);
        if (result == expected) {
            // System.out.println("Test passed");
            IO.println("Test passed!!");
        } else {
            System.out.println("Test failed: expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        test(new int[]{3, 6, 7, 11}, 8, 4);
        test(new int[]{30, 11, 23, 4, 20}, 5, 30);
        test(new int[]{30, 11, 23, 4, 20}, 6, 23);
    }
}
