public class SameTree {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    TreeNode p1 = new TreeNode(null);
    TreeNode q1 = new TreeNode(null);

    IO.println(isSameTree(p1, q1));

    TreeNode p2 = TreeNode.build(new Integer[] { 1, 2, 3, 4, 5 });
    TreeNode q2 = TreeNode.build(new Integer[] { 1, 3, 2, 4, 5 });

    IO.println(isSameTree(p2, q2));
  }
}
