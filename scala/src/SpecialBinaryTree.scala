object SpecialBinaryTree {

    private var smallest: Integer = _
    private var second_smallest: Integer = _

    def traverseTree(root: TreeNode): Int = {

        if (root != null) {

            if ((second_smallest == null || root.value < second_smallest) && root.value != smallest) {
                if (smallest == null || root.value < smallest) {
                    second_smallest = smallest
                    smallest = root.value
                } else {
                    second_smallest = root.value
                }
            }

            traverseTree(root.right)
            traverseTree(root.left)
        }

        second_smallest
    }

    def findSecondMinimumValue(root: TreeNode): Int = {
        smallest = null
        second_smallest = null

        traverseTree(root)

        if (second_smallest != Int.MaxValue) {
            second_smallest
        } else {
            -1
        }
    }
}
