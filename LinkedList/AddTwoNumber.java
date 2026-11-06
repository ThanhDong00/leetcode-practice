public class AddTwoNumber {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int v1 = l1 != null ? l1.val : 0;
      int v2 = l2 != null ? l2.val : 0;

      int total = v1 + v2 + carry;
      carry = total / 10;
      current.next = new ListNode(total % 10);
      current = current.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode.print(
      addTwoNumbers(ListNode.build(2, 4, 3), ListNode.build(5, 6, 4))
    );

    ListNode.print(addTwoNumbers(ListNode.build(9, 9, 9), ListNode.build(1)));

    ListNode.print(
      addTwoNumbers(ListNode.build(9, 9, 9), ListNode.build(9, 9))
    );

    ListNode.print(addTwoNumbers(ListNode.build(0), ListNode.build(0)));
  }
}
