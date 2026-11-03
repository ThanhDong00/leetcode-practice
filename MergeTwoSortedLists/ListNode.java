public class ListNode {

  int val;
  ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
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
}
