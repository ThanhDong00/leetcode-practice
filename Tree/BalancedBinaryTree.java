public class BalancedBinaryTree {

  public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

  private static int height(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l = height(root.left);
    if (l == -1) return -1;

    int r = height(root.right);
    if (r == -1) return -1;

    if (Math.abs(l - r) > 1) {
      return -1;
    }

    return 1 + Math.max(l, r);
  }

  public static void main(String[] args) {
    TreeNode a = TreeNode.build(new Integer[] { 3, 9, 20, null, null, 15, 7 });
    TreeNode.printTree(a);
    IO.println(isBalanced(a)); // true

    TreeNode b = TreeNode.build(new Integer[] {
      1,
      2,
      2,
      3,
      3,
      null,
      null,
      4,
      4,
    });
    TreeNode.printTree(b);
    IO.println(isBalanced(b)); // false

    TreeNode c = new TreeNode(null);
    TreeNode.printTree(c);
    IO.println(isBalanced(c)); // true
  }
}
