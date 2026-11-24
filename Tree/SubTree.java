public class SubTree {

  public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) return true;
    if (root == null || subRoot == null) return false;

    return (
      SameTree.isSameTree(root, subRoot) ||
      isSubtree(root.left, subRoot) ||
      isSubtree(root.right, subRoot)
    );
  }

  public static void main(String[] args) {
    // 1. Khớp ở nhánh trái
    TreeNode a = TreeNode.build(new Integer[] { 3, 4, 5, 1, 2 });
    TreeNode sa = TreeNode.build(new Integer[] { 4, 1, 2 });
    IO.println(isSubtree(a, sa)); // true

    // 2. Có node thừa ở dưới, nên KHÔNG khớp (ca dễ sai nhất)
    TreeNode b = TreeNode.build(new Integer[] {
      3,
      4,
      5,
      1,
      2,
      null,
      null,
      null,
      null,
      0,
    });
    TreeNode sb = TreeNode.build(new Integer[] { 4, 1, 2 });
    IO.println(isSubtree(b, sb)); // false

    // 3. subRoot trùng cả cây root
    TreeNode c = TreeNode.build(new Integer[] { 1, 2, 3 });
    IO.println(isSubtree(c, TreeNode.build(new Integer[] { 1, 2, 3 }))); // true

    // 4. subRoot là một node lá
    TreeNode d = TreeNode.build(new Integer[] { 1, 2, 3 });
    IO.println(isSubtree(d, TreeNode.build(new Integer[] { 3 }))); // true

    // 5. Cùng giá trị nhưng khác cấu trúc (con trái vs con phải)
    TreeNode e = TreeNode.build(new Integer[] { 1, 2 });
    IO.println(isSubtree(e, TreeNode.build(new Integer[] { 1, null, 2 }))); // false

    // 6. Nhiều node trùng giá trị với gốc subRoot, chỉ một chỗ khớp thật
    TreeNode f = TreeNode.build(new Integer[] { 1, 1 });
    IO.println(isSubtree(f, TreeNode.build(new Integer[] { 1 }))); // true
  }
}
