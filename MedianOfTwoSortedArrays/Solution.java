public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // fisrt array must shorter
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;
    // half of total length but have to add 1 to handle odd length case
    // Example: 1,2,3,4,5 => half = 3 => left half = 1,2,3 and right half = 4,5
    int half = (m + n + 1) / 2;

    // Search on shorter array 
    int low = 0;
    // high is equal to m because we can take all elements from nums1 into left half
    int high = m;
    while (low <= high) {
      int i = (high + low) / 2;
      int j = half - i;

      int aLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
      int aRight = i == m ? Integer.MAX_VALUE : nums1[i];
      int bLeft = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
      int bRight = j == n ? Integer.MAX_VALUE : nums2[j];

      if (aLeft <= bRight && bLeft <= aRight) {
        int maxLeft = Integer.max(aLeft, bLeft);

        if ((m + n) % 2 == 1) {
          return maxLeft;
        } else {
          int minRight = Integer.min(aRight, bRight);
          return ((double) maxLeft + minRight) / 2;
        }
      } else if (aLeft > bRight) {
        high = i - 1;
      } else {
        low = i + 1;
      }
    }
    throw new IllegalArgumentException("Invalid Input");
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(
      s.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 })
    ); // 2.0
    System.out.println(
      s.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 })
    ); // 2.5
    System.out.println(
      s.findMedianSortedArrays(
        new int[] { 1, 2 },
        new int[] { 4, 5, 6, 7, 8, 9 }
      )
    ); // 5.5
    System.out.println(
      s.findMedianSortedArrays(
        new int[] { 1, 2 },
        new int[] { 4, 5, 6, 7, 8, 9, 10 }
      )
    ); // 6.0
    System.out.println(s.findMedianSortedArrays(new int[] {}, new int[] { 5 })); // 5.0
    System.out.println(
      s.findMedianSortedArrays(new int[] { 10, 11 }, new int[] { 1, 2, 3, 4 })
    ); // 3.5
  }
}
