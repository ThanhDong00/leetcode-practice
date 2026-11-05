import java.util.List;

public class RemoveNthFromEnd {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head,
      fast = head;

    if (head == null || n <= 0) {
      IO.println(
        "Invalid input: head is null or n is less than or equal to 0."
      );
      return head;
    }

    try {
      for (int i = 0; i < n; i++) {
        fast = fast.next;
      }
    } catch (Exception e) {
      IO.println("N is greater than the length of the linked list.");
      return head;
    }

    if (fast == null) {
      return head.next;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.build(1, 2, 3, 4, 5);
    int n = 2;

    ListNode result = removeNthFromEnd(head, n);

    ListNode.print(result);
  }
}
