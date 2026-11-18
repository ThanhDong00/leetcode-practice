public class Diameter {

  private static int best;

  public static int diameter(TreeNode root) {
    best = 0;
    depth(root);
    return best;
  }

  public static int depth(TreeNode root) {
    if (root == null) return 0;

    int leftSide = depth(root.left);
    int rightSide = depth(root.right);

    best = Math.max(best, leftSide + rightSide);

    return 1 + Math.max(leftSide, rightSide);
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.build(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
    TreeNode.printTree(root);
    IO.println(diameter(root));
  }
}
