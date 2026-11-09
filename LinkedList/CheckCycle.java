public class CheckCycle {

  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head,
      fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.build(1, 2, 3, 4, 5);
    System.out.println(hasCycle(head));

    head.next.next.next.next = head.next;
    System.out.println(hasCycle(head));
  }
}
