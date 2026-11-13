public class InvertBinaryTree {

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    root.left = right;
    root.right = left;

    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(
      4,
      new TreeNode(2, new TreeNode(1), new TreeNode(3)),
      new TreeNode(7, new TreeNode(6), new TreeNode(9))
    );

    IO.println("Original tree:");
    TreeNode.printTree(root);

    invertTree(root);
    IO.println("\nInverted tree:");
    TreeNode.printTree(root);
  }
}
