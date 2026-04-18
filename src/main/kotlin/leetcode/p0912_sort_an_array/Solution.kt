package leetcode.p0912_sort_an_array

class Solution {

    private fun heap(nums: IntArray, heapSize: Int, index: Int){
        var largest = index
        val left = 2 * index + 1
        val right = 2 * index + 2

        if (left < heapSize && nums[left] > nums[largest])
            largest = left

        if (right < heapSize && nums[right] > nums[largest])
            largest = right

        if (largest != index) {
            nums[index] = nums[largest].also {
                nums[largest] = nums[index]
            }
            heap(nums, heapSize, largest)
        }
    }

    fun sortArray(nums: IntArray): IntArray {
        val size = nums.size
        for (i in size/2 - 1 downTo 0)
            heap(nums, size, i)

        for (end in size - 1 downTo 1) {
            nums[0] = nums[end].also {
                nums[end] = nums[0]
            }
            heap(nums, end, 0)
        }

        return nums
    }
}