public class ReoderList {

  public ListNode reoderList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    // Step 1: Find the middle
    ListNode mid = findMiddle(head);

    // Step 2: Reverse the second half
    ListNode secondHalf = reverseList(mid);

    // Step 3: Merge two halves
    mergeLists(head, secondHalf);

    return head;
  }

  public static ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode secondHalf = slow.next;
    slow.next = null;

    return secondHalf;
  }

  public static ListNode reverseList(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

  public static void mergeLists(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
      ListNode l1Next = l1.next;
      ListNode l2Next = l2.next;

      l1.next = l2;
      l2.next = l1Next;

      l1 = l1Next;
      l2 = l2Next;
    }
  }

  public static void main(String[] args) {
    ListNode head = ListNode.build(1, 2, 3, 4, 5, 6, 7);

    ListNode.print(head);

    ListNode reorderedList = new ReoderList().reoderList(head);

    ListNode.print(reorderedList);
  }
}
