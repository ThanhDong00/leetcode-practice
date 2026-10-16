package TwoSum;
import java.util.*;

public class TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer j = seen.get(target - nums[i]);

                if (j != null) 
                    return new int[]{j, i};
                seen.put(nums[i], i);
            }
            return new int[0];
        }
    }

    static class TestCase {
        int[] nums;
        int target;
        int[] expected;

        TestCase(int[] nums, int target, int[] expected) {
            this.nums = nums;
            this.target = target;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Test case 
        TestCase[] testCases = {
            new TestCase(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            new TestCase(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            new TestCase(new int[]{3, 3}, 6, new int[]{0, 1}),
        };

        for (TestCase tc: testCases) {
            int[] result = s.twoSum(tc.nums, tc.target);

            if (!Arrays.equals(tc.expected, result)) {
                throw new AssertionError("Test case " + Arrays.toString(tc.nums) +  " failed: expected "
                        + Arrays.toString(tc.expected) + ", got " + Arrays.toString(result));
            }

            System.out.println("Test case " + Arrays.toString(tc.nums) + " passed." + 
                    " Expected: " + Arrays.toString(tc.expected) + ", got: " + Arrays.toString(result));
        }
    }
}
