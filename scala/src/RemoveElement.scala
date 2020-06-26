object RemoveElement {
    def removeElement(nums: Array[Int], to_remove: Int): Int = {

        var running_pointer = 0

        for (i <- nums.indices) {
            if (nums(i) != to_remove) {
                nums(running_pointer) = nums(i)
                running_pointer += 1
            }
        }

        running_pointer

    }
}
