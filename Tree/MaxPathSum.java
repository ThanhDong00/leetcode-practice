public class MaxPathSum {

  public static int best;

  public static int maxPathSum(TreeNode root) {
    best = Integer.MIN_VALUE;
    maxGain(root);
    return best;
  }

  public static int maxGain(TreeNode root) {
    if (root == null) return 0;

    int l = Math.max(0, maxGain(root.left));
    int r = Math.max(0, maxGain(root.right));

    best = Math.max(best, root.val + l + r);

    return root.val + Math.max(l, r);
  }

  public static void main(String[] args) {
    TreeNode a = TreeNode.build(new Integer[] {
      -10,
      9,
      20,
      null,
      null,
      15,
      7,
    });
    IO.println(maxPathSum(a)); // 42

    TreeNode b = TreeNode.build(new Integer[] { -3 });
    IO.println(maxPathSum(b)); // -3

    TreeNode c = TreeNode.build(new Integer[] { 1, 2, 3 });
    IO.println(maxPathSum(c)); // 6
  }
}
