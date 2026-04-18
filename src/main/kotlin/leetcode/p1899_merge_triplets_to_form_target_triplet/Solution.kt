package leetcode.p1899_merge_triplets_to_form_target_triplet

class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        var check = 0
        triplets.forEach { array ->
            if (array[0] > target[0] || array[1] > target[1] || array[2] > target[2]) return@forEach
            if (array[0] == target[0]) check = check or 0b1
            if (array[1] == target[1]) check = check or 0b10
            if (array[2] == target[2]) check = check or 0b100
            if (check == 0b111) return true
        }
        return false
    }
}