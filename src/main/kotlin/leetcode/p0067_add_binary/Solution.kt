package leetcode.p0067_add_binary

import kotlin.math.max

class Solution {
    fun addBinary(a: String, b: String): String {
        var carry = 0
        var aI = a.length - 1
        var bI = b.length - 1
        val sb = StringBuilder(max(aI, bI))
        while (aI >= 0 || bI >= 0){
            var sum = carry
            if (aI >= 0) sum += a[aI--].code - 48
            if (bI >= 0) sum += b[bI--].code - 48
            sb.append(sum % 2)
            carry = sum/2
        }
        if (carry == 1) sb.append(1)
        return sb.reverse().toString()
    }
}
