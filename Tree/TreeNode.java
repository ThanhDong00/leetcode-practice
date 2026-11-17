import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  // Not implememt yet
  public static TreeNode build(Integer[] vals) {
    if (vals == null || vals[0] == null || vals.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(vals[0]);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;

    while (!queue.isEmpty() && i < vals.length) {
      TreeNode current = queue.poll();

      if (i < vals.length && vals[i] != null) {
        current.left = new TreeNode(vals[i]);
        queue.offer(current.left);
      }
      i++;

      if (i < vals.length && vals[i] != null) {
        current.right = new TreeNode(vals[i]);
        queue.offer(current.right);
      }
      i++;
    }

    return root;
  }

  public static int height(TreeNode root) {
    if (root == null) return 0;

    return 1 + Math.max(height(root.left), height(root.right));
  }

  public static void printTree(TreeNode root) {
    if (root == null) {
      IO.println("Tree is empty.");
      return;
    }

    int h = height(root);
    int maxWidth = (int) Math.pow(2, h) - 1;
    String[][] res = new String[h][maxWidth];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < maxWidth; j++) {
        res[i][j] = " ";
      }
    }

    fillTree(root, res, 0, 0, maxWidth - 1);

    for (String[] row : res) {
      StringBuilder sb = new StringBuilder();
      for (String val : row) {
        sb.append(val);
      }
      IO.println(sb.toString());
    }
  }

  private static void fillTree(
    TreeNode root,
    String[][] res,
    int level,
    int left,
    int right
  ) {
    if (root == null || level >= res.length) return;

    int mid = (left + right) / 2;
    res[level][mid] = String.valueOf(root.val);

    fillTree(root.left, res, level + 1, left, mid - 1);
    fillTree(root.right, res, level + 1, mid + 1, right);
  }
}
