public class Solution {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public ListNode iterativeReverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }

    return prev;
  }

  public static ListNode build(int... vals) {
    ListNode dummy = new ListNode(0),
      cur = dummy;
    for (int v : vals) {
      cur.next = new ListNode(v);
      cur = cur.next;
    }
    return dummy.next;
  }

  public static void print(ListNode head) {
    while (head != null) {
      IO.print(head.val + (head.next != null ? " -> " : "-> null"));
      head = head.next;
    }
    IO.println();
  }

  public static void main(String[] args) {
    ListNode head = build(1, 2, 3, 4, 5, 6);
    print(new Solution().iterativeReverseList(head));

    ListNode head2 = build(1, 2, 3);
    print(new Solution().iterativeReverseList(head2));
  }
}
