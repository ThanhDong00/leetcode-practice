package CarFleet;

import java.util.Arrays;


public class CarFleet {

    static class Solution {
        public int CarFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            double[][] cars = new double[n][2];
            
            for (int i = 0; i < n; i++) {
                cars[i][0] = position[i];
                cars[i][1] = (double) (target - position[i]) / speed[i];
            }
            
            Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
            
            int fleet = 0;
            double lastTime = 0;
            for (int i = 0; i < n; i++) {
                if (cars[i][1] > lastTime) {
                    lastTime = cars[i][1];
                    fleet++;
                }
            }
            
            return fleet;
        }
    }

    static class TestCase {
        int target;
        int[] position;
        int[] speed;
        int expected;

        TestCase(int target, int[] position, int[] speed, int expected) {
            this.target = target;
            this.position = position;
            this.speed = speed;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        TestCase[] testCases = {
            new TestCase(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}, 3),
            new TestCase(10, new int[]{3}, new int[]{3}, 2),
            new TestCase(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}, 1),
        };

        Solution s = new Solution();
        for (TestCase tc: testCases) {
            int result = s.CarFleet(tc.target, tc.position, tc.speed);
            System.out.print("Expected: " + tc.expected + ", Got: " + result);
            if (result != tc.expected) {
                System.out.println(" !!!!! FAILED");
            }
            else {
                System.out.println(" PASSED");
            }
        }
    }
}