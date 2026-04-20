package leetcode.p0658_find_k_closest_elements

import kotlin.math.abs

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var left = 0
        var right = k
        while (right < arr.size) {
            val r = abs(arr[right] - x)
            val l = abs(arr[left] - x)
            if (r > l || r == l && arr[right] > arr[left]) break
            left ++
            right ++
        }
        val list = ArrayList<Int>(right - left)
        for (i in left until right) {
            list.add(arr[i])
        }
        return list
    }
}