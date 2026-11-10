public class FindDuplicate {

  public static int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int finder = 0;

    while (slow != finder) {
      slow = nums[slow];
      finder = nums[finder];
    }

    return slow;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 3 };
    IO.println(findDuplicate(nums));
  }
}
