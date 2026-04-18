package leetcode.p0004_median_of_two_sorted_arrays

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var small = nums1
        var big = nums2
        if (big.size < small.size){
            small = nums2
            big = nums1
        }

        val total = small.size + big.size
        val half = (total+1)/2
        var left = 0
        var right = small.size
        while (left <= right){
            val m = (left + right) shr 1
            val portionFromBig = half - m

            val smallLeft = if (m == 0) Int.MIN_VALUE else small[m - 1]
            val smallRight = if (m >= small.size) Int.MAX_VALUE else small[m]

            val bigLeft = if (portionFromBig == 0) Int.MIN_VALUE else big[portionFromBig - 1]
            val bigRight = if (portionFromBig >= big.size) Int.MAX_VALUE else big[portionFromBig]

            if (smallLeft > bigRight)
                right = m - 1
            else if (bigLeft > smallRight)
                left = m + 1
            else {
                return if (total%2 == 0)
                    (max(smallLeft, bigLeft) + min(smallRight, bigRight))/2.0
                else
                    max(smallLeft, bigLeft).toDouble()
            }
        }
        return 0.0
    }
}