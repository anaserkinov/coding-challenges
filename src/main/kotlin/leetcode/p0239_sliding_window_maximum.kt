package leetcode.p0239_sliding_window_maximum

class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val queue = ArrayDeque<Int>()
        var l = 0
        var r = 0
        val result = IntArray(nums.size - k + 1)

        while (r < nums.size){
            val rValue = nums[r]
            while (queue.isNotEmpty() && queue.last() < rValue)
                queue.removeLast()
            queue.addLast(rValue)
            if (r - l + 1== k){
                result[r + 1 - k] = queue.first()
                if (queue.first() == nums[l])
                    queue.removeFirst()
                l ++
            }
            r ++
        }
        return result
    }
}