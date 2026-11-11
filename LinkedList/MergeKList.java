public class MergeKList {

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    if (lists.length == 1) {
      return lists[0];
    }

    ListNode mergedList = divide(lists, 0, lists.length - 1);
    return mergedList;
  }

  private static ListNode divide(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }

    int mid = start + (end - start) / 2;
    ListNode leftList = divide(lists, start, mid);
    ListNode rightList = divide(lists, mid + 1, end);
    return merge(leftList, rightList);
  }

  private static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }

      current = current.next;
    }

    current.next = l1 != null ? l1 : l2;

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode l1 = ListNode.build(1, 2, 4, 6, 8);
    ListNode l2 = ListNode.build(1, 3, 7);
    ListNode l3 = ListNode.build(9, 10);

    ListNode[] lists = { l1, l2, l3 };

    ListNode.print(mergeKLists(lists));
  }
}

// This Solution uses Divide and Conquer approach to merge k sorted linked lists.
// First, it divides the lists into two halves and recursively into single lists. Second, it merges them back together.
// Time complexity is O(n log k), where n is the total number of nodes in all lists and k is the number of lists. Because to merge the lists, we need to loop through all the nodes so the time complexity is O(n) and we divide the lists into two halves log k times.
