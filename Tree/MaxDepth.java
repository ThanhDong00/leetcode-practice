public class MaxDepth {

  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int leftRoot = maxDepth(root.left);
    int rightRoot = maxDepth(root.right);

    return 1 + Math.max(leftRoot, rightRoot);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      4,
      new TreeNode(
        2,
        new TreeNode(1, new TreeNode(0), new TreeNode()),
        new TreeNode(3)
      ),
      new TreeNode(7, new TreeNode(6), new TreeNode(9))
    );

    TreeNode.printTree(root);
    IO.println(maxDepth(root));
  }
}
