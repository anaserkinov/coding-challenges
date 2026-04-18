package leetcode.p0567_permutation_in_string

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        if (s1.length == 1) return s2.contains(s1.first())

        val frequency1 = IntArray(26)
        val frequency2 = IntArray(26)

        repeat(s1.length){
            frequency1[s1[it].code - 97]++
            frequency2[s2[it].code - 97]++
        }

        var matches = 0
        frequency1.forEachIndexed { index, i ->
            if (i == frequency2[index]) matches ++
        }

        var l = 0
        var r = s1.length - 1
        while (r < s2.length){
            if (matches == 26) return true
            val lCode = s2[l++].code - 97
            if (frequency1[lCode] == frequency2[lCode])
                matches--
            frequency2[lCode]--
            if (frequency1[lCode] == frequency2[lCode])
                matches++

            r++
            if (r < s2.length) {
                val rCode = s2[r].code - 97
                frequency2[rCode] ++
                if (frequency1[rCode] == frequency2[rCode])
                    matches ++
                else if (frequency1[rCode] == frequency2[rCode] - 1)
                    matches --
            }
        }
        return false
    }
}