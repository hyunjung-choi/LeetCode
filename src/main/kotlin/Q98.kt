/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

private fun isValidBST(root: TreeNode?): Boolean {
    val values = mutableListOf<Int>()
    inorderTraversal(root, values)

    for (i in 1 until values.size) {
        if (values[i] <= values[i - 1]) return false
    }

    return true
}

private fun inorderTraversal(root: TreeNode?, values: MutableList<Int>) {
    if (root == null) return

    inorderTraversal(root.left, values)
    values.add(root.`val`)
    inorderTraversal(root.right, values)
}

fun main() {
    val validBST = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
        right = TreeNode(8).apply {
            left = TreeNode(7)
            right = TreeNode(9)
        }
    }

    println(isValidBST(validBST))

    val invalidBST = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(6) // 이게 문제!
        }
        right = TreeNode(8).apply {
            left = TreeNode(7)
            right = TreeNode(9)
        }
    }

    println(isValidBST(invalidBST))
}
