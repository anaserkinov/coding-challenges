package leetcode.p0088_merge_sorted_array

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = n + m - 1
        var m = m - 1
        var n = n - 1
        while (n >= 0){
            nums1[i--] = if (m >= 0) {
                if (nums1[m] > nums2[n]) nums1[m--] else nums2[n--]
            }else nums2[n --]
        }
    }
}