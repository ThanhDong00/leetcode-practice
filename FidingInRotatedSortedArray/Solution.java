public class Solution {

  static int search(int[] nums, int target) {
    int left = 0,
      right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  static boolean test(int[] nums, int target, int expected) {
    int result = search(nums, target);
    if (result == expected) {
      System.out.println("Test passed");
      return true;
    } else {
      System.out.println("Test failed: expected " + expected + ", got " + result);
      return false;
    }
  }

  public static void main(String[] args) {
    test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);
    test(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);
    test(new int[]{1}, 0, -1);
    test(new int[]{1}, 1, 0);
  }
}
