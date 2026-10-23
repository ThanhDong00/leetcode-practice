public class Solution {

  static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    if (nums[right] > nums[left]) {
      return nums[0];
    }

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return nums[left];
  }

  public static void main(String[] args) {
    IO.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
    IO.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
    IO.println(findMin(new int[] { 8, 11, 13, 15, 17 }));
  }
}
