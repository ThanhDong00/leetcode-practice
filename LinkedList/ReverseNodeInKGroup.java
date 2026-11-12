public class ReverseNodeInKGroup {

  private static ListNode getKNode(ListNode head, int k) {
    while (head != null && k > 0) {
      head = head.next;
      k = k - 1;
    }
    return head;
  }

  public static ListNode reverseNodeInKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k <= 1) {
      return head;
    }

    ListNode groupTail = getKNode(head, k - 1);
    if (groupTail == null) return head;

    // Detach group
    ListNode nextGroupHead = groupTail.next;
    groupTail.next = null;

    ListNode reversedHead = ReverseList.reverseList(head);
    head.next = reverseNodeInKGroup(nextGroupHead, k);

    return reversedHead;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.build(1, 2, 3, 4, 5, 6, 7, 8);

    ListNode.print(reverseNodeInKGroup(head, 3));
  }
}
