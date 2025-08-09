/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val leftDepth = maxDepth(root.left)
    val rightDepth = maxDepth(root.right)
    return maxOf(leftDepth, rightDepth) + 1
}

fun main() {
    println(maxDepth(TreeNode(1)))
}
