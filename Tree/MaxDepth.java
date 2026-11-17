public class MaxDepth {

  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int leftRoot = maxDepth(root.left);
    int rightRoot = maxDepth(root.right);

    return 1 + Math.max(leftRoot, rightRoot);
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.build(new Integer[] {
      4,
      2,
      7,
      1,
      null,
      0,
      3,
      6,
      9,
    });

    TreeNode.printTree(root);
    IO.println(maxDepth(root));
  }
}
